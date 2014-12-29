/*FileName: ContactFirstNameDescendingComparator
 * Assignment 3
 *Course Name: CST8132 - Object Oriented Programming
 *LabSection: 301
 *Student Name: Justin Bertrand
 *Date: Nov 10th, 2014
 *
 *Description: A comparator used to sort Contacts by last name in a descending order.
 *
 *Based on code provided by Stan Pieda as part of Assignment 3 in the aforementioned class.
 */

import java.util.Comparator;

/*
 * Essentially the same comparator given with the assignment, but the returned values
 * sign is flipped to reverse the order of the sort.
 */
public class ContactFirstNameDescendingComparator implements Comparator<Contact> {
	@Override
	public int compare(Contact arg0, Contact arg1) {
		return (arg0.getFirstName().compareTo(arg1.getFirstName())) * -1;
	}
}