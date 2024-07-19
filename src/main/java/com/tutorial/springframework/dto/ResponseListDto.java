package com.tutorial.springframework.dto;

import java.util.List;

public class ResponseListDto<T> {

	public boolean status;
	public String message;
	private List<T> data;
	
	public ResponseListDto(boolean status, String message, List<T> data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
}
