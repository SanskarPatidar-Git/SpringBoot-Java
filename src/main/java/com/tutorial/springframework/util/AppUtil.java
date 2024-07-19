package com.tutorial.springframework.util;

import com.tutorial.springframework.dto.ResponseObjectDto;

public class AppUtil {

	public static <T> ResponseObjectDto<T> getresponseObjectDto(
			 boolean status , String message , T data) {
		return new ResponseObjectDto<T>(status, message, data);
	}
}
