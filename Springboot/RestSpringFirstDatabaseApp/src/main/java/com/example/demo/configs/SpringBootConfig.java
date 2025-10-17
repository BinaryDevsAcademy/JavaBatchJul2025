package com.example.demo.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entites.ContactDetails;

@Configuration
@ComponentScan(basePackages = "com")
public class SpringBootConfig {
	@Bean
	public ContactDetails contactDetails() {
		return new ContactDetails();
	}
}
