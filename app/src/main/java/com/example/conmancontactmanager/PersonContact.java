package com.example.conmancontactmanager;

public class PersonContact extends BaseContact {

	//private String birthday;

	public PersonContact(String name, String phoneNo, String email, int photoName, String country, String state,
			String city, String zipCode, String streetAddress) {
		super(name, phoneNo, email, photoName, country, state, city, zipCode, streetAddress);
	}

//	public void Date() {
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
//		LocalDateTime now = LocalDateTime.now();
//		dtf.format(now);
//	}

	public PersonContact() {


	}

	@Override
	public int compareTo(BaseContact o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "\n\nName: " + name + "\nPhoneNumber: " + phoneNo + "\nEmail: " + email + "\nPhotoName: " + photoName
				+ "\nCountry: " + country + "\nState: " + state + "\nCity: " + city + "\nZipCode: " + zipCode
				+ "\nStreetAddress: " + streetAddress;
	}

}
