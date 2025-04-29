package com.genezeiniss.formula_one_betting.rest.model.mapper;

import com.genezeiniss.formula_one_betting.configuration.FormulaOneBettingConfig;
import com.genezeiniss.formula_one_betting.fixture.EventFixture;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.genezeiniss.formula_one_betting.fixture.EventFixture.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpenF1ModelMapperTest {

    private static OpenF1ModelMapper openF1ModelMapper;

    @BeforeAll
    static void setup() {
        openF1ModelMapper = new OpenF1ModelMapper(new FormulaOneBettingConfig().modelMapper());
        openF1ModelMapper.init();
    }

    @Test
    @DisplayName("map to event - assert session fields")
    void mapToEventAssertSessionFields() {
        var session = EventFixture.stubOpenF1Session();
        var event = openF1ModelMapper.mapToEvent(session);

        assertEquals(session.getSessionKey(), event.getSessionKey(), "session key");
        assertEquals(session.getSessionType(), event.getSessionType(), "session type");
        assertEquals(session.getCountry(), event.getCountry(), "country");
        assertEquals(session.getDateStart(), event.getDateStart(), "date start");
    }

    @Test
    @DisplayName("map to drivers - assert drivers fields")
    void mapToDriversAssertFields() {
        var openF1Drivers = EventFixture.stubOpenF1Drivers();
        var drivers = openF1ModelMapper.mapToDrivers(openF1Drivers);

        assertEquals(2, drivers.size());

        var driver1 = drivers.get(0);
        assertEquals(String.valueOf(HAMILTON_DRIVER_ID), driver1.getId(), "first driver id");
        assertEquals(HAMILTON_NAME, driver1.getName(), "first driver name");
        assertTrue(driver1.getWinOdds() >= 2 && driver1.getWinOdds() <= 4, "first driver win odds");

        var driver2 = drivers.get(1);
        assertEquals(String.valueOf(VERSTAPPEN_DRIVER_ID), driver2.getId(), "second driver id");
        assertEquals(VERSTAPPEN_NAME, driver2.getName(), "second driver name");
        assertTrue(driver2.getWinOdds() >= 2 && driver2.getWinOdds() <= 4, "second driver win odds");
    }
}
