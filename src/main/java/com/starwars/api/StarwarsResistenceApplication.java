package com.starwars.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author Aryaovalldo Cleef
 *
 */

@SpringBootApplication
@EntityScan(basePackages = { "com.starwars.api.model" })
public class StarwarsResistenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarwarsResistenceApplication.class, args);
	}

}
