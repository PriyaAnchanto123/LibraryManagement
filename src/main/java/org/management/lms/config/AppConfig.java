package org.management.lms.config;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	  @Bean
	    public Date currentDate() {
	        return new Date(System.currentTimeMillis());
	    }
}
