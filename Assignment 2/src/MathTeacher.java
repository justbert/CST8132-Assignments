/*FileName: MathProblem
 *Course Name: CST8132 - Object Oriented Programming
 *LabSection: 301
 *Student Name: Justin Bertrand
 *Date: Oct. 20th, 2014
 *
 *Description: A class which allows for testing math problems and 
 *				providing a detailed report of results.
 *
 *Based on UML documentation provided by Stan Pieda
 */

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MathTeacher {
	
	private static final int PRACTICE = 1;
	private static final int REPORT = 2;
	private static final int EXIT = 0;
	private static final int MAX_SIZE = 10;
	private MathProblem[] problems;
	
	/*
	 * Creates a menu for the user to interact with. Has
	 * 3 options: Practice, Report and Exit.
	 */
	public void runMenu() {
		Scanner input = new Scanner(System.in);
		int choice = -1;
		while(choice != EXIT) {
			System.out.print("Please make a selection from the menu:\n1 Practice Test\n2 Print Report\n0 Exit Program\nChoice: ");
			try {
				choice = input.nextInt();
				System.out.println();
				switch(choice) {
				case PRACTICE:
					this.practiceMath();
					break;
				case REPORT:
					this.printReport();
					break;
				case EXIT:
					System.out.println("Exiting: Have a good day.");
					input.close();
					break;
				default:
					System.out.println("Error: Not a valid menu option.");					
				}
			} catch (InputMismatchException ex) {
				System.out.println("\nError: Please enter an integer.\n");
				input.nextLine();
			}
		}
	}
	
	/*
	 * Method which allows the user to practice the mathproblems in 
	 * the problems array, one after another.
	 */
	private void practiceMath() {
		this.initializeProblems();
		Scanner input = new Scanner(System.in);
		for(int index = 0; index < problems.length; ++index) {
			System.out.print(problems[index].getQuestionText());
			try {
				problems[index].setUserAnswer(input.nextInt());
			} catch (InputMismatchException ex) {
				System.out.println();
				input.nextLine();
				--index;
			}
		}
		System.out.println();
	}
	
	/*
	 * Method prints a report for the user detailing the answers to the problems
	 * as well as an overview of correct answers.
	 */
	private void printReport() {
		int correct = 0;
		DecimalFormat formatter = new DecimalFormat();
		formatter.applyPattern("###.00%");
		if(problems == null) {
			System.out.println("No test taken\n");
		} else {
			System.out.println("Report:");
			for(int index = 0; index < this.problems.length; ++index) {
				System.out.println(this.problems[index].getQuestionTextWithFeedback());
				if(this.problems[index].getAnswer() == this.problems[index].getUserAnswer()) {
					correct++;
				}
			}
			System.out.println("\nCorrect answers: " + correct);
			System.out.println("Wrong answers: " + (this.problems.length - correct));
			System.out.println("Percent correct: " + formatter.format((float) correct / (float) MAX_SIZE));
			System.out.println();
		}
	}
	
	/*
	 * Method initializes the problems array and input a random type of
	 * into each index. 
	 */
	private void initializeProblems() {
		this.problems = new MathProblem[MAX_SIZE];
		
		for(int index = 0; index < MAX_SIZE; ++index) {
			//0: Addition, 1: Subtraction, 2: Multiplication, 3: Division
			switch(RandomUtil.nextInt(3)) {
			case 0: 
				problems[index] = new AdditionMathProblem();
				break;
			case 1:
				problems[index] = new SubtractionMathProblem();
				break;
			case 2:
				problems[index] = new MultiplicationMathProblem();
				break;
			//case 3:
				//problems[index] = new DivisionMathProblem();
				//break;
			}
		}
	}
}
