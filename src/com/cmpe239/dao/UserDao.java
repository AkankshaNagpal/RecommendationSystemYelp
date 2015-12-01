package com.cmpe239.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.json.simple.JSONObject;

import com.cmpe239.entities.UserEntity;
import com.cmpe239.model.Business;
import com.cmpe239.model.User;

public interface UserDao {
	
	public void insert() throws Exception;
	public UserEntity insertNewUser(UserEntity user);
	public User findByCustomerId(int userID);
	public UserEntity validateUser(String userEmail);
	public List<RecommendedItem> recommendedBusiness(int userID) throws Exception;
	public List<String> getBusinessList(String location, String category) throws Exception;

}
