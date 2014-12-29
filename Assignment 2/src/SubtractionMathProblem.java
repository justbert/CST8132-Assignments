/*FileName: MathProblem
 *Course Name: CST8132 - Object Oriented Programming
 *LabSection: 301
 *Student Name: Justin Bertrand
 *Date: Oct. 20th, 2014
 *
 *Description: An abstract class outlining a math problem and its various
 *				fields and methods.
 *
 *Based on UML documentation provided by Stan Pieda
 */

public class SubtractionMathProblem extends MathProblem {

	/*
	 * Constructor which reference the superclass' constructor.
	 */
	public SubtractionMathProblem() {
		super();
	}
	
	/*
	 * (non-Javadoc)
	 * @see MathProblem#getAnswer()
	 * 
	 * Returns the result of the substraction.
	 */
	public int getAnswer() {
		return super.getOperand1() - super.getOperand2();
	}
	
	/*
	 * (non-Javadoc)
	 * @see MathProblem#getQuestionText()
	 * 
	 * Returns a String of the division problem.
	 */
	public String getQuestionText() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.getOperand1()).append(" - ").append(super.getOperand2()).append(" = ");
		return builder.toString();
	}
	
	/*
	 * (non-Javadoc)
	 * @see MathProblem#getQuestionTextWithFeedback()
	 * 
	 * Returns a String of the division problem along with information
	 * about the correctness of the users answer.
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
