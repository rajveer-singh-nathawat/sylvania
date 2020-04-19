package com.org.sylvania;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SylvaniaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SylvaniaApplication.class, args);
	}

}
