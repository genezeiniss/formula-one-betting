package com.genezeiniss.formula_one_betting.fixture;

import com.genezeiniss.formula_one_betting.domain.Driver;
import com.genezeiniss.formula_one_betting.domain.Event;
import com.genezeiniss.formula_one_betting.rest.model.response.OpenF1DriverResponse;
import com.genezeiniss.formula_one_betting.rest.model.response.OpenF1SessionResponse;

import java.time.Instant;
import java.util.List;

public class EventFixture {

    // Session constants
    public static final int DEFAULT_SESSION_KEY = 123;
    public static final String RACE_SESSION_TYPE = "Race";
    public static final String MONACO_COUNTRY = "Monaco";
    public static final String DEFAULT_DATE = "2023-05-28T13:00:00Z";

    // Driver constants
    public static final int HAMILTON_DRIVER_ID = 44;
    public static final int VERSTAPPEN_DRIVER_ID = 33;
    public static final String HAMILTON_NAME = "Lewis Hamilton";
    public static final String VERSTAPPEN_NAME = "Max Verstappen";
    public static final int HAMILTON_WIN_ODDS = 3;
    public static final int VERSTAPPEN_WIN_ODDS = 2;

    public static OpenF1SessionResponse stubOpenF1Session() {
        var session = new OpenF1SessionResponse();
        session.setSessionKey(DEFAULT_SESSION_KEY);
        session.setSessionType(RACE_SESSION_TYPE);
        session.setCountry(MONACO_COUNTRY);
        session.setDateStart(Instant.parse(DEFAULT_DATE));
        return session;
    }

    public static List<OpenF1DriverResponse> stubOpenF1Drivers() {
        var driver1 = new OpenF1DriverResponse();
        driver1.setDriverId(HAMILTON_DRIVER_ID);
        driver1.setFullName(HAMILTON_NAME);

        var driver2 = new OpenF1DriverResponse();
        driver2.setDriverId(VERSTAPPEN_DRIVER_ID);
        driver2.setFullName(VERSTAPPEN_NAME);

        return List.of(driver1, driver2);
    }

    public static Event stubEvent() {
        var event = new Event();
        event.setSessionKey(DEFAULT_SESSION_KEY);
        event.setSessionType(RACE_SESSION_TYPE);
        event.setCountry(MONACO_COUNTRY);
        event.setDateStart(Instant.parse(DEFAULT_DATE));
        event.setDrivers(List.of());
        return event;
    }

    public static Event stubEventWithDrivers() {
        var event = stubEvent();

        var driver1 = new Driver();
        driver1.setId(String.valueOf(HAMILTON_DRIVER_ID));
        driver1.setName(HAMILTON_NAME);
        driver1.setWinOdds(HAMILTON_WIN_ODDS);

        var driver2 = new Driver();
        driver2.setId(String.valueOf(VERSTAPPEN_DRIVER_ID));
        driver2.setName(VERSTAPPEN_NAME);
        driver2.setWinOdds(VERSTAPPEN_WIN_ODDS);

        event.setDrivers(List.of(driver1, driver2));
        return event;
    }
}
