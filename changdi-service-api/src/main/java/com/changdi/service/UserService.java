package com.changdi.service;

import com.changdi.vo.User;
import com.changdi.vo.UserToken;

public interface UserService {
	public User addAppUser(User uo);

	public User authorize(User uo);

	public UserToken loadUserTokenByName(String name);
}
