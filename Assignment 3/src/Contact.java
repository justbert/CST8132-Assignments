/*FileName: Contact
 * Assignment 3
 *Course Name: CST8132 - Object Oriented Programming
 *LabSection: 301
 *Student Name: Justin Bertrand
 *Date: Nov 10th, 2014
 *
 *Description: A class of a contact which holds a first name, last name, and phone number.
 *
 *Based on UML documentation provided by Stan Pieda
 */

public class Contact {
	
	private String firstName;
	private String lastName;
	private String phoneNumber;
	
	/*
	 * Constructor which takes a first name, last name and phone number.
	 */
	public Contact(String first, String last, String phone) throws ValidationException {
		validateString(first, "first name", 25);
		this.firstName = first;
		validateString(last, "last name", 25);
		this.lastName = last;
		validateString(phone, "phone number", 15);
		this.phoneNumber = phone;
	}
	
	/*
	 * Default constructor which passes unknown to the previous constructor.
	 */
	public Contact() throws ValidationException {
		this("unknown", "unknown", "unknown");
	}
	
	/*
	 * Returns the value of firstname.
	 */
	public String getFirstName() {
		return this.firstName;
	}
	
	/*
	 * Sets the firstname to the passed value.
	 */
	public void setFirstName(String first) throws ValidationException {
		validateString(first, "first name", 25);
		this.firstName = first;
	}
	
	/*
	 * Returns the value of lastName.
	 */
	public String getLastName() {
		return this.lastName;
	}
	
	/*
	 * Sets lastName to the value passed.
	 */
	public void setLastName(String last) throws ValidationException {
		validateString(last, "last name", 25);
		this.lastName = last;
	}
	
	/*
	 * Returns the phoneNumber.
	 */
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	/*
	 * Sets the phoneNumber to the value passed.
	 */
	public void setPhoneNumber(String phone) throws ValidationException {
		validateString(phone, "phone number", 15);
		this.phoneNumber = phone;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * Returns a string of all the information of the contact in the form of 
	 * firstName lastName phoneNumber
	 */
	@Override
	public String toString() {
		return String.format("%s,%s,%s", this.firstName, this.lastName, this.phoneNumber);
	}
	
	/*
	 * A private method which takes in three parameters, a string, its name, and the maximum length it can be,
	 * and validates it. 
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
