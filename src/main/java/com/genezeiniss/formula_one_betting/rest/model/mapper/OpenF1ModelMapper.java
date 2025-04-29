package com.genezeiniss.formula_one_betting.rest.model.mapper;

import com.genezeiniss.formula_one_betting.domain.Driver;
import com.genezeiniss.formula_one_betting.domain.Event;
import com.genezeiniss.formula_one_betting.rest.model.response.OpenF1DriverResponse;
import com.genezeiniss.formula_one_betting.rest.model.response.OpenF1SessionResponse;
import com.genezeiniss.formula_one_betting.utils.WinOddsCalculator;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OpenF1ModelMapper {

    private final ModelMapper modelMapper;

    @PostConstruct
    public void init() {
        modelMapper.createTypeMap(OpenF1DriverResponse.class, Driver.class)
                .addMapping(OpenF1DriverResponse::getDriverId, Driver::setId)
                .addMapping(OpenF1DriverResponse::getFullName, Driver::setName);
    }

    public Event mapToEvent(OpenF1SessionResponse openF1Session) {
        return modelMapper.map(openF1Session, Event.class);
    }

    public List<Driver> mapToDrivers(List<OpenF1DriverResponse> openF1Drivers) {
       return openF1Drivers.stream()
                .map(openF1Driver -> {
                    Driver driver = modelMapper.map(openF1Driver, Driver.class);
                    driver.setWinOdds(WinOddsCalculator.calculate());
                    return driver;
                })
                .toList();
    }
}
