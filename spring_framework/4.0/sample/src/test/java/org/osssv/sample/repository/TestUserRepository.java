package org.osssv.sample.repository;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.osssv.sample.entity.User;
import org.osssv.sample.entity.impl.UserImpl;
import org.osssv.sample.repository.UserRepository;


/**
 * A test class for user repository
 * 
 * @author S.Yatsuzuka
 * @version 0.1
 */
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestUserRepository extends AbstractTransactionalJUnit4SpringContextTests {

	
	/** User Repository */
	@Autowired
	private UserRepository userRepository;

	
	/**
	 * Add And Get User
	 * 
	 */
	@Test
	public void addAndGetUser(){
		UserImpl newUser = new UserImpl();
		newUser.setFirstName("test"+new Random().nextInt(99999));
		newUser.setLastName("lastName");
		newUser.setPin("1234");
		
		long  addedUserId = userRepository.addUser(newUser);		
		System.out.println("user added id "+addedUserId);
		Assert.assertNotEquals(0, addedUserId);		

		User found = userRepository.getUser(addedUserId);
		Assert.assertEquals(found.getId(), addedUserId);
		Assert.assertEquals(found.getFirstName(), newUser.getFirstName());
		Assert.assertEquals(found.getLastName(), newUser.getLastName());
		Assert.assertEquals(found.getPin(), newUser.getPin());

	}
}
