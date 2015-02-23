/**
 * 
 */
package org.osssv.sample.http.exception;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osssv.sample.service.exception.SampleException;

/**
 * A class for HTTP Error
 * 
 * @author S.Yatsuzuka
 * @version 0.1
 */
@XmlRootElement(name = "error")
public class HttpError {

	//======= Variable =======
	
	/** Status */	
	@XmlElement
	private int status;
	
	/** Code */	
	@XmlElement
	private String code;
	
	/** Message */	
	@XmlElement
	private String message;
	
	/** Debug */	
	@XmlElement
	private String debug;

	
	/**
	 * Constructor
	 * 
	 */
	protected HttpError(){}
	
	
	/**
	 * Constructor
	 * 
	 */
	public HttpError(SampleException ex) {
		
		status=409;
		code=ex.getErrorCode()==null?"":ex.getErrorCode().name();
		message=ex.getMessage();
		debug=ex.getCause()==null?"":"caused by"+ex.getCause().getMessage();		
	}	
}
