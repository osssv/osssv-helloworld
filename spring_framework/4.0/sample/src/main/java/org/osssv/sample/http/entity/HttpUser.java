/**
 * 
 */
package org.osssv.sample.http.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osssv.sample.entity.User;


/**
 * A class for HTTP User
 * 
 * @author S.Yatsuzuka
 * @version 0.1
 */
@XmlRootElement(name = "user")
public class HttpUser {

	@XmlElement
	public long id;
	
	@XmlElement
	public String firstName;
	
	@XmlElement
	public String lastName;
	
	@XmlElement
	public String pin;
	
	//required by framework
	protected HttpUser() {}

	public HttpUser(User user) {
		this.id=user.getId();
		this.firstName=user.getFirstName();
		this.lastName=user.getLastName();
		//not setting PIN
	}	
}
