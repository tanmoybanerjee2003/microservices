package edu.tan.poc.smartms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableJpaRepositories(basePackages = "edu.tan.poc.smartms.repository.jpa")
@EnableMongoRepositories(basePackages = "edu.tan.poc.smartms.repository.mongo")
@SpringBootApplication
public class SmartMicroServiceApplication extends SpringBootServletInitializer {
	private static final Class<SmartMicroServiceApplication> applicationClass = SmartMicroServiceApplication.class;

	/**
	 * SpringBootServletInitializer and overriding this method is required if we want to deploy as war
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
		return applicationBuilder.sources(applicationClass);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(applicationClass, args);
	}
}
