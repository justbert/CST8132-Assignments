/*FileName: RandomUtil
 *Course Name: CST8132 - Object Oriented Programming
 *LabSection: 301
 *Student Name: Justin Bertrand
 *Date: Sept 20th, 2014
 *
 *Creator: Stanley Pieda (2014) personal communication
 *Description: This class was given as part of Assignment 1 and 2 in the above course
 *and was written by Stan Pieda.
 */
import java.util.Random;

public class RandomUtil {
	private static final Random random = new Random();

	private RandomUtil() {
	}

	public static int nextInt(int max) {
		return random.nextInt(max);
	}
}