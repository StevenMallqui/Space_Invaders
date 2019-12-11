package gameObjects;

import game.Game;
import game.IExecuteRandomActions;

public class DestroyerAlien extends AlienShip {

	// ______________________ Variables   ______________________  
	private boolean activeBomb = false;
	
	// ______________________ Constructor ______________________    

	public DestroyerAlien(Game game, int x, int y) {
		super(game, x, y, 1, 10);
	}

	// ______________________   Methods   ______________________

	public void computerAction() {
		if(IExecuteRandomActions.canGenerateRandomBomb(game) && activeBomb == false) {
			activeBomb = true;
			game.addObject(new Bomb(game,this.getPosX(),this.getPosY(),this));
			
		}
	}
	
	// Get skin
	public String toString() {
		return "D[" + lives + "]";
	}

	
	public void set(boolean active) { 
		activeBomb = active;
	}

	@Override
	public void onDelete() {
		game.receivePoints(points);
	}

	@Override
	public String toStringified() {
		String dir = "left";
		if (direction)
			dir = "right";
		return "D;" + posX + "," + posY + ";" + lives + ";" + (3 - game.getCycle()%3) + ";" + dir + "\n";
	}
}
