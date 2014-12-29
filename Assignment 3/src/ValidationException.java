/*FileName: ValidationException
 * Assignment 3
 *Course Name: CST8132 - Object Oriented Programming
 *LabSection: 301
 *Student Name: Justin Bertrand
 *Date: Nov 10th, 2014
 *
 *Description: A class of an Exception which validates data.
 *
 *Based on UML documentation provided by Stan Pieda
 */
public class ValidationException extends Exception {
	
	public ValidationException() {
		super("Data not in valid format");
	}
	
	public ValidationException(String value) {
		super(value);
	}
	
	public ValidationException(String value, Throwable t) {
		super(value, t);
	}
	
	public ValidationException(Throwable t) {
		super(t);
	}
}
