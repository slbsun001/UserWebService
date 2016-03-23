package com.restAPI;

import java.util.List;

import javax.ejb.Stateless;
import javax.naming.AuthenticationException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class UserService {
	
	@PersistenceContext
	private EntityManager entityManager;

	public User registerUser(RegisterUserRequest request) {

		String cellNumber = request.getmobile();
		verifyCellNumberNotUsed(cellNumber);

		User user = new User(request);
		user =entityManager.merge(user);
		
		return user;

	}
	
	public User updateUser(UpdateUserRequest request) throws AuthenticationException {

		User user = findMobileNumber(request.getMobile());
		
		if (user == null) {
			throw new AuthenticationException("Mobile not registered on system: " + request.getMobile());
		}
		user.update(request);
		return user;
	}
	
	public void verifyCellNumberNotUsed(String mobileNumber) {
		this.verifyCellandEmail(mobileNumber, null);
	}
	
	public void verifyCellandEmail(String mobileNumber, String email){
		//query sent to database checking if the email or mobileNumber exist in the database
		StringBuilder queryString = new StringBuilder();
			queryString.append(" select u from User u");
			queryString.append(" where mobileNumber = :mobileNumber");
			queryString.append(" or email = :email");

		TypedQuery<User> query = entityManager
				.createQuery(queryString.toString(), User.class)
				.setParameter("mobileNumber", mobileNumber)
				.setParameter("email", email);

				List<User> existingUsers = query.getResultList();
		
		//throw exception with message if user exists
		if (!existingUsers.isEmpty()) {
			User user = existingUsers.get(0);
			if (user.getMobileNumber().equals(mobileNumber)) {
				throw new AlreadyExistsException("Mobile number already registered: " + mobileNumber, ClientMessage.MOBILE_ALREADY_REGISTERED);
			} else if (email != null && email.equals(user.getEmail())) {
			throw new AlreadyExistsException("Email number already registered: " + email, ClientMessage.EMAIL_ALREADY_REGISTERED);
			}
		}
	}
	
	public User findMobileNumber(String mobile) {
		
		StringBuilder queryString = new StringBuilder();
		queryString.append(" select u from User u where mobile = :mobile");

		TypedQuery<User> query = entityManager.createQuery(queryString.toString(), User.class)
				.setParameter("mobile", mobile);

		List<User> existingUsers = query.getResultList();
		if (existingUsers.isEmpty()) {
			return null;
		}
		return existingUsers.get(0);
		}
		
	}
