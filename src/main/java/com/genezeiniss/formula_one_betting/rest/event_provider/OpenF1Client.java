package com.genezeiniss.formula_one_betting.rest.event_provider;

import com.genezeiniss.formula_one_betting.rest.model.response.OpenF1DriverResponse;
import com.genezeiniss.formula_one_betting.rest.model.response.OpenF1SessionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "openF1Client", url = "https://api.openf1.org/v1/")
public interface OpenF1Client {

    @GetMapping("/sessions")
    List<OpenF1SessionResponse> getSessions(@RequestParam("year") String year,
                                            @RequestParam("country_name") String countryName,
                                            @RequestParam("session_type") String sessionType);

    @GetMapping("/drivers")
    List<OpenF1DriverResponse> getDrivers(@RequestParam("session_key") int sessionKey);
}
