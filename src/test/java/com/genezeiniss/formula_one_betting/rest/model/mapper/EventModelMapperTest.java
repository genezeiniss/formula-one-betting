package com.genezeiniss.formula_one_betting.rest.model.mapper;

import com.genezeiniss.formula_one_betting.configuration.FormulaOneBettingConfig;
import com.genezeiniss.formula_one_betting.fixture.EventFixture;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.genezeiniss.formula_one_betting.fixture.EventFixture.*;
import static org.junit.jupiter.api.Assertions.*;

public class EventModelMapperTest {

    private static EventModelMapper eventModelMapper;

    @BeforeAll
    static void setup() {
        eventModelMapper = new EventModelMapper(new FormulaOneBettingConfig().modelMapper());
        eventModelMapper.init();
    }

    @Test
    @DisplayName("map events to response - assert empty list")
    void mapEventsToEventResponseEmptyList() {
        var response = eventModelMapper.mapEventsToEventResponse(List.of());
        assertNotNull(response.getSessions(), "session");
        assertTrue(response.getSessions().isEmpty(), "session is empty");
    }

    @Test
    @DisplayName("map events to response - assert single event fields")
    void mapEventsToEventResponseSingleEvent() {
        var event = EventFixture.stubEvent();
        var response = eventModelMapper.mapEventsToEventResponse(List.of(event));

        var restEvent = response.getSessions().getFirst();
        assertEquals(event.getSessionKey(), restEvent.getSessionKey(), "session key");
        assertEquals(event.getSessionType(), restEvent.getSessionType(), "session type");
        assertEquals(event.getCountry(), restEvent.getCountry(), "country");
        assertEquals(event.getDateStart(), restEvent.getDateStart(), "date start");
    }

    @Test
    @DisplayName("map events to response - assert driver market mapping")
    void mapEventsToEventResponseDriverMarketMapping() {
        var event = EventFixture.stubEventWithDrivers();
        var response = eventModelMapper.mapEventsToEventResponse(List.of(event));

        var restEvent = response.getSessions().getFirst();
        assertNotNull(restEvent.getDriverMarket());
        assertEquals(2, restEvent.getDriverMarket().size());

        var restDriver1 = restEvent.getDriverMarket().getFirst();
        assertEquals(String.valueOf(HAMILTON_DRIVER_ID), restDriver1.getId(), "first driver id");
        assertEquals(HAMILTON_NAME, restDriver1.getName(), "first driver name");
        assertEquals(HAMILTON_WIN_ODDS, restDriver1.getWinOdds(), "first driver win odds");

        var restDriver2 = restEvent.getDriverMarket().get(1);
        assertEquals(String.valueOf(VERSTAPPEN_DRIVER_ID), restDriver2.getId(), "second driver id");
        assertEquals(VERSTAPPEN_NAME, restDriver2.getName(), "second driver name");
        assertEquals(VERSTAPPEN_WIN_ODDS, restDriver2.getWinOdds(), "second driver win odds");
    }
}
