package com.cmpe239.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BusinessEntity {
	
	@Id
	private String bussID;
	private String Name;
	private String Address;
	private double stars;
	public String getBussID() {
		return bussID;
	}
	public void setBussID(String bussID) {
		this.bussID = bussID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public double getStars() {
		return stars;
	}
	public void setStars(double stars) {
		this.stars = stars;
	}
	
	

}
