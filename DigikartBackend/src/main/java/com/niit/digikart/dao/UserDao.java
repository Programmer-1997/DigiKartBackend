package com.niit.digikart.dao;


import java.util.List;

import com.niit.digikart.model.User;



public interface UserDao {

	void save(User u);
	void delete(User u);
	void update(User u);
	List<User>Userlist();
	public User findbyUserId(String id);
	
}
