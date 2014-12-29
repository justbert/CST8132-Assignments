/*FileName: ContactManager
 *Assignment 4
 *Course Name: CST8132 - Object Oriented Programming
 *LabSection: 301
 *Student Name: Justin Bertrand
 *Date: Nov 24th, 2014
 *
 *Description: A contact manager which allows the addition, removal, sorting, and 
 *				printing of contacts stored in an arraylist.
 *
 *Based on UML documentation provided by Stan Pieda
 */

/**
 * This class allows the creation, removal, sorting, printing, loading, 
 * and saving of contacts into a file.
 * @author Justin Bertrand
 * @version 2.0
 * @since 1.8
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
	/**
	 * {@value #ADD_CONTACT} Static value used in the menu to add a contact.
	 */
	private static final int ADD_CONTACT = 1;
	
	/**
	 * @value 2 Static value used in the menu to remove a contact..
	 */
	private static final int REMOVE_CONTACT = 2;
	
	/**
	 * @value 3 Static value used in the menu to sort contacts by
	 * first name.
	 */
	private static final int SORT_FIRST_NAME = 3;
	
	/**
	 * @value 4 Static value used in the menu to sort contacts by
	 * last name.
	 */
	private static final int SORT_LAST_NAME = 4;
	
	/**
	 * @value 5 Static value used in the menu to view stored contacts.
	 */
	private static final int VIEW_CONTACTS = 5;
	
	/**
	 * @value 6 Static value used in the menu to modify a contact.
	 */
	private static final int MODIFY_CONTACT = 6;
	
	/**
	 * @value 7 Static value used in the menu to save contacts to a file.
	 */
	private static final int SAVE_CONTACTS = 7;
	
	/**
	 * @value 8 Static value used in the menu to load contacts from a file.
	 */
	private static final int LOAD_CONTACTS = 8;
	
	/**
	 * @value 9 Static value used in the menu to exit the program.
	 */
	private static final int EXIT = 9;
	
	/**
	 * A List to store contacts.
	 */
	private List<Contact> contacts;
	
	/**
	 * A Scanner that takes input in from the keyboard.
	 */
	private Scanner input;
	
	/**
	 * A boolean which tracks if changes have occured to contacts within
	 * the List.
	 */
	private boolean isModified = false;
	
	/**
	 * Default constructor which initializes the ArrayList and the Scanner.
	 */
	public ContactManager() {
		contacts = new ArrayList<Contact>();
		input = new Scanner(System.in);
	}
	
	/**
	 * Driving loop of the program. Allows multiple operations to be performed 
	 * on the catalog of contacts until the escape character is selected.
	 */
	public void runContactManager() {
		System.out.println("Welcome to ContactManager!\n");
		int choice = -1;
		
		while(choice != EXIT) {
			try {
				this.showMenu();
				choice = input.nextInt();
				input.nextLine();
				System.out.println();
				
				switch(choice) {
				case ADD_CONTACT:
					this.addContact();
					System.out.println();
					break;
				case REMOVE_CONTACT:
					this.removeContact();
					System.out.println();
					break;
				case SORT_FIRST_NAME:
					this.sortByFirstName();
					System.out.println();
					break;
				case SORT_LAST_NAME:
					this.sortByLastName();
					System.out.println();
					break;
				case VIEW_CONTACTS:
					this.viewContacts();
					System.out.println();
					break;
				case MODIFY_CONTACT:
					this.modifyContactMenu();
					System.out.println();
					break;
				case SAVE_CONTACTS:
					this.saveContacts();
					System.out.println();
					break;
				case LOAD_CONTACTS:
					if(this.isModified) {
						int yesOrNo = -1;
						while(yesOrNo != 1 && yesOrNo != 2 && yesOrNo != 3) {
							System.out.print("WARNING: Changes have been made but haven't been saved."
									+ "\nWould you like to save before loading a new file?"
									+ "\n1 - Yes"
									+ "\n2 - No"
									+ "\n3 - Cancel load operation"
									+ "\nChoice: ");
							yesOrNo = input.nextInt();
							try {
								input.nextLine();
								switch(yesOrNo) {
								case 1:
									this.saveContacts();
									this.loadContacts();
									break;
								case 2:
									System.out.println("Changes will not be saved.");
									this.loadContacts();
									break;
								case 3:
									System.out.println("Cancelling load operation.");
									break;
								default:
									System.out.println("Unrecognized Command: Please enter 1 for Yes, 2 for No, or 3 to Cancel");
								} 
							} catch (InputMismatchException e) {
								System.out.println("Incorrect Input: Please enter an integer.");
								input.nextLine();
							}
						}
					} else {
						this.loadContacts();
					}
					System.out.println();
					break;
				case EXIT:
					if(this.isModified) {
						int yesOrNo = -1;
						while(yesOrNo != 1 && yesOrNo != 2 && yesOrNo != 3) {
							System.out.print("WARNING: Changes have been made but haven't been saved."
									+ "\nWould you like to save before exiting?"
									+ "\n1 - Yes"
									+ "\n2 - No"
									+ "\n3 - Cancel Exiting"
									+ "\nChoice: ");
							try {
								yesOrNo = input.nextInt();
								input.nextLine();
								switch(yesOrNo) {
								case 1:
									this.saveContacts();
									break;
								case 2:
									System.out.println("Changes will not be saved.\nGoodbye!");
									break;
								case 3:
									System.out.println("Cancelling exit operation.\nGoodbye!");
									choice = -1;
									break;
								default:
									System.out.println("Unrecognized Command: Please enter 1 for Yes, 2 for No, 3 to Cancel the exit operation");
								}
							} catch (InputMismatchException e) {
								System.out.println("Incorrect Input: Please enter an integer.");
								input.nextLine();
							}
						}
					} else {
						System.out.println("Goodbye!");
					}
					System.out.println();
					break;
				default:
					System.out.print("Unrecognized Command: Please enter a number between 1 and 9");
					System.out.println();
				}
		
			} catch (InputMismatchException e) {
				System.out.println("Incorrect Input: Please enter an integer.");
				input.nextLine();
				System.out.println();
			}
		}
	}
	
	/**
	 * Method which prints the menu options and their corresponding input number.
	 */
	private void showMenu() {
		System.out.print("Main Menu"
				+ "\nPlease enter an option: "
				+ "\n1 Add contact"
				+ "\n2 Remove contact"
				+ "\n3 Sort by first name"
				+ "\n4 Sort by last name"
				+ "\n5 View contacts"
				+ "\n6 Modify contact"
				+ "\n7 Save contacts"
				+ "\n8 Load contacts"
				+ "\n9 Exit program"
				+ "\nChoice: ");
	}
	
	/**
	 * Method which adds one contact to the catalog if it follows the validation rules.
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
			this.isModified = true;
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
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
					System.out.print("Do you wish to remove this contact"
						+ "\n1 Yes"
						+ "\n2 No"
						+ "\nChoice: ");
				
					choice = input.nextInt();
					input.nextLine();
					
					switch(choice) {
					case 1: 
						System.out.println("Removing contact at index " + index);
						contacts.remove(index);
						this.isModified = true;
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
	
	/**
	 * Method which sorts the catalog of contacts by first name. Two options can be selected,
	 * either ascending order or descending order.
	 */
	private void sortByFirstName() {
		System.out.print("Sort by first name selected."
				+ "\nWould you like to sort by: "
				+ "\n1 Ascending order"
				+ "\n2 Descending order"
				+ "\n3 to Cancel operation"
				+ "\nChoice: ");
		
		int choice = -1;
		
		while(choice != 2 && choice != 1 && choice != 3) {
			try {
				choice = input.nextInt();
				input.nextLine();
				
				switch(choice) {
				case 1: 
					contacts.sort(ContactFirstNameComparator.getInstance());
					System.out.println("Contacts sorted by first name in ascending order.");
					this.isModified = true;
					break;
				case 2:
					contacts.sort(ContactFirstNameDescendingComparator.getInstance());
					System.out.println("Contacts sorted by first name in descending order.");
					this.isModified = true;
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

	/**
	 * Method which sorts the catalog of contacts by last name. Two options can be selected,
	 * either ascending order or descending order.
	 */
	private void sortByLastName() {
		System.out.print("Sort by last name selected."
				+ "\nWould you like to sort by:"
				+ "\n1 Ascending order"
				+ "\n2 Descending order"
				+ "\n3 to Cancel operation"
				+ "\nChoice: ");
		
		int choice = -1;
		
		while(choice != 2 && choice != 1 && choice != 3) {
			try {
				choice = input.nextInt();
				input.nextLine();
				
				switch(choice) {
				case 1: 
					contacts.sort(ContactLastNameComparator.getInstance());
					System.out.println("Contacts sorted by last name in ascending order.");
					this.isModified = true;
					break;
				case 2:
					contacts.sort(ContactLastNameDescendingComparator.getInstance());
					System.out.println("Contacts sorted by last name in descending order.");
					this.isModified = true;
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
	
	/**
	 * Method which prints all the contacts along with their indexes.
	 */
	private void viewContacts() {
		if(contacts.isEmpty()) {
			System.out.println("No contacts to display");
		} else {
			System.out.println("Contacts stored: ");
			for(int index = 0; index < contacts.size(); ++index) {
				StringBuilder builder = new StringBuilder();
				System.out.println(builder.append("Index: ").append(index).append(" Contact: ").append(contacts.get(index).toString()));
			}
		}
		
	}
	
	/**
	 * Method which runs the selection menu for modifying a contact.
	 */
	private void modifyContactMenu() {
		System.out.print("Please enter the index of the contact to modify: ");
		int index = -1;
		int choice = -1;
		
		while(choice != 2 && choice != 1) {
			try {
				index = input.nextInt();
				input.nextLine();
				System.out.println(contacts.get(index).toString());
				System.out.print("Do you wish to modify this contact"
					+ "\n1 Yes"
					+ "\n2 No"
					+ "\nChoice: ");
			
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
	
	/**
	 * Method which allows a contacts first name, last name and phone number to be modified.
	 * @param contact The contact that will be modified.
	 */
	private void modifyContact(Contact contact) {
		int choice = -1;
		
		while(choice != 4) {
			System.out.print("Please choose an option:"
					+ "\n1 Modify first name"
					+ "\n2 Modify last name"
					+ "\n3 Modify phone number"
					+ "\n4 Return to main menu"
					+ "\nChoice: ");
			try {
			choice = input.nextInt();
			input.nextLine();
			
				switch(choice) {
				case 1:
					System.out.print("Enter the new first name: ");
					contact.setFirstName(input.nextLine());
					System.out.println("First name changed to " + contact.getFirstName());
					this.isModified = true;
					break;
				case 2:
					System.out.print("Enter the new last name: ");
					contact.setLastName(input.nextLine());
					System.out.println("Last name changed to " + contact.getLastName());
					this.isModified = true;
					break;
				case 3: 
					System.out.print("Enter the new phone number: ");
					contact.setPhoneNumber(input.nextLine());
					System.out.println("Phone number changed to " + contact.getPhoneNumber());
					this.isModified = true;
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
	
	/**
	 * Method which allows a user to save their contacts' information to a CSV file of their choice.
	 */
	private void saveContacts() {
		int choice = -1;
		
		if(this.contacts.isEmpty()) {
			
			System.out.println("Contact list empty, nothing to save. \nReturning to main menu.");
			
		} else {
			
			System.out.print("Please enter the name of the file you would like to save to: ");
			File file = new File(this.input.nextLine() + ".contacts");
			
			if(file.exists()) {
				
				while(choice != 1 && choice != 2) {
					
					try(Formatter output = new Formatter(new FileWriter(file))) {
						
						System.out.print("WARNING: A file with that name currently exists."
								+ "\nDo you wish to overwrite this file?"
								+ "\n1 - Yes"
								+ "\n2 - No"
								+ "\nChoice: ");
						choice = input.nextInt();
						input.nextLine();
						
						switch(choice) {
						case 1:
							System.out.println("Saving contacts to file " + file.getName());
							for(int index = 0; index < this.contacts.size(); ++index) {
								output.format("%s%n", this.contacts.get(index));
							}
							System.out.println("Contacts saved.");
							this.isModified = false;
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
					} catch(InputMismatchException e) {
						System.out.println("Incorrect Input: Please enter an integer.");
						input.nextLine();
					}
				}
			} else {
				try(Formatter output = new Formatter(new FileWriter(file))) {
					
					System.out.println("Saving contacts to file " + file.getName());
					for(int index = 0; index < this.contacts.size(); ++index) {
						output.format("%s%n", this.contacts.get(index));
					}
					System.out.println("Contacts saved.");
					this.isModified = false;
					
				} catch(IOException ex) {
					System.out.println("IOException: " + ex.getMessage());
				} 
			}
		}
	}
	
	/**
	 * Method which allows a user to load a user specified contact CSV file into memory.
	 */
	private void loadContacts() {
		
		//The following code block was taken from Rex Woolard, Personal Communication (2014)
		String absolutePathString = new File(".").getAbsolutePath();
		absolutePathString = absolutePathString.substring(0, (absolutePathString.length()-2));
		File currentDirectory = new File(absolutePathString);
		//end of block
		
		File[] fileList = currentDirectory.listFiles();
		
		System.out.println("Contact filenames which can be loaded: ");
		boolean containsContactsFile = false;
		for(int index= 0; index < fileList.length; ++index) {
			if(fileList[index].getName().endsWith(".contacts")) {
				System.out.println(fileList[index].getName().substring(0, (fileList[index].getName().length() - ".contacts".length())));
				containsContactsFile = true;
			}
		}
		
		if(!containsContactsFile) {
			System.out.println("No contact files to load. Returning to Main Menu.");
		} else {
			
			System.out.print("Please enter the name of the file you would like to load: ");
			File loadFile = new File(input.nextLine() + ".contacts");
			
			if(loadFile.exists()) {
				
				System.out.println("Loading contacts from " + loadFile.getName());
				try(Scanner loader = new Scanner(new FileReader(loadFile))) {
					
					this.contacts.clear();
					
					String[] contactInfo;
					while(loader.hasNext()) {
						contactInfo = loader.next().split(",");
						contacts.add(new Contact(contactInfo[0], contactInfo[1], contactInfo[2]));
					}
					
					System.out.println(this.contacts.size() + " contacts loaded from file.");
				} catch(FileNotFoundException ex) {
					System.out.println("File Not Found: " + ex.getMessage());
				} catch(ValidationException ex) {
					System.out.println(ex.getMessage());
				}
				
			} else {
				System.out.println("No file of that name exists. Returning to Main Menu.");
			} //end of if
			
			this.isModified = false;
		}//end of if
	}//end of loadContacts()
}//end of class
