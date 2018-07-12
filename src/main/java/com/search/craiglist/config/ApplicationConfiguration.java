package com.search.craiglist.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;

import com.search.craiglist.domain.SearchGateway;
import com.search.craiglist.gateway.CraiglistSearchGateway;

@Configuration
@EnableRetry
public class ApplicationConfiguration {
	
	/*@Bean
	public SearchGateway getSearchGateway(@Value("${com.craiglist.base.url}") String baseUrl, RestTemplate restTemplate){
		return new CraiglistSearchGateway(baseUrl, restTemplate);
	}*/
	
	@Bean
	public SearchGateway getSearchGateway(@Value("${com.craiglist.base.url}") String baseUrl){
		return new CraiglistSearchGateway(baseUrl);
	}
	

}
