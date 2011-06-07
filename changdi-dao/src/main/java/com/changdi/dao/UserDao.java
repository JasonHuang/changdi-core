package com.changdi.dao;

import com.changdi.vo.User;


public interface UserDao {

	public User insertAppUser(User user);

	public void updateUser(User uo);

	public User getUserIdByName(String name);


}
