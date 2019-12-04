package gameObjects;

import game.Game;
import game.IExecuteRandomActions;

public class RegularAlien extends AlienShip {

	// ______________________ Variables   ______________________  

	boolean selfDestruct = false;
	
	// ______________________ Constructor ______________________    

	public RegularAlien(Game game, int x, int y) {
		super(game, x, y, 2, 5);
		// TODO Auto-generated constructor stub
	}

	// ______________________   Methods   ______________________

	// on delete
	public void onDelete() {
		game.receivePoints(points);
		
		if (selfDestruct)
			game.damageNearbyObjects(posX, posY);
	}

	// Get skin
	public String toString() {
		if (!selfDestruct)
		return "R[" + lives + "]";
		else
			return "E[" + lives + "]";
	}

	// computer action
	public void computerAction() {
		if(IExecuteRandomActions.canGenerateRandomExplosion(game)){
			selfDestruct = true;
		}
	}
}