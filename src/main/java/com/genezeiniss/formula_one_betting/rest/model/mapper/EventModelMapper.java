package com.genezeiniss.formula_one_betting.rest.model.mapper;

import com.genezeiniss.formula_one_betting.domain.Event;
import com.genezeiniss.formula_one_betting.rest.model.response.EventsResponse;
import com.genezeiniss.formula_one_betting.rest.model.response.RestEvent;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventModelMapper {

    private final ModelMapper modelMapper;

    @PostConstruct
    public void init() {
        modelMapper.createTypeMap(Event.class, RestEvent.class)
                .addMappings(mapper ->
                        mapper.map(Event::getDrivers, RestEvent::setDriverMarket));
    }

    public EventsResponse mapEventsToEventResponse(List<Event> events) {
        EventsResponse response = new EventsResponse();
        response.setSessions(events.stream()
                .map(event -> modelMapper.map(event, RestEvent.class))
                .toList());
        return response;
    }
}
