package gameObjects;

import game.Game;
import game.IExecuteRandomActions;

public class RegularAlien extends AlienShip {

	// ______________________ Variables   ______________________  
	
	// ______________________ Constructor ______________________    

	public RegularAlien(Game game, int x, int y) {
		super(game, x, y, 2, 5);
	}

	// ______________________   Methods   ______________________

	// on delete
	public void onDelete() {
		game.receivePoints(points);
	}

	// Get skin
	public String toString() {
		return "R[" + lives + "]";
	}

	// computer action
	public void computerAction() {
		if(IExecuteRandomActions.canGenerateRandomExplosion(game)){
			game.regularToExplosive(posX, posY, lives);
			points = 0;
			lives = 0;
		}
	}

	@Override
	public String toStringified() {
		String dir = "left";
		if (direction)
			dir = "right";
		
		return "R;" + posX + "," + posY + ";" + lives + ";" + (3 - game.getCycle()%3) + ";" + dir + "\n";
	}
}