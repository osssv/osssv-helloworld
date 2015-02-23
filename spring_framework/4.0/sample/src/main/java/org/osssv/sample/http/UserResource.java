/**
 * 
 */
package org.osssv.sample.http;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.resteasy.annotations.providers.jaxb.Wrapped;
import org.osssv.sample.entity.User;
import org.osssv.sample.entity.impl.UserImpl;
import org.osssv.sample.http.entity.HttpUser;
import org.osssv.sample.service.UserService;
import org.osssv.sample.service.exception.SampleException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * A class for user resource
 * 
 * @author S.Yatsuzuka
 * @version 0.1
 */
@Path("/users")
@Component
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class UserResource {

	//======= Variable =======
	
	/** Logger */	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	/** User Service */	
	@Autowired
	private UserService userService;

	
	/**
	 * Create User
	 * 
	 */
	@POST
	@Path("/")
	public Response createUser(HttpUser newUser){
		
		//======= Output Log =======
		logger.info("Started");
		
		//======= Ceate User =======
		User userToCreate = convert(newUser);
		User addedUser = userService.addUser(userToCreate);
		
		//======= Output Log =======
		logger.info("Ended");

		return Response.status(Status.CREATED).header("Location", "/users/"+addedUser.getId()).entity(new HttpUser(addedUser)).build();
	}	

	
	/**
	 * Get User by ID
	 * 
	 */
	@GET
	@Path("/{userId}")	
	public HttpUser getUserById(@PathParam("userId") long userId){

		//======= Output Log =======
		logger.info("Started");

		//======= Get User by ID =======
		logger.info("getting user by id:"+userId);
		User user = userService.getUser(userId);	
		
		//======= Output Log =======
		logger.info("Ended");

		return new HttpUser(user);
	}

	
	/**
	 * Get User Search
	 * 
	 */
	@GET
	@Path("/")
	@Wrapped(element="users")
	public List<HttpUser> getUserSearch(@QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName) throws SampleException{

		//======= Output Log =======
		logger.info("Started");

		logger.info("firstName:	"+firstName);
		logger.info("lastName:	"+lastName);

		//======= Get Users List =======
		List<User> found = userService.getUsers(firstName, lastName);
		List<HttpUser> returnList = new ArrayList<>(found.size());
		for(User user:found){
			returnList.add(new HttpUser(user));
		}
		
		//======= Output Log =======
		logger.info("Ended");

		return returnList;
	}
	
	
	/**
	 * Convert
	 * 
	 */
	private User convert(HttpUser httpUser) {
		
		UserImpl user = new UserImpl();
		user.setFirstName(httpUser.firstName);
		user.setLastName(httpUser.lastName);
		user.setPin(httpUser.pin);
		return user;
	}	
}