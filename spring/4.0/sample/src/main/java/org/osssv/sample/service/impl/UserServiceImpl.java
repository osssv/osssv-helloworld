/**
 * 
 */
package org.osssv.sample.service.impl;

import org.springframework.stereotype.Service;
import org.osssv.sample.entity.User;
import org.osssv.sample.entity.impl.UserImpl;
import org.osssv.sample.service.UserService;


/**
 * @author syatsuzuka
 *
 */
@Service
public class UserServiceImpl implements UserService {

	public User getUser(long userId) {
		// TODO Auto-generated method stub
		
		return new UserImpl(userId);
	}

	public boolean isPinValid(long userId, String pin) {
		
		// TODO Auto-generated method stub
		if(userId==1 && "1234".equals(pin)){
			return true;
		}
		return false;
	}
}
