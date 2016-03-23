package com.restAPI;

public enum ClientMessage {

	//success messages
	USER_REGISTERED("User registered successfully."),
	USER_UPDATED("User updated successfully."),
	
	//login errors
	INCORRECT_PIN("PIN is incorrect"),
	EMAIL_NOT_REGISTERED("Email not registered"),
	MOBILE_NOT_REGISTERED("Mobile number not registered"),
    
	//validation errors
    MOBILE_NUMBER_REQUIRED("A Mobile Number is required."),
    MOBILE_NUMBER_INVALID("The Mobile Number is not valid."),   
    MISSING_DEVICE_ID("Missing Device ID"),
    MISSING_API_ID("Missing API ID"),
    MISSING_API_KEY("Missing API Key"),
	INVALID_API_KEY("Invalid API Key"),
    PIN_REQUIRED("A pin is required."),
    
    
    MOBILE_ALREADY_REGISTERED("Mobile Number already registered."),
    EMAIL_ALREADY_REGISTERED("Email address already registered."), 
    NOT_AUTHORIZED("Not authorized.");

    private final String value;

    private ClientMessage(String value) {
        this.value = value;
    }
    
    public String getMessage() {
        return value;
    }

	
}
