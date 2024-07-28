package com.tutorial.springframework.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/*
 * @Configuration ->
 * Provides bean within the application using @Bean.
 * 
 * @ComponentScan(basePackages = "com.tutorial.springframework")
 * Annotation in Spring is used to specify the packages that Spring should scan for annotated components, 
 * such as @Component, @Service, @Repository, and @Controller. 
 * It enables Spring’s automatic discovery and registration of beans within the Spring application context.
 */

@Configuration
public class DIConfig {

	@Bean(name = "triangle")
	public Shape getTriangle() {
		return new Triangle();
	}
	
	@Bean(name = "circle")
	public Shape getCircle() {
		return new Circle();
	}
	
	@Bean
	public Food getFood() {
		return new Food();
	}
	
	@Bean
	@Scope("prototype")
	public User getUser() {
		return new User();
	}
}
