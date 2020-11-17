package com.fegh.springata.service;

import com.fegh.springata.dao.UserDao;
import com.fegh.springata.entity.Rent;
import com.fegh.springata.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

		@Autowired
		private UserDao userDao;

	@Override
    @Transactional
	public boolean validate(String userName, String password) {
		return userDao.validate(userName, password);
	}

	@Override
	public void Insert(User user) {
        userDao.Insert(user);
	}

	@Override
	public void Update(User user) {
        userDao.Update(user);
	}

	@Override
	public void Delete(User user) {
        userDao.Delete(user);
	}

	@Override
	public void DeleteByEmail(String email) { userDao.DeleteByEmail(email);	}

	@Override
	public User userByEmail(String email) {
		User user = userDao.userByEmail(email);
		return user;
	}
	@Override
	public List<Rent> rentByEmail(String email) {
		return userDao.rentByEmail(email);
	}
}
