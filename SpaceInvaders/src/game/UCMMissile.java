package game;


public class UCMMissile extends Weapons {
	
	// ______________________ Constructor ______________________    

	public UCMMissile(Game game, int x, int y) {
		super(game, x, y, 1);
	}

	// ______________________   Methods   ______________________

	// Computer Action -----------------------------------------
	public void computerAction() {
		// Not USed
	}

	// On delete -----------------------------------------------
	public void onDelete() {
		// No clue
		
	}

	// move
	public void move() {
		posY--;
	}

	// skin
	public String toString() {
		return "oo";
	}

	
}
