package com.fegh.springata.service;

import com.fegh.springata.dao.UserDao;
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
	public void Inserisci(User user) {
        userDao.Inserisci(user);
	}

	@Override
	public void Aggiorna(User user) {
        userDao.Aggiorna(user);
	}

	@Override
	public void Elimina(User user) {
        userDao.Elimina(user);
	}

	@Override
	public void eliminaByEmail(String email) { userDao.eliminaByEmail(email);	}

	@Override
	public User userByEmail(String email) {
		User user = userDao.userByEmail(email);
		return user;
	}
}
