/*FileName: ContactLastNameDescendingComparator
 *Assignment 3
 *Course Name: CST8132 - Object Oriented Programming
 *LabSection: 301
 *Student Name: Justin Bertrand
 *Date: Nov 10th, 2014
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
public class ContactLastNameDescendingComparator implements Comparator<Contact> {
	@Override
	public int compare(Contact arg0, Contact arg1) {
		return (arg0.getLastName().compareTo(arg1.getLastName())) * -1;
	}
}