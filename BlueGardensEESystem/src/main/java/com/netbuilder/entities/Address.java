package com.netbuilder.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "Address")
public class Address {
	private int doorNumber;
	private String houseName;
	private String firstLine;
	private String secondLine;
	private String town;
	private String county;
	private String country;
	private String postalOrZipCode;
	
	public Address(int door, String first, String second, String town, String county, String country, String postcode) {
		doorNumber = door;
		firstLine = first;
		secondLine = second;
		this.town = town;
		this.county = country;
		this.country = country;
		postalOrZipCode = postcode;
	}
	
	public Address(String house, String first, String second, String town, String county, String country, String postcode) {
		houseName = house;
		firstLine = first;
		secondLine = second;
		this.town = town;
		this.county = country;
		this.country = country;
		postalOrZipCode = postcode;
	}
	
	public void setDoorNumber(int door) { doorNumber = door; }
	public void setHouseName(String house) { houseName = house; }
	public void setFirstLine(String line) { firstLine = line; }
	public void setSecondLine(String line) { secondLine = line; }	
	public void setTown(String town) { this.town = town; }
	public void setCounty(String county) { this.county = county; }
	public void setCountry(String county) { this.country = county; }
	public void setPostCode(String post) { postalOrZipCode = post; }
	
	public String getFirstLine() { return firstLine; }	
	public int getDoorNumber() { return doorNumber; }
	public String gethouseName() { return houseName; }	
	public String getSecondLine() { return secondLine; }
	public String getTown() { return town; }	
	public String getCounty() { return county; }
	public String getCountry() { return country; }
	public String getPostCode(String post) { return postalOrZipCode; }
}