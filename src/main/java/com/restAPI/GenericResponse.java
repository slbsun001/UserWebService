package com.restAPI;

public class GenericResponse {

	private Integer code;
    private String message;

	public GenericResponse() {
	}
	
	public GenericResponse(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public GenericResponse(ClientMessage message) {
		this.message = message.getMessage();
	}
	
	public GenericResponse(String message) {
		this.message = message;
	}
	
	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

}
