package com.cmpe239.dao;

import java.io.FileNotFoundException;

import org.json.simple.JSONObject;

import com.cmpe239.entities.UserEntity;
import com.cmpe239.model.User;

public interface UserDao {
	
	public void insert() throws Exception;
	public UserEntity insertNewUser();
	public User findByCustomerId(int userID);
	public UserEntity validateUser(String userEmail);

}
