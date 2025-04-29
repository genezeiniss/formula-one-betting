package com.genezeiniss.formula_one_betting.service;

import com.genezeiniss.formula_one_betting.domain.Event;

import java.util.List;

public interface EventProvider {

    List<Event> getEvents(String year, String country, String sessionType);
}
