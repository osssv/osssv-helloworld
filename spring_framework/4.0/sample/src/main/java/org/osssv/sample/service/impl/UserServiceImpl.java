/**
 * 
 */
package org.osssv.sample.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.osssv.sample.entity.User;
import org.osssv.sample.entity.impl.UserImpl;
import org.osssv.sample.repository.UserRepository;
import org.osssv.sample.service.UserService;
import org.osssv.sample.service.exception.ErrorCode;
import org.osssv.sample.service.exception.InvalidFieldException;
import org.osssv.sample.service.exception.SampleException;



/**
 * A class for user service
 * 
 * @author S.Yatsuzuka
 * @version 0.1
 */
@Service
public class UserServiceImpl implements UserService {

	//======= Variable =======
	
	/** MAX_NAME_LENGTH */	
	private static final int MAX_NAME_LENGTH = 45;
	
	/** MAX_PIN_LENGTH */	
	private static final int MAX_PIN_LENGTH = 10;	
	
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
		
		if(StringUtils.isEmpty(user.getFirstName()) || user.getFirstName().length()>MAX_NAME_LENGTH){			
			throw new InvalidFieldException("firstName is required");
		}
		
		if(StringUtils.isEmpty(user.getLastName()) || user.getLastName().length()>MAX_NAME_LENGTH){			
			throw new InvalidFieldException("lastName is required");
		}		
		
		//let us hash the pin - TBTF bank does basic MD5
		UserImpl impl = (UserImpl)user;
		impl.setPin(md5base64(user.getPin()));		
		long id =  userRepository.addUser(user);
		return getUser(id);
	}

	
	/**
	 * Get Users List
	 * 
	 */
	@Override
	@Transactional
	public List<User> getUsers(String firstName, String lastName) {
		
		List<User> returnList = new ArrayList<>();
		if(StringUtils.isEmpty(firstName) && StringUtils.isEmpty(lastName)){
			throw new SampleException(ErrorCode.MISSING_DATA, "no search parameter provided");	
		}
		else{
			returnList = userRepository.search(firstName, lastName);
		}		
		return returnList;
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
