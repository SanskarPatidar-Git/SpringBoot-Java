package com.tutorial.springframework.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/*
 * Cross cutting concern - ( Aspect Oriented Programming)
 * Here we are doing only logging aspects.
 * 
 * Now there is no need to write logs while we can focus on business logics0.
 * Logging is managed by Spring.
 * Be carefull with Point cut expression. If it is not valid it will not work.
 * 
 * If you are using spring boot starter dependency so Aspect comes inbuilt.
 */

@Aspect
@Component
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class LoggingAspect {

	 /*
	  * Executes after any method in this given package is called.
	  * This given expression is called point cut expression.
	  * By using JoinPoint we can get additional of the method info like method name , args etc.
	  */

	@After("execution(* com.tutorial.springframework..*(..))")
	public void after(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("ASPECT-------\nAfter:: Method: "+methodName+"\nArgs:\n");
		for(Object arg : args)
			System.out.println(arg.toString());
	}
	
	/*
	 * @Pointcut
	 * You can define an individual point cut expression also which can be used from multiple methods.
	 * Here we define a point cut for a log of only a methods of class who are annoted with @Service.
	 * This is annotation based logging.
	 * If you want to log for controllers you can provide path of @RestController or @Repository etc.
	 * 
	 */
	
	@Pointcut("within(@org.springframework.stereotype.Service *)")
	public void servicePointCut() { }
	
	@Before("servicePointCut()")
	public void beforeService() {
		System.out.println("beforeService()");
	}
}

/*
 * @After -> method calls after execution.
 * @Before -> before execution.
 * @Around -> both before and after.
 * 
 * There are multiple PointCut expressions also 
 * like execution , within , annotation , args etc
 */
