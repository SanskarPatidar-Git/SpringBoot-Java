package com.tutorial.springframework.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Animal {

	/*
	 * Constructor Injection:
	 * Injecting the bean in class Constructor.
	 * Creating bean for this class depends on another bean to be injected.
	 * When Spring creates bean for this class It also requires bean of Food class.
	 * So either make it Component or provide a bean in Config.
	 */
	@Autowired
	public Animal(Food food) {
		System.out.println("Animal is eating "+food.getFoodName()); 
	}
	
	public void sleep() {
		System.out.println("Animal is sleeping.......");
	}
}
