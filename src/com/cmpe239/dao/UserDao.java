package com.cmpe239.dao;

import com.cmpe239.model.User;

public interface UserDao {
	
	public void insert();
	public User findByCustomerId(int userID);

}
