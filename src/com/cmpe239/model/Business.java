package com.cmpe239.model;

public class Business {
	
	private int bussID;
	
	private String bname;
	
	private String baddress;
	
	private double stars;
	
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBaddress() {
		return baddress;
	}
	public void setBaddress(String baddress) {
		this.baddress = baddress;
	}
	public double getStars() {
		return stars;
	}
	public void setStars(double stars) {
		this.stars = stars;
	}
	public int getBussID() {
		return bussID;
	}
	public void setBussID(int bussID) {
		this.bussID = bussID;
	}
	public String getYelpBussID() {
		return YelpBussID;
	}
	public void setYelpBussID(String yelpBussID) {
		YelpBussID = yelpBussID;
	}
	private String YelpBussID;


}
