package org.osssv.sample.http.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.osssv.sample.service.exception.SampleException;
import org.springframework.stereotype.Component;


/**
 * Return HTTP 409 with response body 
 * 
 * @author S.Yatsuzuka
 * @version 0.1
 */
@Provider
@Component
public class SampleExceptionMapper implements ExceptionMapper<SampleException>{

	
	/**
	 * To Response
	 * 
	 */
	@Override
	public Response toResponse(SampleException ex) {
		return Response.status(Status.CONFLICT).entity(new HttpError(ex)).build();
	}
}