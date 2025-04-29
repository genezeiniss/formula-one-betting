package com.genezeiniss.formula_one_betting.rest.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.Instant;

@Data
public class OpenF1SessionResponse {

        @JsonProperty("country_name")
        private String country;
        @JsonProperty("date_start")
        private Instant dateStart;
        @JsonProperty("session_key")
        private int sessionKey;
        @JsonProperty("session_type")
        private String sessionType;
}
