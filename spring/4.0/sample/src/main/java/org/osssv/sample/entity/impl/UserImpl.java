package org.osssv.sample.entity.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.osssv.sample.entity.User;


/**
 * A class for user entity
 * 
 * @author S.Yatsuzuka
 * @version 0.1
 */
@Entity
@Table(name = "users")
public class UserImpl implements User {

	
	//======= Variable =======
	
	/** User ID */
	@Id
	@Column(name = "idusers")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	
	/** First Name */
	@Column(name = "first_name")
	private String firstName;

	/** Last Name */
	@Column(name = "last_name")
	private String lastName;

	/** PIN */
	@Column(name = "pin")
	private String pin;

	
	/**
	 * Constructor.
	 * 
	 */
	public UserImpl(){}		

	
	/**
	 * Get User ID.
	 * 
	 */
	@Override
	public long getId() {
		return id;
	}

	
	/**
	 * Get First Name.
	 * 
	 */
	@Override	
	public String getFirstName() {
		return firstName;
	}

	
	/**
	 * Set First Name.
	 * 
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * Get Last Name.
	 * 
	 */
	@Override
	public String getLastName() {
		return lastName;
	}

	
	/**
	 * Set Last Name.
	 * 
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * Get PIN.
	 * 
	 */
	@Override
	public String getPin() {

		return this.pin;
	}


	/**
	 * Set PIN.
	 * 
	 */
	public void setPin(String pin) {
		this.pin = pin;
	}

	
	/**
	 * Create String.
	 * 
	 */
	@Override
	public String toString() {
		return "UserImpl [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", pin=" + pin + "]";
	}
}
