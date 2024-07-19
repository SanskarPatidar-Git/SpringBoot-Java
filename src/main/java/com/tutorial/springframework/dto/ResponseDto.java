package com.tutorial.springframework.dto;

public class ResponseDto {

	public boolean status;
	public String message;
	
	public ResponseDto(boolean status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	
	
}
