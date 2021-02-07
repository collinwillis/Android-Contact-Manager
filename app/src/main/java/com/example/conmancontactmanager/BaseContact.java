package com.example.conmancontactmanager;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


@JsonTypeInfo(
		  use = JsonTypeInfo.Id.NAME, 
		  include = JsonTypeInfo.As.PROPERTY, 
		  property = "type")
		@JsonSubTypes({ 
		  @Type(value = PersonContact.class, name = "person"), 
		  @Type(value = BusinessContact.class, name = "business") 
		})

public abstract class BaseContact implements Comparable<BaseContact> {
	
	

	protected String name;
	protected String phoneNo;
	protected String email;
	protected int photoName;
	protected String country;
	protected String state;
	protected String city;
	protected String zipCode;
	protected String streetAddress;

	public BaseContact(String name, String phoneNo, String email, int photoName, String country, String state,
			String city, String zipCode, String streetAddress) {
		super();
		this.name = name;
		this.phoneNo = phoneNo;
		this.email = email;
		this.photoName = photoName;
		this.country = country;
		this.state = state;
		this.city = city;
		this.zipCode = zipCode;
		this.streetAddress = streetAddress;
	}
	
	

	public BaseContact() {
		this.name = "A first name has not been provided yet.";
		this.phoneNo = "123-456-321";
		this.email = "johndoe@example.com";
		this.photoName = 0;
		this.country = "United States";
		this.state = "Arizona";
		this.city = "Phoenix";
		this.zipCode = "85017";
		this.streetAddress = "3300 W. Cammelback Rd.";
	}

	// Getters & Setters
	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhotoName() {
		return photoName;
	}

	public void setPhotoName(int photoName) {
		this.photoName = photoName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

}
