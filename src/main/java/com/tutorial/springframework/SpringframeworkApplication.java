package com.tutorial.springframework;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tutorial.springframework.di.DI;

@SpringBootApplication
public class SpringframeworkApplication implements CommandLineRunner{

	@Autowired
	private DI di;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringframeworkApplication.class, args);
	}

	@Override
    public void run(String... args) throws Exception {
        di.implDI();
    }
}

/*
 * DI is a class to use the functionality for Dependency Injection in Spring.
 * CommandLineRunner interface is a functional interface that allows you to run code after the Spring application context has been initialized.
 * It is typically used to execute code at application startup, making it useful for tasks such as initialization, setup, or executing specific commands right after the application starts.
 * 
 * Implement CommandLineRunner only when you need to execute some code after Spring context in initialized.
 * It will call the run method and you can write that logic in that block.
 */
