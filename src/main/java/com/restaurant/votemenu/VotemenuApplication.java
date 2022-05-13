package com.restaurant.votemenu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
(
		scanBasePackages = {"com.restaurant.votemenu"}
)
@ComponentScan({"com.restaurant"})
public class VotemenuApplication {

	public static void main(String[] args) {
		SpringApplication.run(VotemenuApplication.class, args);
	}

}
