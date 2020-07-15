package gameObjects;

import game.Game;

public class ExplosiveAlien extends AlienShip {
	
	// ______________________ Constructor ______________________    

	public ExplosiveAlien(Game game, int x, int y, int lives) {
		super(game, x, y, lives, 5);
	}

	// ______________________   Methods   ______________________

	// on delete
	public void onDelete() {
		game.receivePoints(points);
		game.decreaseAlien();
		game.explode(posX, posY);
	}

	// Get skin
	public String toString() {
		return "E[" + lives + "]";
	}

	// computer action
	public void computerAction() {
		
	}

	// to serial
	public String toStringified() {
		String dir = "left";
		if (direction)
			dir = "right";
		
		return "E;" + posX + "," + posY + ";" + lives + ";" + (3 - game.getCycle()%3) + ";" + dir + "\n";
	}
}