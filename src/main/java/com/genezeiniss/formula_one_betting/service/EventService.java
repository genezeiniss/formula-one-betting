package com.genezeiniss.formula_one_betting.service;

import com.genezeiniss.formula_one_betting.domain.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventProvider eventProvider;

    public List<Event> getEvents(String year, String country, String sessionType) {
        return eventProvider.getEvents(year, country, sessionType);
    }
}
