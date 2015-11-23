package com.cmpe239.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_INFORMATION")
public class UserEntity {
	
	@Id
	private int userID;
	private String yelpID;
	private String useremail;
	private String usertype;
	private String password;
	private String fans;
	private String yelpingSince;
	
	public String getFans() {
		return fans;
	}

	public void setFans(String fans) {
		this.fans = fans;
	}

	public String getYelpingSince() {
		return yelpingSince;
	}

	public void setYelpingSince(String yelpingSince) {
		this.yelpingSince = yelpingSince;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getYelpID() {
		return yelpID;
	}
	public void setYelpID(String yelpID) {
		this.yelpID = yelpID;
	}
	
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}


}
