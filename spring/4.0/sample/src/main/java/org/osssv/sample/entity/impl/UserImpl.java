package org.osssv.sample.entity.impl;

import org.osssv.sample.entity.User;

public class UserImpl implements User {
	private long id;
	private String firstName;
	private String lastName;
		
	public UserImpl(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}	
}
