package com.book.api;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.web.filter.RequestContextFilter;


public class APIConfig extends ResourceConfig {
	public APIConfig() {
		
		System.out.println("OK!");
		register(RequestContextFilter.class);
		register(JacksonFeature.class);
		packages("com.book.api");

	}
}
