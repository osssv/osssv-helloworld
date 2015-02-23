package org.osssv.sample.util;

import javax.servlet.ServletContext;

import org.jboss.resteasy.plugins.spring.SpringContextLoaderSupport;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.ContextLoaderListener;


/**
 * REST Easy/Spring 4 issue workaround - see here https://issues.jboss.org/browse/RESTEASY-1012
 * 
 * @author S.Yatsuzuka
 * @version 0.1
 */
public class CustomContextLoaderListener extends ContextLoaderListener {

	
	//======= Variable =======
	
	/** Spring Context Loader Support */	
	private SpringContextLoaderSupport springContextLoaderSupport = new SpringContextLoaderSupport();


	/**
	 * Customize Context
	 * 
	 */
	@Override
	protected void customizeContext(ServletContext servletContext, ConfigurableWebApplicationContext configurableWebApplicationContext) {	
		
		super.customizeContext(servletContext, configurableWebApplicationContext);		
		this.springContextLoaderSupport.customizeContext(servletContext, configurableWebApplicationContext);
	}
}