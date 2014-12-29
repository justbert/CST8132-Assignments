/*FileName: ContactManagerLauncher
 *Assignment 4
 *Course Name: CST8132 - Object Oriented Programming
 *LabSection: 301
 *Student Name: Justin Bertrand
 *Date: Nov 24th, 2014
 *
 *Description: A launcher for ContactManager.
 *
 *Code provided by Stan Pieda for Assignment 3 in the aforementioned class.
 */
	
/**
 * This class allows the creation, removal, sorting, printing, loading, 
 * and saving of contacts into a file.
 * @author Stan Pieda
 * @version 1.0
 * @since 1.8
 */

public class ContactManagerLauncher {

	public static void main(String[] args) {
		ContactManager manager = new ContactManager();
		manager.runContactManager();
	}

}
