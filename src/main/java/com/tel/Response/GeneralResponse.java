package com.tel.Response;

import org.springframework.http.HttpStatus;

public class GeneralResponse {
	
	private HttpStatus status;
	
	private String message;
	
	private Object data;
	
	public HttpStatus getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	

}
