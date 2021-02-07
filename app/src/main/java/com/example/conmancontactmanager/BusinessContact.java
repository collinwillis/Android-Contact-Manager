package com.example.conmancontactmanager;

public class BusinessContact extends BaseContact {

	public String opening;
	public String closing;
	public String url;

	@Override
	public String toString() {
		return "\n\nName: " + name + "\nPhoneNumber: " + phoneNo + "\nEmail: " + email + "\nPhotoName: " + photoName
				+ "\nCountry: " + country + "\nState: " + state + "\nCity: " + city + "\nZipCode: " + zipCode
				+ "\nStreetAddress: " + streetAddress + "\nOpens: " + opening + "\nCloses: " + closing + "\nURL: " + url;
	}

	public BusinessContact(String name, String phoneNo, String email, int photoName, String country, String state,
			String city, String zipCode, String streetAddress, String opening, String closing,
			String url) {
		super(name, phoneNo, email, photoName, country, state, city, zipCode, streetAddress);
		this.opening = opening;
		this.closing = closing;
		this.url = url;
	}

	public BusinessContact() {
		super("Business Name", "Business Phone", "Business Email", 0, "Country", "State", "City", "Zip Code",
				"Street Address");
		this.opening = "10:00 a.m.";
		this.closing = "5:00 p.m.";
		this.url = "http://www.example.com";
	}

	@Override
	public int compareTo(BaseContact o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
