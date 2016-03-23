package com.restAPI;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.naming.AuthenticationException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("") //must exist otherwise the methods below ill not map to anything
public class UserWebService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("cdi-ambiguous-dependency")
	@Inject
	private UserService userService ;
	
	User user;
	
	public UserWebService() {}

	@GET
	@Path("getUser/{mobile}")
	public Response getUser(@PathParam("mobile") String mobile) {
		StringBuilder queryString = new StringBuilder();
		queryString.append(" select u from User u where mobile = :mobile");
		
		TypedQuery<User> query = entityManager.createQuery(queryString.toString(), User.class)
				.setParameter("mobile", mobile);

		List<User> existingUsers = query.getResultList();
		
		user= existingUsers.get(0);
		
		return Response.ok().entity(user).build();
		
	}

	@POST
	@Path("/register")
	public Response registerUser(RegisterUserRequest registerUserRequest){
			    	    
	    //Now saving...
	    entityManager.persist(userService.registerUser(registerUserRequest));
	    entityManager.flush();
	    return Response.ok().entity(new GenericResponse(ClientMessage.USER_REGISTERED)).build();
	}
	
	//update the user details
	@PUT
	@Path("/update")
	public Response update(UpdateUserRequest updateUserRequest) throws AuthenticationException {

		entityManager.merge(userService.updateUser(updateUserRequest));
		entityManager.flush();
		return Response.ok().entity(new GenericResponse(ClientMessage.USER_UPDATED)).build();

	}
	
	@DELETE
	@Path("delete/{mobile}")
	public Response deleteUser(@PathParam("mobile") String mobile) {
		StringBuilder queryString = new StringBuilder();
		queryString.append(" select u from User u where mobile = :mobile");

		TypedQuery<User> query = entityManager.createQuery(queryString.toString(), User.class)
				.setParameter("mobile", mobile);

		List<User> existingUsers = query.getResultList();
		
		User user= existingUsers.get(0);
		entityManager.remove(user);
		
		return Response.ok().entity(user).build();
		
	}
	
	
}
