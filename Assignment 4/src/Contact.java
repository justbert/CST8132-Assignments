/*FileName: Contact
 * Assignment 4
 *Course Name: CST8132 - Object Oriented Programming
 *LabSection: 301
 *Student Name: Justin Bertrand
 *Date: Nov 24th, 2014
 *
 *Description: A class of a contact which holds a first name, last name, and phone number.
 *
 *Based on UML documentation provided by Stan Pieda
 */

/**
 * A class representing a contact which could be found in an address book.
 * It holds a first name, a last name, and a phone number.
 * @author Justin Bertrand
 * @version 1.1
 * @since 1.8
 */
public class Contact {
	
	/**
	 * The first name of the contact.
	 */
	private String firstName;
	
	/**
	 * The last name of the contact.
	 */
	private String lastName;
	
	/**
	 * The phone number of the contact.
	 */
	private String phoneNumber;
	
	/**
	 * Constructor which takes a first name, last name and phone number.
	 * @param first The first name of the contact.
	 * @param last The last name of the contact.
	 * @param phone The contacts phone number.
	 * @throws ValidationException Throws a ValidationException if parameters contain whitespace, 
	 * are null, are empty, are too long, or contain a comma.
	 */
	public Contact(String first, String last, String phone) throws ValidationException {
		validateString(first, "first name", 25);
		this.firstName = first;
		validateString(last, "last name", 25);
		this.lastName = last;
		validateString(phone, "phone number", 15);
		this.phoneNumber = phone;
	}
	
	/**
	 * Default constructor which passes unknown to the previous constructor.
	 * @throws ValidationException Throws a ValidationException if parameters contain whitespace, 
	 * are null, are empty, are too long, or contain a comma.
	 */
	public Contact() throws ValidationException {
		this("unknown", "unknown", "unknown");
	}
	
	/**
	 * Returns the value of firstname.
	 * @return A String representing a first name.
	 */
	public String getFirstName() {
		return this.firstName;
	}
	
	/**
	 * Sets the firstname to the passed value.
	 * @param first The first name of the contact.
	 * @throws ValidationException Throws a ValidationException if first contains whitespace, 
	 * is null, is empty, is longer than 25 characters, or contains a comma.
	 */
	public void setFirstName(String first) throws ValidationException {
		validateString(first, "first name", 25);
		this.firstName = first;
	}
	
	/**
	 * Returns the value of lastName.
	 * @return A String representing the last name.
	 */
	public String getLastName() {
		return this.lastName;
	}
	
	/**
	 * Sets lastName to the value passed.
	 * @param last The last name of the contact.
	 * @throws ValidationException Throws a ValidationException if last contains whitespace, 
	 * is null, is empty, is longer than 25 characters, or contains a comma.
	 */
	public void setLastName(String last) throws ValidationException {
		validateString(last, "last name", 25);
		this.lastName = last;
	}
	
	/**
	 * Returns the phoneNumber.
	 * @return A String representing the phone number.
	 */
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	/**
	 * Sets the phoneNumber to the value passed.
	 * @param phone The phone number of the contact.
	 * @throws ValidationException Throws a ValidationException if phone contains whitespace, 
	 * is null, is empty, is longer than 15 characters, or contains a comma.
	 */
	public void setPhoneNumber(String phone) throws ValidationException {
		validateString(phone, "phone number", 15);
		this.phoneNumber = phone;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 * Returns a string of all the information of the contact in the form of 
	 * a comma seperated value(CSV). 
	 * Ex: firstName,lastName,phoneNumber
	 * 
	 * @return A String of the first name, last name, and phone number, 
	 * all seperated by commas.
	 */
	@Override
	public String toString() {
		return String.format("%s,%s,%s", this.firstName, this.lastName, this.phoneNumber);
	}
	
	/**
	 * A private method which takes in three parameters, a string, its name, and the maximum length it can be,
	 * and validates it. 
	 * @param value A string to be validated.
	 * @param fieldName The name of value's field.
	 * @param maxLength The maximum length which value can be.
	 * @throws ValidationException Throws a ValidationException if value contains whitespace, 
	 * is null, is empty, is longer than maxLength characters, or contains a comma.
	 */
	private static void validateString(String value, String fieldName, int maxLength) throws ValidationException {
		
		if(value == null || value.trim().isEmpty()) {
			throw new ValidationException(String.format("%s cannot be null, empty or only whitespace", fieldName));
		}
		
		if(value.length() > maxLength) {
			throw new ValidationException(String.format("%s cannot exceed %d characters", fieldName, maxLength));
		}
		
		if(value.contains(",")) {
			throw new ValidationException(String.format("%s cannot contain commas", fieldName));
		}
	}
}
