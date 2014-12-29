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
public abstract class MathProblem {

	private int operand1;
	private int operand2;
	private int userAnswer;
	
	/*
	 * Constructor initializes both operands, giving them a random value
	 * between 1 and 100.
	 */
	public MathProblem() {
		this.operand1 = RandomUtil.nextInt(100) + 1;
		this.operand2 = RandomUtil.nextInt(100) + 1;
	}
	
	/*
	 * Returns the value of operand1.
	 */
	public int getOperand1() {
		return this.operand1;
	}
	
	/*
	 * Sets the operand to the passed value.
	 */
	public void setOperand1(int operand) {
		this.operand1 = operand;
	}
	
	/*
	 * Returns the value of operand1.
	 */
	public int getOperand2() {
		return this.operand2;
	}
	
	/*
	 * Sets the operand to the passed value.
	 */
	public void setOperand2(int operand) {
		this.operand2 = operand;
	}
	
	/*
	 * Abstract getter method for a problems answer.
	 */
	public abstract int getAnswer();
	
	/*
	 * Returns the value of userAnswer.
	 */
	public int getUserAnswer() {
		return this.userAnswer;
	}
	
	/*
	 * Sets the userAnswer to the passed value. 
	 */
	public void setUserAnswer(int userAnswer) {
		this.userAnswer = userAnswer;
	}
	
	/*
	 * Abstract method which returns something like
	 *  a + b = c
	 */
	public abstract String getQuestionText();
	
	/*
	 * Abstract method which returns the question as well
	 * as detailing if you got the correct answer.
	 */
	public abstract String getQuestionTextWithFeedback();
	
}
