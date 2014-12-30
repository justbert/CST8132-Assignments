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

/**
 * An exception thrown when data is not in a specified format.
 * @author Justin Bertrand
 * @version 1.0
 * @since 1.8
 */
public class ValidationException extends Exception {
	
	/**
	 * A default constructor which sends a default message to its 
	 * superclass' constructor.
	 */
	public ValidationException() {
		super("Data not in valid format");
	}
	
	/**
	 * A constructor taking in a custom message and sends it to its
	 * superclass' constructor.
	 * @param value A custom error message.
	 */
	public ValidationException(String value) {
		super(value);
	}
	
	/**
	 * A constructor accepting a custom error message and throwable object which are
	 * sent to its superclass' constructor.
	 * @param value A custom error message.
	 * @param t A throwable exception.
	 */
	public ValidationException(String value, Throwable t) {
		super(value, t);
		
	}
	/**
	 * A constructor accepting a throwable object which is
	 * sent to its superclass' constructor.
	 * @param t A throwable exception.
	 */
	public ValidationException(Throwable t) {
		super(t);
	}
}
