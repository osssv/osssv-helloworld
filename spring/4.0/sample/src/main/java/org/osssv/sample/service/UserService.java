/**
 * 
 */
package org.osssv.sample.service;

import org.osssv.sample.entity.User;

/**
 * @author syatsuzuka
 *
 */
public interface UserService {

	User getUser(long userId);
	boolean isPinValid(long userId, String pin);
}
