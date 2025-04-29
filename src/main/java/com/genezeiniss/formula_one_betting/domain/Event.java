package com.genezeiniss.formula_one_betting.domain;

import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class Event {

    private int sessionKey;
    private String sessionType;
    private String country;
    private Instant dateStart;
    private List<Driver> drivers;
}
