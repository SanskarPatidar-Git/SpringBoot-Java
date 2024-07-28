package com.tutorial.springframework.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;

/*
 * Global Exception handler-
 * Manage and handle exceptions across your entire application in a centralized way. 
 * Any Exception occurs this method will be called.
 * You can specify individual methods according to multiple exception.
 * like: @ExceptionHandler(IllegalArgumentException.class)
 * 
 * If you want to create a Exception handler which handles within Controller.
 * you can create a method using @ExceptionHandler in that respective controller.
 * 
 * NOTE: It will throw error if you define diff methods/blocks for same exception.
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

	/* This will handle any exception*/
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> throwException(Exception e , HandlerMethod handlerMethod){
		
		// from which method does exception arise
		String methodName = handlerMethod.getMethod().getName();
		// from which controller does exception arise
		String controllerName = handlerMethod.getBeanType().getSimpleName();
		
		System.err.println("Exception: Controller->"+controllerName+" Method->"+methodName);
		
		return new ResponseEntity<String>("Error: "+e.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	/* This will handle only IllegalArgumentException as we mentioned in @ExceptionHandler*/
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> throwIllegalArgumentException(){
		return new ResponseEntity<String>("IllegalArgumentException",HttpStatus.BAD_REQUEST);
	}
	
}
