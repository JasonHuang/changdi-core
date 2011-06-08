package com.changdi.dao;

import com.changdi.vo.User;
import com.changdi.vo.UserToken;

public interface TokenDao {

	void inserToken(User uo);

	UserToken getUserTokenById(long id);

	void updateToken(UserToken ut);

	UserToken loadUserTokenByName(String name);

}
