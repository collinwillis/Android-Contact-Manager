package com.example.conmancontactmanager;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {

	// AddressBook is the main data storage in the entire application.
	// this class demonstrates the use of generics.
	private List<BaseContact> theList;

	// default constructor creates an empty list of type BaseContact.
	public AddressBook() {
		this.theList = new ArrayList<BaseContact>();

	}

	// add one person/business contact to the list.
	// The T generic data type allows this function to handle any class inherited
	// from
	// The BaseContact - person or business
	public <T extends BaseContact> void addOne(T contact) {
		this.theList.add(contact);
	}

	// Remove a contact from the main list. Return true for success. Return false
	// for failure.
	public <T extends BaseContact> boolean deleteOne(T contact) {
		if (this.theList.contains(contact)) {
			this.theList.remove(contact);
			return true;
		} else {
			return false;
		}

	}

	@JsonIgnore
	public int getSize() {
		return theList.size();
	}

	// the search function
	public List<BaseContact> searchFor(String s) {
		List<BaseContact> sList = new ArrayList<BaseContact>();

		for (BaseContact c : theList) {
			if (c.name.contains(s)) {
				sList.add(c);
			}

			if (c.name.toLowerCase().startsWith(s)) {
				System.out.println("you've searched for: " + c.name);
			}
		}
		return sList;

	}

	public void Call(BaseContact c) {

		System.out.println("now calling " + c.name + ": " + c.phoneNo);
	}

	public void Text(BaseContact c) {

		System.out.println("now texting " + c.name + ": " + c.phoneNo);
	}

	public void Navigate(BaseContact c) {

		System.out.println("now navigating to " + c.name + ": " + c.streetAddress);
	}

	public List<BaseContact> getTheList() {
		return this.theList;
	}

	public void openUrl(BusinessContact b) {
		System.out.println("Opening in chrome: " + b.url);
	}

	@Override
	public String toString() {
		return "List of Contacts: " + theList;
	}

}
