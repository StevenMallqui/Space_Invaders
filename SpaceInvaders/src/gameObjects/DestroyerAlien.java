package gameObjects;

import game.Game;
import game.IExecuteRandomActions;

public class DestroyerAlien extends AlienShip {

	// ______________________ Variables   ______________________  
	private boolean activeBomb;
	
	// ______________________ Constructor ______________________    

	public DestroyerAlien(Game game, int x, int y) {
		super(game, x, y, 1, 10);
	}

	// ______________________   Methods   ______________________

	public void computerAction() {
		if(IExecuteRandomActions.canGenerateRandomBomb(game)) {
			game.addObject(new Bomb(game,this.getPosY(),this.getPosX()));
		}
	}
	
	// Get skin
	public String toString() {
		return "D[" + lives + "]";
	}


}
