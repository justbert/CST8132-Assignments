/*FileName: ContactFirstNameComparator
 * Assignment 3
 *Course Name: CST8132 - Object Oriented Programming
 *LabSection: 301
 *Student Name: Justin Bertrand
 *Date: Nov 10th, 2014
 *
 *Description: A comparator used to sort Contact first names in ascending order.
 *
 *Code provided by Stan Pieda as part of Assignment 3 in the aforementioned course.
 */

import java.util.Comparator;

public class ContactFirstNameComparator implements Comparator<Contact> {
	@Override
	public int compare(Contact arg0, Contact arg1) {
		return arg0.getFirstName().compareTo(arg1.getFirstName());
	}
}