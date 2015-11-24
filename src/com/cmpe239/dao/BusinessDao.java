package com.cmpe239.dao;

import com.cmpe239.model.Business;

public interface BusinessDao {
	
	public String getYelpID(int bussID);
	public String getBusinessName(String yelpID);
	public String getBusinessLocation(String yelpID);
	public String getBusinessStars(String yelpID);

}
