/*FileName: Actor
 *CourseName: CST8132
 *LabSection: 301
 *StudentName: Justin Bertrand
 *DateCreated: Sept. 10/2014
 *DateModified: 
 */
public class Actor {

	private final int strength; //Number representing the strength of the unit from 1 to 9.
	private boolean moved; //Token keeping track when if the target has moved.

	Actor() {
		this.strength = RandomUtil.nextInt(10);
		this.moved = false;
	}
	
	//Returns the number representing the strength of the unit.
	public int getStrength() {
		return this.strength;
	}
	
	//Returns a boolean indicating if the unit has moved.
	public boolean hasMoved() {
		return this.moved;
	}
	
	//Changes the boolean value to indicate that the unit has moved.
	public void move() {
		this.moved = true;
	}
	
	//Resets the move token to default value.
	public void resetMove() {
		this.moved = false;
	}
	
}
