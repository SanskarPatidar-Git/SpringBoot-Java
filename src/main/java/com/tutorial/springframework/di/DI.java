package com.tutorial.springframework.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/* Dependency Injection or IOC (Inversion of Control)
 * 
 * Spring will provide/create dependency using @Component or by using @Bean in Configuration class.
 * 
 * If you need that spring will provide dependency for that respective class then mark it as Component using @Component.
 * @Component -> Automatically detects and registers beans within the Spring application context.
 * 
 * @Scope() -> Defines a scope of bean. "prototype": create a new object always , "singleton"(default): single object within application.
 * 
 * @Autowired -> Injects the dependency.
 */

@Component
@Scope(scopeName = "prototype")
public class DI {

	/* Field Injection */
	@Autowired
	private Animal animal;
	
	/*
	 * Shape is a interface which is implemented by two classes Triangle and Circle.
	 * So you need to define explicitly bean of which you need to inject either of Circle or Triangle.
	 * @Qualifier -> Used to define the bean name by which it distinguish among multiple beans from Config.
	 * Here, we need a bean of circle. Rest you can check DIConfig.
	 */
	@Autowired
	@Qualifier("circle")
	private Shape shape;
	
	/*Default Scope of beans are Singleton(Single object within application) */
	
	/*
	 * Here we had created a User objects and the beans are provided by Config class DIConfig.
	 * We had mentioned scope in user bean as "prototype" means everytime a new bean will created.
	 * You can see the hashcodes.
	 * Later change the scope to singleton and see hashcodes again.
	 */
	@Autowired
	private User user1;
	
	@Autowired
	private User user2;
	
	
	public void implDI() {
		animal.sleep();
		System.out.println("Shape: "+shape.getShape());
		System.out.println("User Scopes -> HashCodes(user1:"+user1.hashCode()+",user2:"+user2.hashCode()+")");
	}
}
