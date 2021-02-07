package com.example.conmancontactmanager;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BusinessService {

	public AddressBook addressbook;

	// this is an object to hold the global variables and methods the persist data.
	// "list" is the main storage structure in the entire application.
	public BusinessService(AddressBook list) {
		super();
		this.setList(list);
	}

	public BusinessService() {
		super();
		this.setList(new AddressBook());
	}

//	public void saveAllLists() {
//		DataAccessService das = new FileIOService();
//		das.writeAllData(this, "contacts.json");
//	}

//	public BusinessService loadAllLists() {
//		DataAccessService das = new FileIOService();
//		return das.readAllData("contacts.json");
//	}

	// getters and setters
	public AddressBook getList() {
		return addressbook;
	}


	@JsonIgnore
	public void setList(AddressBook list) {
		this.addressbook = list;
	}

	@Override
	public String toString() {
		return "BusinessService [list=" + addressbook + "]\n";
	}


}
