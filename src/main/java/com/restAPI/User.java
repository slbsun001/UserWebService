package com.restAPI;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.restAPI.Status;

@Entity
public class User {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(nullable = false, name = "mobile")
	private String mobileNumber;

	@Column
	private String email;

	@Column(nullable = false)
	private String pin;

	@Column(name = "date_of_birth")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	@Column
	private String gender;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status = Status.AWAITING_ACTIVATION;
	
	/*@SuppressWarnings("unused")
	private void setId(Long id) {
		this.id = id;
	}*/

	public void setId(Long id) {
		this.id = id;
	}
	
	 public Long getId() {
	        return id;
	    }
	
	protected User() {
		super();
		}
		// ---- Override equals() and hashcode() ---- //

	public User(RegisterUserRequest request) {
		this.firstName = request.getFirstName();
		this.lastName = request.getLastName();
		this.mobileNumber = request.getmobile();
		this.email=request.getEmailAddress();
		this.pin = request.getPinHash();
		//updateMobileNumber(request.getMobileNumber());
		//updatePin(request.getPinHash());
	}
	 
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public String getPin() {
		return pin;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public String getEmail() {
		return email;
	}
	
	public Status getStatus() {
		return status;
	}
	
	//Setters
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void update(UpdateUserRequest request) {
		this.firstName = request.getFirstName();
	}

	public static String sanitizeMobileNumber(String number) {
		if (number == null) {
			return null;
		}
		if (number.startsWith("0")) {
			number = "27" + number.substring(1);
		}
		return number;
	}
	
	
	
}
