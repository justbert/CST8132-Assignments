/*
 * FileName: Actor
 *CourseName: CST8132
 *LabSection: 301
 *StudentName: Justin Bertrand
 *DateCreated: Sept. 10/2014
 *DateModified: 
 */
public class Terrain {

	private boolean mountain; //Is True if a mountain is present, false if not.
	private Actor elf; //
	private Actor orc;
	
	/*
	 * 
	 */
	public Terrain() {
		this.mountain = false;
	}
	
	/*
	 * Returns the boolean value for mountain.
	 * True if a mountain is present, else false.
	 */
	public boolean mountainPresent() {
		return this.mountain;
	}
	
	/*
	 * Sets the mountain variable to true to 
	 * indicate that a mountain is present.
	 */
	public void makeMountain() {
		this.mountain = true;
	}
	
	/*
	 * Creates a new Actor object to represent
	 * an elf. Only used at game start.
	 */
	public void makeElf() {
		this.elf = new Actor();
	}
	
	/*
	 * Creates a new Actor object to represent 
	 * an orc. Only used at game start.
	 */
	public void makeOrc() {
		this.orc = new Actor();
	}
	
	/*
	 * Returns true if an elf is present, false
	 * if the reference is null.
	 */
	public boolean elfPresent() {
		if(this.elf != null) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * Returns true if an orc is present, false
	 * if the reference is null.
	 */
	public boolean orcPresent() {
		if(this.orc != null) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * Makes Actors battle if an Elf and an Orc 
	 * is present. Returns E if the Elf wins,
	 * O if the orc wins and N (None) for a stalemate
	 */
	public char battle() {
		if(this.elf != null && this.orc != null) {
			if(this.elf.getStrength() > this.orc.getStrength()) {
				this.orc = null;
				return 'E';
			} else if(this.orc.getStrength() > this.elf.getStrength()) {
				this.elf = null;
				return 'O';
			}
		}
		return 'N';
	}
	
	/*
	 * Moves the elf reference from this Terrain
	 * to the new one that is passed through the method.
	 */
	public void moveElf(Terrain newTerrain) {
		newTerrain.elf = this.elf;
		newTerrain.elf.move();
		this.elf = null;
	}
	
	/*
	 * Moves the orc reference from this Terrain
	 * to the new one that is passed through the method.
	 */
	public void moveOrc(Terrain newTerrain) {
		newTerrain.orc = this.orc;
		newTerrain.orc.move();
		this.orc = null;
	}
	
	/*
	 * Tracks if the Elf has moved during the 
	 * current round. Returns True if it has 
	 * moved, else false.
	 */
	public boolean hasElfMoved() {
		return this.elf.hasMoved();
	}
	
	/*
	 * Tracks if the orc has moved during the 
	 * current round. Returns True if it has 
	 * moved, else false.
	 */
	public boolean hasOrcMoved() {
		return this.orc.hasMoved();
	}
	
	public void resetMoves() {
		if(this.elf != null) {
			this.elf.resetMove();
		}
		if(this.orc != null) {
			this.orc.resetMove();
		}
	}
	
	/*
	 * Prints a representation of the current terrain
	 * to he console. Ex: [NEO]
	 */
	public void renderTerrain() {
		if(this.mountain == true) {
			System.out.print("[M");
		} else {
			System.out.print("[ ");
		}
		if(elf != null) {
			System.out.print("E");
		} else {
			System.out.print(" ");
		}
		if(orc != null) {
			System.out.print("O]");
		} else {
			System.out.print(" ]");
		}
	}
}
