package com.example.conmancontactmanager;//package com.example.conman;
//
//
//import com.example.conman.BusinessService;
//import com.example.conman.BaseContact;
//import com.example.conman.BusinessContact;
//import com.example.conman.PersonContact;
//
//import java.util.Scanner;
//
//
//public class testingOnly {
//
//	public static void main(String[] args) {
//
//		BusinessService bs = new BusinessService();
//
////		// Person 2
////		PersonContact p2 = new PersonContact("Collin Willis", "1-800-800-8000", "collinwillis@example.com", "photo.jpg",
////				"United States", "Arizona", "Phoenix", "85017", "3300 W. Cammelback Rd.", "October 20, 2000");
////		bs.addressbook.addOne(p2);
////		// Person 3
////		PersonContact p3 = new PersonContact("Layton Nowlin", "1-800-800-8000", "laytonnowlin@example.com", "photo.jpg",
////				"United States", "Arizona", "Phoenix", "85017", "3300 W. Cammelback Rd.", "October 20, 2000");
////
////		bs.addressbook.addOne(p3);
////
////		// Business Contact 1
////		BusinessContact b1 = new BusinessContact("Burger King", "1-800-800-8000", "business@example.com", "photo.jpg",
////				"United States", "Arizona", "Phoenix", "85017", "3300 W. Cammelback Rd.", "10:00 a.m.", "5:00 p.m.",
////				null, "http://www.example.com");
////
////		bs.addressbook.addOne(b1);
//
//		Scanner scn = new Scanner(System.in);
//		int input = -1;
//
//		System.out.println("Starting");
//
//		while (input != 99) {
//			System.out.println("\n=======Con-Man Contact Manager=======");
//			System.out.println("Main menu.  Please select an option");
//			System.out.println("1 Show list of all contacts");
//			System.out.println("2 Show list of all personal contacts");
//			System.out.println("3 Show list of all business contacts");
//			System.out.println("4 Search for a contact");
//			System.out.println("5 Update/Edit a contact");
//			System.out.println("6 Create a new contact");
//			System.out.println("7 Delete a contact");
//			System.out.println("8 Call Contact");
//			// System.out.println("9 Text Contact");
//			// System.out.println("10 Email Contact");
//			System.out.println("11 Load all contact data from file");
//			System.out.println("12 Save all contact data to a file");
//			System.out.println("99 Exit");
//
//			System.out.println("");
//
//			input = scn.nextInt();
//			scn.nextLine();
//
//			System.out.println("");
//
//			if (input == 1) {
//				System.out.println("You have chosen to see a list of all contacts.");
//				System.out.println("The contacts in the list include: ");
//				System.out.println(bs.addressbook.toString());
//
//			}
//			// View Personal Contacts
//			else if (input == 2) {
//				System.out.println("You have chosen to see a list of all personal contacts.");
//				for (BaseContact b : bs.addressbook.getTheList()) {
//					if (b instanceof PersonContact) {
//						System.out.println(b);
//					} else {
//
//					}
//				}
//			}
//			// View Business Contacts
//			else if (input == 3) {
//				System.out.println("You have chosen to see a list of all business contacts.");
//				for (BaseContact b : bs.addressbook.getTheList()) {
//					if (b instanceof BusinessContact) {
//						System.out.println(b);
//					} else {
//
//					}
//				}
//			}
//			// Search
//			else if (input == 4) {
//				System.out.println("You have chosen to search for a contact.");
//				System.out.println("Please enter what you would like to search for.");
//				Scanner searchin = new Scanner(System.in);
//				String searchstring = searchin.next();
//				System.out.println("\n\nSearching for Contacts that include: " + searchstring);
//				System.out.println(bs.getList().searchFor(searchstring).toString());
//			}
//			// Update/Edit
//			else if (input == 5) {
//
//				// alternative to the foreach loop
//				for (int i = 0; i < bs.addressbook.getTheList().size(); i++) {
//
//					System.out.println("\n\nContact # " + i + bs.addressbook.getTheList().get(i));
//
//				}
//
//				System.out.println("You have chosen to update/edit a contact.");
//
//				System.out.println("\n\nWhat contact would you like to update?");
//
//				Scanner getcontact = new Scanner(System.in);
//				int toupdate = getcontact.nextInt();
//				System.out.println("You would like to update: " + bs.getList().getTheList().get(toupdate).toString());
//
//				if (bs.getList().getTheList().get(toupdate) instanceof BusinessContact) {
//
//					System.out.println("\n");
//					System.out.println("Updated Business Name: ");
//					Scanner namescn = new Scanner(System.in);
//					String nameinput = namescn.nextLine();
//					System.out.println("Updated Business Phone Number: ");
//					Scanner numberscn = new Scanner(System.in);
//					String numinput = numberscn.nextLine();
//					System.out.println("Updated Business Email: ");
//					Scanner emailscn = new Scanner(System.in);
//					String emailinput = emailscn.nextLine();
//					System.out.println("Updated Photo: ");
//					Scanner photoscn = new Scanner(System.in);
//					String photoinput = photoscn.nextLine();
//					System.out.println("Updated Country: ");
//					Scanner countryscn = new Scanner(System.in);
//					String countryinput = countryscn.nextLine();
//					System.out.println("Updated State: ");
//					Scanner statescn = new Scanner(System.in);
//					String stateinput = statescn.nextLine();
//					System.out.println("Updated City: ");
//					Scanner cityscn = new Scanner(System.in);
//					String cityinput = cityscn.nextLine();
//					System.out.println("Updated Zip Code: ");
//					Scanner zipscn = new Scanner(System.in);
//					String zipinput = zipscn.nextLine();
//					System.out.println("Updated Street Address: ");
//					Scanner streetscn = new Scanner(System.in);
//					String streetinput = streetscn.nextLine();
//					System.out.println("Opens: ");
//					Scanner openscn = new Scanner(System.in);
//					String openinput = openscn.nextLine();
//					System.out.println("Closes: ");
//					Scanner closescn = new Scanner(System.in);
//					String closeinput = closescn.nextLine();
//					System.out.println("Updated Business URL: ");
//					Scanner urlscn = new Scanner(System.in);
//					String urlinput = urlscn.nextLine();
//
//					BusinessContact updated = new BusinessContact(nameinput, numinput, emailinput, photoinput,
//							countryinput, stateinput, cityinput, zipinput, streetinput, openinput, closeinput,
//							urlinput);
//
//					bs.addressbook.deleteOne(bs.addressbook.getTheList().get(toupdate));
//					bs.addressbook.addOne(updated);
//					System.out.println("Your new updated contact is: ");
//					System.out.println(updated.toString());
//
//
//				}
//
//				else {
//
//					System.out.println("\n");
//					System.out.println("Updated Name: ");
//					Scanner namescn = new Scanner(System.in);
//					String nameinput = namescn.nextLine();
//					System.out.println("Updated Phone Number: ");
//					Scanner numberscn = new Scanner(System.in);
//					String numinput = numberscn.nextLine();
//					System.out.println("Updated Email: ");
//					Scanner emailscn = new Scanner(System.in);
//					String emailinput = emailscn.nextLine();
//					System.out.println("Updated Photo: ");
//					Scanner photoscn = new Scanner(System.in);
//					String photoinput = photoscn.nextLine();
//					System.out.println("Updated Country: ");
//					Scanner countryscn = new Scanner(System.in);
//					String countryinput = countryscn.nextLine();
//					System.out.println("Updated State: ");
//					Scanner statescn = new Scanner(System.in);
//					String stateinput = statescn.nextLine();
//					System.out.println("Updated City: ");
//					Scanner cityscn = new Scanner(System.in);
//					String cityinput = cityscn.nextLine();
//					System.out.println("Updated Zip Code: ");
//					Scanner zipscn = new Scanner(System.in);
//					String zipinput = zipscn.nextLine();
//					System.out.println("Updated Street Address: ");
//					Scanner streetscn = new Scanner(System.in);
//					String streetinput = streetscn.nextLine();
//					System.out.println("Updated Date Of Birth: ");
//					Scanner birthdatescn = new Scanner(System.in);
//					String birthdateinput = birthdatescn.nextLine();
//
//					PersonContact updated = new PersonContact(nameinput, numinput, emailinput, photoinput, countryinput,
//							stateinput, cityinput, zipinput, streetinput, birthdateinput);
//
//					bs.addressbook.addOne(updated);
//					bs.getList().deleteOne(bs.addressbook.getTheList().get(toupdate));
//					System.out.println("Your new updated contact is: ");
//					System.out.println(updated.toString());
//
//				}
//
//			}
//			// Create New Contact
//			else if (input == 6) {
//				System.out.println("You have chosen to create a new contact.");
//				System.out.println("Press (1) to creat a Personal Contact.");
//				System.out.println("Press (2) to creat a Business Contact.");
//				Scanner pickone = new Scanner(System.in);
//				int pick1 = pickone.nextInt();
//
//				if (pick1 == 1) {
//					System.out.println("Name: ");
//					Scanner namescn = new Scanner(System.in);
//					String nameinput = namescn.nextLine();
//					System.out.println("Phone Number: ");
//					Scanner numberscn = new Scanner(System.in);
//					String numinput = numberscn.nextLine();
//					System.out.println("Email: ");
//					Scanner emailscn = new Scanner(System.in);
//					String emailinput = emailscn.nextLine();
//					System.out.println("Photo: ");
//					Scanner photoscn = new Scanner(System.in);
//					String photoinput = photoscn.nextLine();
//					System.out.println("Country: ");
//					Scanner countryscn = new Scanner(System.in);
//					String countryinput = countryscn.nextLine();
//					System.out.println("State: ");
//					Scanner statescn = new Scanner(System.in);
//					String stateinput = statescn.nextLine();
//					System.out.println("City: ");
//					Scanner cityscn = new Scanner(System.in);
//					String cityinput = cityscn.nextLine();
//					System.out.println("Zip Code: ");
//					Scanner zipscn = new Scanner(System.in);
//					String zipinput = zipscn.nextLine();
//					System.out.println("Street Address: ");
//					Scanner streetscn = new Scanner(System.in);
//					String streetinput = streetscn.nextLine();
//					System.out.println("Date Of Birth: ");
//					Scanner birthdatescn = new Scanner(System.in);
//					String birthdateinput = birthdatescn.nextLine();
//
//					PersonContact created = new PersonContact(nameinput, numinput, emailinput, photoinput, countryinput,
//							stateinput, cityinput, zipinput, streetinput, birthdateinput);
//
//					bs.addressbook.addOne(created);
//
//					System.out.println(
//							"/nCongratulations! " + created.getname() + " has been added to the address book!");
//
//					System.out.println(created.toString());
//				} else if (pick1 == 2) {
//					System.out.println("Business Name: ");
//					Scanner namescn = new Scanner(System.in);
//					String nameinput = namescn.nextLine();
//					System.out.println("Business Phone Number: ");
//					Scanner numberscn = new Scanner(System.in);
//					String numinput = numberscn.nextLine();
//					System.out.println("Business Email: ");
//					Scanner emailscn = new Scanner(System.in);
//					String emailinput = emailscn.nextLine();
//					System.out.println("Photo: ");
//					Scanner photoscn = new Scanner(System.in);
//					String photoinput = photoscn.nextLine();
//					System.out.println("Country: ");
//					Scanner countryscn = new Scanner(System.in);
//					String countryinput = countryscn.nextLine();
//					System.out.println("State: ");
//					Scanner statescn = new Scanner(System.in);
//					String stateinput = statescn.nextLine();
//					System.out.println("City: ");
//					Scanner cityscn = new Scanner(System.in);
//					String cityinput = cityscn.nextLine();
//					System.out.println("Zip Code: ");
//					Scanner zipscn = new Scanner(System.in);
//					String zipinput = zipscn.nextLine();
//					System.out.println("Street Address: ");
//					Scanner streetscn = new Scanner(System.in);
//					String streetinput = streetscn.nextLine();
//					System.out.println("Opens: ");
//					Scanner openscn = new Scanner(System.in);
//					String openinput = openscn.nextLine();
//					System.out.println("Closes: ");
//					Scanner closescn = new Scanner(System.in);
//					String closeinput = closescn.nextLine();
//					System.out.println("Business URL: ");
//					Scanner urlscn = new Scanner(System.in);
//					String urlinput = urlscn.nextLine();
//
//					BusinessContact created = new BusinessContact(nameinput, numinput, emailinput, photoinput,
//							countryinput, stateinput, cityinput, zipinput, streetinput, openinput, closeinput,
//							urlinput);
//
//					bs.addressbook.addOne(created);
//
//					System.out.println(
//							"/nCongratulations! " + created.getname() + " has been added to the address book!");
//
//					System.out.println(created.toString());
//				}
//			}
//			// Delete Contact
//			else if (input == 7) {
//				System.out.println("You have chosen to delete a contact.");
//				System.out.println(bs.addressbook.toString());
//				System.out.println("Please enter the contact you would like to delete.");
//				Scanner deletein = new Scanner(System.in);
//				int deletethis = deletein.nextInt();
//				deletein.close();
//				bs.getList().deleteOne(bs.addressbook.getTheList().get(deletethis));
//
//			}
//
//			// Load Contacts
//			else if (input == 11) {
//				System.out.println("You have chosen to load all contacts from a file.");
//
//				//bs = bs.loadAllLists();
//				System.out.println(bs.addressbook.toString());
//
//			}
//
//			// Save Contacts
//			else if (input == 12) {
//
//				System.out.println("You have chosen to save all contacts to a file.");
//				//s.saveAllLists();
//				System.out.println("\nAll contacts saved.");
//			}
//			// Exit Application
//			else if (input == 99) {
//				System.out.println("You have chosen to exit the application.");
//				System.out.println("Application closing.");
//
//				System.exit(0);
//			}
//			// Call Contact
//			else if (input == 8) {
//				Scanner rndscn = new Scanner(System.in);
//				for (int i = 0; i < bs.addressbook.getTheList().size(); i++) {
//
//					System.out.println("\n\nContact # " + i + bs.addressbook.getTheList().get(i));
//
//				}
//				System.out.println("\nWho would you like to call?");
//				Scanner callscn = new Scanner(System.in);
//				int callin = callscn.nextInt();
//				System.out.println("\nNow calling " + bs.getList().getTheList().get(callin).getname() + ": "
//						+ bs.getList().getTheList().get(callin).getPhoneNo());
//				System.out.println("\nCall complete.");
//
//			}
//			// Invalid Option
//			else {
//				System.out.println("You have entered an invalid number. Please try again.");
//			}
//
//		}
//
//	}
//
//}
