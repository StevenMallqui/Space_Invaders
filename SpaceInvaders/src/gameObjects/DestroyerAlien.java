package gameObjects;

import game.Game;
import game.IExecuteRandomActions;

public class DestroyerAlien extends AlienShip {

	// ______________________ Variables   ______________________  
	private boolean activeBomb;
	int points = 10;
	
	// ______________________ Constructor ______________________    

	public DestroyerAlien(Game game, int x, int y) {
		super(game, x, y, 1, 10);
		activeBomb = false;
	}

	// ______________________   Methods   ______________________

	public void computerAction() {
		if(IExecuteRandomActions.canGenerateRandomBomb(game) && activeBomb == false) {
			activeBomb = true;
			game.addObject(new Bomb(game,this.getPosX(),this.getPosY()));
			
		}
	}
	
	// Get skin
	public String toString() {
		return "D[" + lives + "]";
	}

	public void set(boolean activeBomb) { 
	}
}
