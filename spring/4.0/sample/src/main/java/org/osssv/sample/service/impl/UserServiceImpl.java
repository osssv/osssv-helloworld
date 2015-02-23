/**
 * 
 */
package org.osssv.sample.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.transaction.Transactional;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.osssv.sample.entity.User;
import org.osssv.sample.entity.impl.UserImpl;
import org.osssv.sample.repository.UserRepository;
import org.osssv.sample.service.UserService;


/**
 * A class for user service
 * 
 * @author S.Yatsuzuka
 * @version 0.1
 */
@Service
public class UserServiceImpl implements UserService {

	//======= Variable =======
	
	/** Logger */	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	/** User Repository */	
	@Autowired
	private UserRepository userRepository;

	
	/**
	 * Get User
	 * 
	 */
	@Transactional//at method level
	public User getUser(long userId) {
		
		return userRepository.getUser(userId);
	}

	/**
	 * Valid PIN
	 * 
	 */
	@Transactional//at method level
	public boolean isPinValid(long userId, String pin) {
		
		User user = getUser(userId);
		
		if(user==null || pin==null){
			return false;
		}
		
		return user.getPin()!=null && user.getPin().equals(md5base64(pin));
	}

	
	/**
	 * Add User
	 * 
	 */
	@Override
	@Transactional//at method level
	public User addUser(User user) {
		
		if(user.getPin()==null){
			//TODO what is our exception handling strategy?
			throw new IllegalArgumentException("Pin is required");
		}
		
		//let us hash the pin - TBTF bank does basic MD5
		UserImpl impl = (UserImpl)user;
		impl.setPin(md5base64(user.getPin()));		
		long id =  userRepository.addUser(user);
		return getUser(id);
	}

	
	/**
	 * Conduct MD5 encoding
	 * 
	 */
	private String md5base64(String pin){
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] digest = md.digest(pin.getBytes("UTF-8"));
			return Base64.encodeBase64String(digest);				
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			logger.error("failed to md5",e);
		}
		
		//TODO - this needs to be handled better
		throw new IllegalArgumentException("Server fail");
	}	
}
