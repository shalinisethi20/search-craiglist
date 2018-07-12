package com.search.craiglist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfiguration {
	
	@Bean
	public RestTemplate createRestTemplate(){
		return new RestTemplate();
	}

}
