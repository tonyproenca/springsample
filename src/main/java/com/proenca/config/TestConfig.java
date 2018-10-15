package com.proenca.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.proenca.services.DBService;
import com.proenca.services.EmailService;
import com.proenca.services.MockEmailService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired 
	private DBService dbService;
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		dbService.InstantiateTestDatabase();
		return true;
	}

	
	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}
}
