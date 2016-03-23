package com.restAPI;

public class RegisterUserRequest {

	// private static final String METHOD_NAME = "registerUser";

	private String mobile;
	private String emailAddress;
	private String firstName;
	private String lastName;
	private String pinHash;

	@SuppressWarnings("unused")
	private RegisterUserRequest() {
		// keep me private
	}

	public RegisterUserRequest(String mobile, String emailAddress, String firstName, String lastName,
			String pinHash) {
		this.mobile = mobile;
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pinHash = pinHash;
	}

	@SuppressWarnings("unused")
	private void setmobile(String mobile) {
		this.mobile = mobile;
	}

	@SuppressWarnings("unused")
	private void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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
	private void setPinHash(String pinHash) {
		this.pinHash = pinHash;
	}

	public String getmobile() {
		return mobile;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPinHash() {
		return pinHash;
	}

}
