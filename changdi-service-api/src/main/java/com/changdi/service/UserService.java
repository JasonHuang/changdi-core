package com.changdi.service;

import com.changdi.vo.User;

public interface UserService {
	public User addAppUser(User uo);

	public User authorize(User uo);
}
