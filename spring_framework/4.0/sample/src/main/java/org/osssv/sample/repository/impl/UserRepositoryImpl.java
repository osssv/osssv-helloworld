/**
 * 
 */
package org.osssv.sample.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.osssv.sample.entity.User;
import org.osssv.sample.entity.impl.UserImpl;
import org.osssv.sample.repository.UserRepository;


/**
 * A class for user repository
 * 
 * @author S.Yatsuzuka
 * @version 0.1
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

	//======= Variable =======
	
	/** Session Factory */
	@Autowired
    private SessionFactory sessionFactory;

	
	/**
	 * Add User
	 * 
	 */
	@Override
	public long addUser(User user) {
		return (Long) this.sessionFactory.getCurrentSession().save(user);	
	}

	/**
	 * Get User
	 * 
	 */
	@Override
	public User getUser(long userId) {
		return (User) this.sessionFactory.getCurrentSession().get(UserImpl.class, userId);
	}


	/**
	 * Search User Data
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> search(String firstName, String lastName) {

		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(User.class);
		if(!StringUtils.isEmpty(firstName)){
			crit.add(Restrictions.like("firstName", "%"+firstName+"%"));
		}
		if(!StringUtils.isEmpty(lastName)){
			crit.add(Restrictions.like("lastName", "%"+lastName+"%"));
		}
		List<User> searchResult = crit.list();		
		return searchResult;
	}
}
