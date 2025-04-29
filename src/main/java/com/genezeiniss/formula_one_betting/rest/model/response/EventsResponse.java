package com.genezeiniss.formula_one_betting.rest.model.response;

import lombok.Data;

import java.util.List;

@Data
public class EventsResponse {

    private List<RestEvent> sessions;
}
