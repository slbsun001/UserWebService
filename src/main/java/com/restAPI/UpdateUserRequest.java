package com.restAPI;

public class UpdateUserRequest {

	private String firstName;
	private String lastName;
	private String mobile;
	private String emailAddress;

	@SuppressWarnings("unused")
	private UpdateUserRequest() {
	}

	public UpdateUserRequest(String mobile, String firstName, String lastName,String emailAddress) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.emailAddress=emailAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMobile() {
		return mobile;
	}

	@SuppressWarnings("unused")
	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@SuppressWarnings("unused")
	private void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@SuppressWarnings("unused")
	private void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

}