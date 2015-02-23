/**
 * 
 */
package org.osssv.sample.entity;


/**
 * An interface for user entity
 * 
 * @author S.Yatsuzuka
 * @version 0.1
 */
public interface User {

	/**
	 * Get User ID.
	 * 
	 */
	long getId();	
	
	
	/**
	 * Get First Name.
	 * 
	 */
	String getFirstName();
	
	
	/**
	 * Get Last Name.
	 * 
	 */
	String getLastName();
	
	
	/**
	 * Get PIN.
	 * 
	 */
	String getPin();
}
