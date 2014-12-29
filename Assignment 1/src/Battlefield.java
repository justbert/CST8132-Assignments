/*FileName: Battlefield
 *CourseName: CST8132
 *LabSection: 301
 *StudentName: Justin Bertrand
 *DateCreated: Sept. 10/2014
 *DateModified: 
 */
public class Battlefield {
	private Terrain[][] battlefield;
	private static final int HEIGHT = 5;//Height of the battlefield
	private static final int WIDTH = 5; //Width of the battlefield
	private int orcCount; //The number of Orcs left in the game
	private int elfCount; //The number of Elves left in the game
	private int mountainCount; //The number of mountains to be inserted in the game.

	Battlefield() {
		this.battlefield = new Terrain[WIDTH][HEIGHT];

		this.orcCount = 10;
		this.elfCount = 10;
		this.mountainCount = 5;

		// loop initiating every entry in battlefield
		for (int row = 0; row < 5; row++) {
			for (int column = 0; column < 5; column++) {
				battlefield[row][column] = new Terrain();
			}
		}

		int row;
		int column;

		// loop creating mountains in random terrain
		for (int mountains = 0; mountains < mountainCount; mountains++) {
			row = RandomUtil.nextInt(5);
			column = RandomUtil.nextInt(5);
			if (battlefield[row][column].mountainPresent()) {
				mountains--;
			} else {
				battlefield[row][column].makeMountain();
			}
		}

		// loop populating elves in random terrain
		for (int elves = 0; elves < elfCount; elves++) {
			row = RandomUtil.nextInt(5);
			column = RandomUtil.nextInt(5);
			if (battlefield[row][column].elfPresent()) {
				elves--;
			} else {
				battlefield[row][column].makeElf();
			}
		}

		// loop to populate 10 orcs in random terrain
		for (int orcs = 0; orcs < orcCount; orcs++) {
			row = RandomUtil.nextInt(5);
			column = RandomUtil.nextInt(5);
			if (battlefield[row][column].orcPresent()) {
				orcs--;
			} else {
				battlefield[row][column].makeOrc();
			}
		}
	}

	/*
	 * If an orc and an elf are present on the same Terrain,
	 * a fight ensues. The strongest Actor is the winner and 
	 * the loser is eliminated.
	 */
	public void processFights() {
		for (int row = 0; row < 5; row++) {
			for (int column = 0; column < 5; column++) {
				if(battlefield[row][column].elfPresent() && battlefield[row][column].orcPresent()) {
					switch(battlefield[row][column].battle()) {
					case 'O': //Orc wins, elf dies. Elf counter gets subtracted by 1.
						elfCount--;
						System.out.println("Battle at [" + (row+1) + "]["+ (column+1) + "]" + ": Orc wins!");
						break;
					case 'E': //Elf wins, orc dies. Orc counter gets subtracted by 1.
						orcCount--;
						System.out.println("Battle at [" + (row+1) + "]["+ (column+1) + "]" + ": Elf wins!");
						break;
					case 'N':
						System.out.println("Battle at [" + (row+1) + "]["+ (column+1) + "]" + ": Stalemate!");
						break;
					}
				}
			}
		}
		System.out.println("Elves left: " + this.elfCount + "\nOrcs left: " + this.orcCount + "\n");
	}

	/*
	 * Moves 
	 */
	public void moveActors() {
		for (int row = 0; row < 5; row++) {
			for (int column = 0; column < 5; column++) {
				
				/*
				 * Makes the elf move in a random cardinal direction
				 * if one is present on this terrain
				 */
				if (battlefield[row][column].elfPresent() && !battlefield[row][column].hasElfMoved()) {
					switch (RandomUtil.nextInt(4)) {
					// 0 = north, 1 = east, 2 = south, 3 = west
					case 0:
						if (row - 1 >= 0 && !battlefield[row - 1][column].mountainPresent() && !battlefield[row-1][column].elfPresent()) {
							battlefield[row][column].moveElf(battlefield[row-1][column]);
							System.out.println("Elf at [" + (row+1) + "]["+ (column+1) + "]" + " moves North");
						}
						break;
					case 1:
						if (column + 1 < 5 && !battlefield[row][column+1].mountainPresent() && !battlefield[row][column+1].elfPresent()) {
							battlefield[row][column].moveElf(battlefield[row][column+1]);
							System.out.println("Elf at [" + (row+1) + "]["+ (column+1) + "]" + " moves East");
						}
						break;
					case 2:
						if (row + 1 < 5 && !battlefield[row+1][column].mountainPresent() && !battlefield[row+1][column].elfPresent()) {
							battlefield[row][column].moveElf(battlefield[row+1][column]);
							System.out.println("Elf at [" + (row+1) + "]["+ (column+1) + "]" + " moves South");
						}
						break;
					case 3:
						if (column - 1 >= 0 && !battlefield[row][column-1].mountainPresent() && !battlefield[row][column-1].elfPresent()) {
							battlefield[row][column].moveElf(battlefield[row][column-1]);
							System.out.println("Elf at [" + (row+1) + "]["+ (column+1) + "]" + " moves West");
						}
						break;
					}
				}
				
				/*
				 * Makes the orc move in a random cardinal direction
				 * if one is present on this terrain
				 */
				if (battlefield[row][column].orcPresent() && !battlefield[row][column].hasOrcMoved()) {
					switch (RandomUtil.nextInt(4)) {
					// 0 = north, 1 = east, 2 = south, 3 = west
					case 0:
						if (row - 1 >= 0 && !battlefield[row - 1][column].mountainPresent() && !battlefield[row-1][column].orcPresent()) {
							battlefield[row][column].moveOrc(battlefield[row-1][column]);
							System.out.println("Orc at [" + (row+1) + "]["+ (column+1) + "]" + " moves North");
						}
						break;
					case 1:
						if (column + 1 < 5 && !battlefield[row][column+1].mountainPresent() && !battlefield[row][column+1].orcPresent()) {
							battlefield[row][column].moveOrc(battlefield[row][column+1]);
							System.out.println("Orc at [" + (row+1) + "]["+ (column+1) + "]" + " moves East");
						}
						break;
					case 2:
						if (row + 1 < 5 && !battlefield[row+1][column].mountainPresent() && !battlefield[row+1][column].orcPresent()) {
							battlefield[row][column].moveOrc(battlefield[row+1][column]);
							System.out.println("Orc at [" + (row+1) + "]["+ (column+1) + "]" + " moves South");
						}
						break;
					case 3:
						if (column - 1 >= 0 && !battlefield[row][column-1].mountainPresent() && !battlefield[row][column-1].orcPresent()) {
							battlefield[row][column].moveOrc(battlefield[row][column-1]);
							System.out.println("Orc at [" + (row+1) + "]["+ (column+1) + "]" + " moves West");
						}
						break;
					}
				}
			}
		}
		/*
		 * Resets the tokens keeping track of moved units.
		 */
		for(int row = 0; row < 5; row++) {
			for(int column = 0; column < 5; column++) {
				battlefield[row][column].resetMoves();
			}
		}
	}
	
	/*
	 * Returns of the number of Orcs remaining in play.
	 */
	public int getOrcCount() {
		return orcCount;
	}
	
	/*
	 * Returns the number of Elves remaining in play.
	 */
	public int getElfCount() {
		return elfCount;
	}

	// Prints the map of the battlefield to the console
	public void renderBattlefield() {
		for (int row = 0; row < 5; row++) {
			for (int column = 0; column < 5; column++) {
				battlefield[row][column].renderTerrain();
			}
			System.out.println();
		}

	}

}
