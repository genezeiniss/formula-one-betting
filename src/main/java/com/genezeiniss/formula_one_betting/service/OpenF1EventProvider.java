package com.genezeiniss.formula_one_betting.service;

import com.genezeiniss.formula_one_betting.domain.Driver;
import com.genezeiniss.formula_one_betting.domain.Event;
import com.genezeiniss.formula_one_betting.rest.event_provider.OpenF1Client;
import com.genezeiniss.formula_one_betting.rest.model.mapper.OpenF1ModelMapper;
import com.genezeiniss.formula_one_betting.rest.model.response.OpenF1DriverResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class OpenF1EventProvider implements EventProvider {

    private final OpenF1Client openF1Client;
    private final OpenF1ModelMapper openF1ModelMapper;
    private final ConcurrentHashMap<Integer, List<Driver>> driversMap = new ConcurrentHashMap<>();

    @Override
    public List<Event> getEvents(String year, String country, String sessionType) {
        return openF1Client.getSessions(year, country, sessionType)
                .stream()
                .map(openF1Session -> {
                    Event event = openF1ModelMapper.mapToEvent(openF1Session);
                    event.setDrivers(getSessionDrivers(openF1Session.getSessionKey()));
                    return event;
                })
                .toList();
    }

    private List<Driver> getSessionDrivers(int sessionKey) {

        if (driversMap.containsKey(sessionKey)) {
            return driversMap.get(sessionKey);
        }

        List<OpenF1DriverResponse> openF1Drivers = openF1Client.getDrivers(sessionKey);
        List<Driver> drivers = openF1ModelMapper.mapToDrivers(openF1Drivers);
        driversMap.put(sessionKey, drivers);
        return drivers;
    }
}
