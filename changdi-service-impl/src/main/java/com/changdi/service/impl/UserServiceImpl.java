package com.changdi.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changdi.dao.TokenDao;
import com.changdi.dao.UserDao;
import com.changdi.service.UserService;
import com.changdi.vo.User;
import com.changdi.vo.UserToken;

@Service
public class UserServiceImpl implements UserService {

	private Log logger = LogFactory.getLog(this.getClass().getName());

	@Autowired
	private UserDao userDao;

	@Autowired
	private TokenDao tokenDao;

	@Override
	public User addAppUser(User uo) {
		User user = userDao.insertAppUser(uo);
		return user;
	}

	@Override
	public User authorize(User uo) {
		String name = uo.getName();
		User user = userDao.getUserIdByName(name);

		logger.debug(String.format("user:%s", user));
		logger.debug(String.format("uo:%s", uo));
		
		logger.debug(String.format("userDao:%s", userDao));
		logger.debug(String.format("tokenDao:%s", tokenDao));
		
		if (user == null) {
			user = userDao.insertAppUser(uo);
			tokenDao.inserToken(uo);
		} else {
			uo.setId(user.getId());
			userDao.updateUser(uo);
			UserToken ut = tokenDao.getUserTokenById(user.getId());
			if(ut == null){
				tokenDao.inserToken(uo);
			}else{
				ut = new UserToken();
				ut.setTokenKey(uo.getTokenKey());
				ut.setTokenSecret(uo.getTokenSecret());
				ut.setVerifier(uo.getVerifier());
				ut.setU_id(user.getId());
				tokenDao.updateToken(ut);
			}
		}
		return user;
	}

	@Override
	public UserToken loadUserTokenByName(String name) {
		
		return tokenDao.loadUserTokenByName(name);
	}
}
