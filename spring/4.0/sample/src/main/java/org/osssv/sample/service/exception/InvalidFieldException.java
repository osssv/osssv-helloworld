package org.osssv.sample.service.exception;



/**
 * A class for Invalid Exception
 * 
 * @author S.Yatsuzuka
 * @version 0.1
 */
@SuppressWarnings("serial")
public class InvalidFieldException extends SampleException {

	/**
	 * Constructor
	 * 
	 */
	public InvalidFieldException(String message, Throwable throwable) {
		super(ErrorCode.INVALID_FIELD, message, throwable);
	}
	
	/**
	 * Constructor
	 * 
	 */
	public InvalidFieldException(String message) {
		super(ErrorCode.INVALID_FIELD, message);
	}
}
