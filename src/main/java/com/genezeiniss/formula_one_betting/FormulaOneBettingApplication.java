package com.genezeiniss.formula_one_betting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class FormulaOneBettingApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormulaOneBettingApplication.class, args);
	}

}
