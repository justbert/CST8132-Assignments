import java.util.Random;

public class RandomUtil {
	private static final Random random = new Random();

	private RandomUtil() {
	}

	public static int nextInt(int max) {
		return random.nextInt(max);
	}
}