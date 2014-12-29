/*FileName: ContactLastNameComparator
 *Assignment 3
 *Course Name: CST8132 - Object Oriented Programming
 *LabSection: 301
 *Student Name: Justin Bertrand
 *Date: Nov 10th, 2014
 *
 *Description: A comparator used to sort Contact last names in ascending order.
 *
 *Code provided by Stan Pieda as part of assignment 3 in the aforementioned class.
 */
import java.util.Comparator;

public class ContactLastNameComparator implements Comparator<Contact> {
	@Override
	public int compare(Contact arg0, Contact arg1) {
		return arg0.getLastName().compareTo(arg1.getLastName());
	}
}