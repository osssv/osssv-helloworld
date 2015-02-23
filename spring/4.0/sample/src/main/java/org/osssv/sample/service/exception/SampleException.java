package org.osssv.sample.service.exception;

import org.osssv.sample.service.exception.ErrorCode;


/**
 * A root class for sample exception
 * 
 * @author S.Yatsuzuka
 * @version 0.1
 */
@SuppressWarnings("serial")
public class SampleException extends RuntimeException {
	
	//======= Variable =======
	
	/** Error Code */	
	private ErrorCode errorCode;

	
	/**
	 * Constructor
	 * 
	 */
	public SampleException(ErrorCode code, String message, Throwable throwable) {
		super(message, throwable);
		this.errorCode = code;
	}
	
	/**
	 * Constructor
	 * 
	 */
	public SampleException(ErrorCode code, String message) {
		super(message);
		this.errorCode = code;
	}

	
	/**
	 * Get Error Code
	 * 
	 */
	public ErrorCode getErrorCode() {
		return errorCode;
	}
}
