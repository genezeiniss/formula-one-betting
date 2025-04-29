package com.genezeiniss.formula_one_betting.rest.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OpenF1DriverResponse {

    @JsonProperty("driver_number")
    private int driverId;
    @JsonProperty("full_name")
    private String fullName;
}
