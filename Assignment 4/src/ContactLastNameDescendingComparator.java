/*FileName: ContactLastNameDescendingComparator
 *Assignment 4
 *Course Name: CST8132 - Object Oriented Programming
 *LabSection: 301
 *Student Name: Justin Bertrand
 *Date: Nov 24th, 2014
 *
 *Description: A comparator used to sort Contact last names in descending order.
 *
 *Based on code provided by Stan Pieda for assignment 3 in the aforementioned course.
 */

import java.util.Comparator;

/*
 * Essentially the same comparator given with the assignment, but the returned values
 * sign is flipped to reverse the order of the sort.
 */

/**
 * A Singleton based Comparator which allows for the sorting of Contact objects by
 * last name in an descending order.
 * @author Justin Bertrand
 * @version 2.0
 * @since 1.8
 */
public class ContactLastNameDescendingComparator implements Comparator<Contact> {
	
	/**
	 * An instance of ContactLastNameDescendingComparator which is returned
	 * instead a new object being created.
	 */
	private static ContactLastNameDescendingComparator INSTANCE = null;
	
	/**
	 * An empty private default constructor to prevent the creation of
	 * instances other than the INSTANCE.
	 */
	private ContactLastNameDescendingComparator() {}
	
	/**
	 * Returns an instance of a ContactLastNameDescendingComparator.
	 * This method is used instead of a constructor.
	 * @return Returns the Static INSTANCE. 
	 */
	public static ContactLastNameDescendingComparator getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new ContactLastNameDescendingComparator();
		}
		return INSTANCE;
	}
	
	/**
	 * Compares two Contacts by last name using descending alphanumerical comparison returning a positive number
	 * if arg0 comes before arg1, 0 if the two are equal, and a negative number if arg0 goes after arg1.
	 * @param arg0 A Contact object that will be compared to sort
	 * @param arg1 A Contact object that will be compared to sort
	 * @return  Integer representing in which order arg0 comes relatively to arg1
	 */
	@Override
	public int compare(Contact arg0, Contact arg1) {
		return (arg0.getLastName().compareTo(arg1.getLastName())) * -1;
	}
}