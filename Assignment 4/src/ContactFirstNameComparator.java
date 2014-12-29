/*FileName: ContactFirstNameComparator
 *Assignment 4
 *Course Name: CST8132 - Object Oriented Programming
 *LabSection: 301
 *Student Name: Justin Bertrand
 *Date: Nov 24th, 2014
 *
 *Description: A comparator used to sort Contact first names in ascending order.
 *
 *Based on code provided by Stan Pieda as part of Assignment 3 in the aforementioned course.
 */

/**
 * A Singleton based Comparator which allows for the sorting of Contact objects by
 * first name in an ascending order.
 * @author Justin Bertrand
 * @version 2.0
 * @since 1.8
 */

import java.util.Comparator;

public class ContactFirstNameComparator implements Comparator<Contact> {
	
	/**
	 * An instance of ContactFirstNameComparator which is returned
	 * instead a new object being created.
	 */
	private static ContactFirstNameComparator INSTANCE = null;
	
	/**
	 * An empty private default constructor to prevent the creation of
	 * instances other than the INSTANCE.
	 */
	private ContactFirstNameComparator() {}
	
	/**
	 * Returns an instance of a ContactFirstNameComparator.
	 * @return Returns the Static INSTANCE. This method is used instead
	 * of a constructor.
	 */
	public static ContactFirstNameComparator getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new ContactFirstNameComparator();
		}
		return INSTANCE;
	}
	
	/**
	 * Compares two Contacts by first name using ascending alphanumerical comparison returning a negative number
	 * if arg0 comes before arg1, 0 if the two are equal, and a positive number if arg0 goes after arg1.
	 * @param arg0 A Contact object that will be compared to sort
	 * @param arg1 A Contact object that will be compared to sort
	 * @return  Integer representing in which order arg0 comes relatively to arg1
	 */
	@Override
	public int compare(Contact arg0, Contact arg1) {
		return arg0.getFirstName().compareTo(arg1.getFirstName());
	}
}