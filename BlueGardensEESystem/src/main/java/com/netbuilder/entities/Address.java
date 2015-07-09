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
	
	public Address(int door, String first, String second, String town, String county, String country, String postcode)
	{
		doorNumber = door;
		firstLine = first;
		secondLine = second;
		this.town = town;
		this.county = country;
		this.country = country;
		postalOrZipCode = postcode;
	}
	
	public Address(String house, String first, String second, String town, String county, String country, String postcode)
	{
		houseName = house;
		firstLine = first;
		secondLine = second;
		this.town = town;
		this.county = country;
		this.country = country;
		postalOrZipCode = postcode;
	}
	
	public void setDoorNumber(int door)
	{
		doorNumber = door;
	}
	
	public int getDoorNumber()
	{
		return doorNumber;
	}
	
	public void setHouseName(String house)
	{
		houseName = house;
	}

	public String gethouseName()
	{
		return houseName;
	}
	
	public void setFirstLine(String line)
	{
		firstLine = line;
	}
	
	public String getFirstLine()
	{
		return firstLine;
	}
	
	public void setSecondLine(String line)
	{
		secondLine = line;
	}
	
	public String getSecondLine()
	{
		return secondLine;
	}
	
	public void setTown(String town)
	{
		this.town = town;
	}
	
	public String getTown()
	{
		return town;
	}
	
	public void setCounty(String county)
	{
		this.county = county;
	}
	
	public String getCounty()
	{
		return county;
	}
	
	public void setCountry(String county)
	{
		this.country = county;
	}
	
	public String getCountry()
	{
		return country;
	}
	
	public void setPostCode(String post)
	{
		postalOrZipCode = post;
	}
	
	public String getPostCode(String post)
	{
		return postalOrZipCode;
	}
}
