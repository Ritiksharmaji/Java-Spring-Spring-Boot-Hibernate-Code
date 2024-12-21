package springMVC.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springMVC.dao.UserDao;
import springMVC.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	@Transactional // to enable the read operation
	public int createUser(User user) {
		return this.userDao.saveUser(user);
	}

}
