package com.tutorial.springframework.dto;

public class ResponseObjectDto<T>{

	public boolean status;
	public String message;
	private T data;
	
	public ResponseObjectDto(boolean status, String message, T data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
