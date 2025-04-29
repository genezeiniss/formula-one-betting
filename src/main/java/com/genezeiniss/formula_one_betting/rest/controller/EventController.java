package com.genezeiniss.formula_one_betting.rest.controller;

import com.genezeiniss.formula_one_betting.domain.Event;
import com.genezeiniss.formula_one_betting.rest.model.mapper.EventModelMapper;
import com.genezeiniss.formula_one_betting.rest.model.response.EventsResponse;
import com.genezeiniss.formula_one_betting.service.EventService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/formula-one/events")
public class EventController {

    private final EventService eventService;
    private final EventModelMapper eventModelMapper;

    @GetMapping
    public EventsResponse getEvents(@RequestParam(required = false) String sessionType,
                                    @RequestParam(required = false) String country,
                                    @RequestParam String year) {
        // todo: currently the year is required, to limit calls to api provider
        // todo: add validation to request params, or else return bad request exception
        List<Event> events = eventService.getEvents(year,
                Strings.isBlank(country) ? null : country,
                Strings.isBlank(sessionType) ? null : sessionType);
        return eventModelMapper.mapEventsToEventResponse(events);
    }
}
