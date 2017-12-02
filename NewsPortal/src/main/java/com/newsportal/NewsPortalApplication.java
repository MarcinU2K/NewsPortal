package com.newsportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerExceptionResolver;

@SpringBootApplication
public class NewsPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsPortalApplication.class, args);
	}

	@Bean
	public HandlerExceptionResolver sentryExceptionResolver() {
	    return new io.sentry.spring.SentryExceptionResolver();
	}
	
	@Bean
	public ServletContextInitializer sentryServletContextInitializer() {
	    return new io.sentry.spring.SentryServletContextInitializer();
	}
}
