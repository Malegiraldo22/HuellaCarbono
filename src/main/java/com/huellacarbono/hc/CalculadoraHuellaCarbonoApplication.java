package com.huellacarbono.hc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.huellacarbono.hc"})
public class CalculadoraHuellaCarbonoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculadoraHuellaCarbonoApplication.class, args);
	}

}
