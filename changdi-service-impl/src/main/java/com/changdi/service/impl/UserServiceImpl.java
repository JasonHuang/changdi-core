package com.changdi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changdi.dao.UserDao;
import com.changdi.service.UserService;
import com.changdi.vo.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User addAppUser(User uo) {
		User user = userDao.insertAppUser(uo);
		return user;
	}

	@Override
	public User authorize(User uo) {
		String name = uo.getName();
		User user = userDao.getUserIdByName(name);

		if (user == null) {
			user = userDao.insertAppUser(uo);
		}else{
			userDao.updateUser(uo);
		}
		return user;
	}
}
