/**
 * 
 */
package org.osssv.sample.repository;

import org.osssv.sample.entity.User;


/**
 * An interface for user repository
 * 
 * @author S.Yatsuzuka
 * @version 0.1
 */
public interface UserRepository {

	
	/**
	 * Add User ID.
	 * 
	 */
	long addUser(User user);
	
	
	/**
	 * Get User ID.
	 * 
	 */
	User getUser(long userId);

}
