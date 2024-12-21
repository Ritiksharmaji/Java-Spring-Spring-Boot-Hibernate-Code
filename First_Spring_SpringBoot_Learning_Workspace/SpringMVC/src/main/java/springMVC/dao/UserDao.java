package springMVC.dao;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import springMVC.model.User;

// spring has given the predefine @Autowired name for Dao class so that
// w don't need to identifire it to container to create object for it by using that Annotaion
// contianer will undestant that it is Dao class so i have to create the object for it that is 
// @Resository

@Repository
public class UserDao {
	
	// to inject the HibernateTemplate object by spring we are 
	// using the @Autowired
	@Autowired
private HibernateTemplate hibernateTemplate;
	public int saveUser(User user) {
		
		int id = (Integer) this.hibernateTemplate.save(user);
		return id;
	}
}
