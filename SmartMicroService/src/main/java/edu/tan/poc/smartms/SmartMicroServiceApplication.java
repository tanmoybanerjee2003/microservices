package edu.tan.poc.smartms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SmartMicroServiceApplication extends SpringBootServletInitializer {
	private static final Class<SmartMicroServiceApplication> applicationClass = SmartMicroServiceApplication.class;

	public static void main(String[] args) {
		SpringApplication.run(applicationClass, args);
	}
	
	/**
	 * SpringBootServletInitializer and overriding this method is required if we want to deploy as war
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
		return applicationBuilder.sources(applicationClass);
	}

}
