/**
 * 
 */
package org.osssv.sample.service;

import org.osssv.sample.entity.User;

/**
 * An interface for user service
 * 
 * @author S.Yatsuzuka
 * @version 0.1
 */
public interface UserService {

	/**
	 * Add User
	 * 
	 */
	User addUser(User user);
	
	/**
	 * Get User
	 * 
	 */
	User getUser(long userId);
	
	/**
	 * Validate PIN
	 * 
	 */
	boolean isPinValid(long userId, String pin);
}
