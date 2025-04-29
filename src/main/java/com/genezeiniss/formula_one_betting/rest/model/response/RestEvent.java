package com.genezeiniss.formula_one_betting.rest.model.response;

import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class RestEvent {

    private int sessionKey;
    private String sessionType;
    private String country;
    private Instant dateStart;
    private List<RestDriver> driverMarket;
}
