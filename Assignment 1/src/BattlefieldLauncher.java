import java.util.Scanner;

public class BattlefieldLauncher {
	public static void main(String[] args) {
		Battlefield battlefield = new Battlefield();
		Scanner input = new Scanner(System.in);
		int option = -1;
		int sanity = 0; // game could go on forever
		
		System.out.println("Initial battlefield");
		battlefield.renderBattlefield();
		
		while (option != 0 && sanity < 100) {
			System.out.println("\nMoving Actors");
			battlefield.moveActors();
			System.out.println();
			battlefield.renderBattlefield();
			System.out.println("\nProcessing Fights");
			battlefield.processFights();
			battlefield.renderBattlefield();
			System.out.println();
			if (battlefield.getElfCount() == 0) {
				System.out.println("Orcs win");
				break;
			}
			if (battlefield.getOrcCount() == 0) {
				System.out.println("Elves win");
				break;
			}
			System.out.printf("Round %d	of 100 completed\n", sanity++ + 1);
			System.out.println("Enter anything to play next turn");
			System.out.println("Enter to quit");
			option = input.nextInt();
		}
		if (sanity >= 100) {
			System.out.println("Battle	was	ended after	100	rounds");
			System.out.println("Final Game State: ");
			battlefield.renderBattlefield();
		}
		System.out.println("Thanks for playing");
		input.close();
	}
}