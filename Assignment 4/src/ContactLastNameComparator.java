/*FileName: ContactLastNameComparator
 *Assignment 4
 *Course Name: CST8132 - Object Oriented Programming
 *LabSection: 301
 *Student Name: Justin Bertrand
 *Date: Nov 24th, 2014
 *
 *Description: A comparator used to sort Contact last names in ascending order.
 *
 *Code provided by Stan Pieda as part of assignment 3 in the aforementioned class.
 */
import java.util.Comparator;

/**
 * A Singleton based Comparator which allows for the sorting of Contact objects by
 * last name in an ascending order.
 * @author Justin Bertrand
 * @version 2.0
 * @since 1.8
 */
public final class ContactLastNameComparator implements Comparator<Contact> {
	
	/**
	 * An instance of ContactLastNameComparator which is returned
	 * instead a new object being created.
	 */
	private static ContactLastNameComparator INSTANCE = null;
	
	/**
	 * An empty private default constructor to prevent the creation of
	 * instances other than the INSTANCE.
	 */
	private ContactLastNameComparator() {}
	
	/**
	 * Returns an instance of a ContactLastNameComparator.
	 * @return Returns the Static INSTANCE. This method is used instead
	 * of a constructor.
	 */
	public static ContactLastNameComparator getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new ContactLastNameComparator();
		}
		return INSTANCE;
	}
	
	/**
	 * Compares two Contacts by last name using ascending alphanumerical comparison returning a negative number
	 * if arg0 comes before arg1, 0 if the two are equal, and a positive number if arg0 goes after arg1.
	 * @param arg0 A Contact object that will be compared to sort
	 * @param arg1 A Contact object that will be compared to sort
	 * @return  Integer representing in which order arg0 comes relatively to arg1
	 */
	@Override
	public int compare(Contact arg0, Contact arg1) {
		return arg0.getLastName().compareTo(arg1.getLastName());
	}
}