/*FileName: MultiplicationMathProblem
 *Course Name: CST8132 - Object Oriented Programming
 *LabSection: 301
 *Student Name: Justin Bertrand
 *Date: Oct. 20th, 2014
 *
 *Description: A class representing a multiplication problem.
 *
 *Based on UML documentation provided by Stan Pieda
 */

public class MultiplicationMathProblem extends MathProblem {

	/*
	 * Constructor which invokes the superclass' constructor.
	 */
	public MultiplicationMathProblem() {
		super();
	}
	
	/*
	 * (non-Javadoc)
	 * @see MathProblem#getAnswer()
	 * 
	 * Returns the answer to the multiplication.
	 */
	public int getAnswer() {
		return super.getOperand1() * super.getOperand2();
	}
	
	/*
	 * (non-Javadoc)
	 * @see MathProblem#getQuestionText()
	 * 
	 * Returns a String with the details of the multiplication.
	 */
	public String getQuestionText() {
		StringBuilder builder = new StringBuilder();
		
		builder.append(super.getOperand1()).append(" x ").append(super.getOperand2()).append(" = ");
		return builder.toString();
	}
	
	/*
	 * (non-Javadoc)
	 * @see MathProblem#getQuestionTextWithFeedback()
	 * 
	 * Returns a String with the details of the multiplication as well as
	 * information relating to the corectness of the users answer.
	 */
	public String getQuestionTextWithFeedback() {
		StringBuilder builder = new StringBuilder();
		
		builder.append(this.getQuestionText()).append(this.getAnswer()).append("\nYour answer: ").append(super.getUserAnswer());
		
		if(this.getAnswer() == super.getUserAnswer()) {
			builder.append(" is correct.");
		} else {
			builder.append(" is not correct.");
		}
		
		return builder.toString();
	}
	
}
