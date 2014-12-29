/*FileName: ContactManager
 *Assignment 3
 *Course Name: CST8132 - Object Oriented Programming
 *LabSection: 301
 *Student Name: Justin Bertrand
 *Date: Nov 10th, 2014
 *
 *Description: A contact manager which allows the addition, removal, sorting, and 
 *				printing of contacts stored in an arraylist.
 *
 *Based on UML documentation provided by Stan Pieda
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ContactManager {
	
	/*
	 * Static values used for the menu
	 */
	private static final int ADD_CONTACT = 1;
	private static final int REMOVE_CONTACT = 2;
	private static final int SORT_FIRST_NAME = 3;
	private static final int SORT_LAST_NAME = 4;
	private static final int VIEW_CONTACTS = 5;
	private static final int MODIFY_CONTACT = 6;
	private static final int SAVE_CONTACTS = 7;
	private static final int LOAD_CONTACTS = 8;
	private static final int EXIT = 9;
	
	private List<Contact> contacts;
	private Scanner input;
	
	/*
	 * Default constructor which initializes the arraylist and the scanner.
	 */
	public ContactManager() {
		contacts = new ArrayList<Contact>();
		input = new Scanner(System.in);
	}
	
	/*
	 * Driving loop of the program. Allows multiple operations to be performed 
	 * on the catalog of contacts until the escape character is selected.
	 */
	public void runContactManager() {
		System.out.println("Welcome to ContactManager!");
		int choice = -1;
		
		while(choice != EXIT) {
			try {
				this.showMenu();
				choice = input.nextInt();
				input.nextLine();
				
				switch(choice) {
				case ADD_CONTACT:
					this.addContact();
					break;
				case REMOVE_CONTACT:
					this.removeContact();
					break;
				case SORT_FIRST_NAME:
					this.sortByFirstName();
					break;
				case SORT_LAST_NAME:
					this.sortByLastName();
					break;
				case VIEW_CONTACTS:
					this.viewContacts();
					break;
				case MODIFY_CONTACT:
					this.modifyContactMenu();
					break;
				case SAVE_CONTACTS:
					this.saveContacts();
					break;
				case LOAD_CONTACTS:
					this.loadContacts();
					break;
				case EXIT:
					System.out.println("Goodbye!");
					break;
				default:
					System.out.print("Unrecognized Command: Please enter a number between 1 and 7");
				}
		
			} catch (InputMismatchException e) {
				System.out.println("Incorrect Input: Please enter and integer.");
				input.nextLine();
			}
		}
	}
	
	/*
	 * Method which prints the menu options and they're corresponding input number.
	 */
	private void showMenu() {
		System.out.println("Please enter an option: "
				+ "\n1 Add contact"
				+ "\n2 Remove contact"
				+ "\n3 Sort by first name"
				+ "\n4 Sort by last name"
				+ "\n5 View contacts"
				+ "\n6 Modify contact"
				+ "\n7 Save contacts"
				+ "\n8 Load contacts"
				+ "\n9 Exit program");
	}
	
	/*
	 * Method which adds one contact to the catalog.
	 */
	private void addContact() {
		System.out.print("Please enter first name: ");
		String fName = input.nextLine();
		
		System.out.print("Please enter last name: ");
		String lName = input.nextLine();
		
		System.out.print("Please enter phone number: ");
		String pNumber = input.nextLine();
		
		try {
			contacts.add(new Contact(fName, lName, pNumber));
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/*
	 * Method which allows to delete a contact by its index number.
	 */
	private void removeContact() {
		int index = -1;
		int choice = 0;
		
		if(contacts.isEmpty()) {
			System.out.println("No contacts to delete. Returning to main menu.");
		} else {
			while(choice != 2 && choice != 1) {
				try {
					System.out.print("Please enter the index of the contact to remove: ");
					index = input.nextInt();
					System.out.println(contacts.get(index).toString());
					System.out.println("Do you wish to remove this contact"
						+ "\n1 Yes"
						+ "\n2 No");
				
					choice = input.nextInt();
					input.nextLine();
					
					switch(choice) {
					case 1: 
						System.out.println("Removing contact at index " + index);
						contacts.remove(index);
						break;
					case 2:
						System.out.println("Not removing contact.");
						break;
					default:
						System.out.println("Unrecognized Command: Please enter 1 for Yes or 2 for No");
					}
			
				} catch(IndexOutOfBoundsException e) {
					System.out.println("Error: Not a valid index number");
					input.nextLine();
				} catch(InputMismatchException e) {
					System.out.println("Incorrect Input: Please enter an integer");
					input.nextLine();
				}
			}
		}
	}
	
	/*
	 * Method which sorts the catalog of contacts by first name. Two options can be selected,
	 * either ascending order or descending order.
	 */
	private void sortByFirstName() {
		System.out.println("Sort by first name selected."
				+ "\nWould you like to sort by:"
				+ "\n1 Ascending order"
				+ "\n2 Descending order"
				+ "\n3 to Cancel operation");
		
		int choice = -1;
		
		while(choice != 2 && choice != 1 && choice != 3) {
			try {
				choice = input.nextInt();
				input.nextLine();
				
				switch(choice) {
				case 1: 
					contacts.sort(new ContactFirstNameComparator());
					System.out.println("Contacts sorted by first name in ascending order.");
					break;
				case 2:
					contacts.sort(new ContactFirstNameDescendingComparator());
					System.out.println("Contacts sorted by first name in descending order.");
					break;
				case 3:
					System.out.println("Cancelling sorting operation.");
				default:
					System.out.println("Unrecognized Command: Please enter 1 for Ascending, 2 for Descending or 3 to Cancel");
				}
				
			} catch (InputMismatchException e) {
				System.out.println("Incorrect Input: Please enter an integer");
				input.nextLine();
			}
		}
	}

	/*
	 * Method which sorts the catalog of contacts by last name. Two options can be selected,
	 * either ascending order or descending order.
	 */
	private void sortByLastName() {
		System.out.println("Sort by last name selected."
				+ "\nWould you like to sort by:"
				+ "\n1 Ascending order"
				+ "\n2 Descending order"
				+ "\n3 to Cancel operation");
		
		int choice = -1;
		
		while(choice != 2 && choice != 1 && choice != 3) {
			try {
				choice = input.nextInt();
				input.nextLine();
				
				switch(choice) {
				case 1: 
					contacts.sort(new ContactLastNameComparator());
					System.out.println("Contacts sorted by last name in ascending order.");
					break;
				case 2:
					contacts.sort(new ContactLastNameDescendingComparator());
					System.out.println("Contacts sorted by last name in descending order.");
					break;
				case 3:
					System.out.println("Cancelling sorting operation.");
				default:
					System.out.println("Unrecognized Command: Please enter 1 for Ascending, 2 for Descending or 3 to Cancel");
				}
				
			} catch (InputMismatchException e) {
				System.out.println("Incorrect Input: Please enter an integer");
				input.nextLine();
			}
		}
	}
	
	/*
	 * Method which prints all the contacts along with their indexes.
	 */
	private void viewContacts() {
		if(contacts.isEmpty()) {
			System.out.println("No contacts to display");
		} else {
			for(int index = 0; index < contacts.size(); ++index) {
				StringBuilder builder = new StringBuilder();
				System.out.println(builder.append("Index: ").append(index).append(" Contact: ").append(contacts.get(index).toString()));
			}
		}
		
	}
	
	private void modifyContactMenu() {
		System.out.print("Please enter the index of the contact to modify: ");
		int index = -1;
		int choice = -1;
		
		while(choice != 2 && choice != 1) {
			try {
				index = input.nextInt();
				input.nextLine();
				System.out.println(contacts.get(index).toString());
				System.out.println("Do you wish to modify this contact"
					+ "\n1 Yes"
					+ "\n2 No");
			
				choice = input.nextInt();
				input.nextLine();
				
				switch(choice) {
				case 1: 
					System.out.println("Modifying contact at index " + index);
					modifyContact(contacts.get(index));
					break;
				case 2:
					System.out.println("Not modifying contact. Returning to menu.");
					break;
				default:
					System.out.println("Unrecognized Command: Please enter 1 for Yes or 2 for No");
				}
		
			} catch(IndexOutOfBoundsException e) {
				System.out.println("Error: Not a valid index number");
			} catch(InputMismatchException e) {
				System.out.println("Incorrect Input: Please enter an integer");
				input.nextLine();
			}
		}
	}
	
	private void modifyContact(Contact contact) {
		int choice = -1;
		
		while(choice != 4) {
			System.out.println("Please choose an option:"
					+ "\n1 Modify first name"
					+ "\n2 Modify last name"
					+ "\n3 Modify phone number"
					+ "\n4 Return to main menu");
			try {
			choice = input.nextInt();
			input.nextLine();
			
				switch(choice) {
				case 1:
					System.out.print("Enter the new first name: ");
					contact.setFirstName(input.nextLine());
					System.out.println("First name changed to " + contact.getFirstName());
					break;
				case 2:
					System.out.print("Enter the new last name: ");
					contact.setLastName(input.nextLine());
					System.out.println("Last name changed to " + contact.getLastName());
					break;
				case 3: 
					System.out.print("Enter the new phone number: ");
					contact.setPhoneNumber(input.nextLine());
					System.out.println("Phone number changed to " + contact.getPhoneNumber());
					break;
				case 4:
					System.out.println("Returning to main menu.");
					break;
				default:
					System.out.println("Unrecognized Command: Please enter an option between 1 to 4");
				}
			} catch(ValidationException e) {
				System.out.println(e.getMessage());
			} catch(InputMismatchException e) {
				System.out.println("Incorrect Input: Please enter an integer");
				input.nextLine();
			}
		}
	}
	
	private void saveContacts() {
		int choice = -1;
		if(this.contacts.isEmpty()) {
			System.out.println("Contact list empty, nothing to save. \nReturning to main menu.");
		} else {
			System.out.print("Please enter the name of the file you would like to save to: ");
			File file = new File(this.input.nextLine());
			if(file.exists()) {
				while(choice != 1 && choice != 2) {
					try(Formatter output = new Formatter(new FileWriter(file))) {
						System.out.println("WARNING: A file with that name currently exists."
								+ "\nDo you wish to overwrite this file?"
								+ "\n1 - Yes"
								+ "\n2 - No");
						choice = input.nextInt();
						switch(choice) {
						case 1:
							System.out.println("Saving contacts to file " + file.getName());
							for(int index = 0; index < this.contacts.size(); ++index) {
								output.format("%s%n", this.contacts.get(index));
							}
							System.out.println("Contacts saved.");
							break;
						case 2:
							System.out.println("Save operation cancelled, returning to main menu.");
							break;
						default:
							System.out.println("Incorrect Input: Please enter an integer");
							input.nextLine();	
							
						}
						
					} catch(IOException ex) {
						System.out.println("IOException: " + ex.getMessage());
					}
				}
			} else {
				try(Formatter output = new Formatter(new FileWriter(file))) {
					
				} catch(IOException ex) {
					System.out.println("IOException: " + ex.getMessage());
				}
			}
		}
	}
	
	private void loadContacts() {
		
	}
}
