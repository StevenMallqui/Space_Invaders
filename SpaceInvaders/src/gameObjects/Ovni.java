package gameObjects;

import game.*;

public class Ovni extends EnemyShip implements IExecuteRandomActions{
	
	
	//______________________Variables______________________  
	
	private boolean Alive;
		
	//______________________Constructor______________________    
	
	public Ovni(Game game) {
		super(game, 0, 9, 1, 25);
	}
	
	//______________________Methods______________________
	
	// computer Action
	public void computerAction() {
		if(IExecuteRandomActions.canGenerateRandomOvni(game) && Alive == false){
			Alive = true;
			lives = 1;
		}
	}
	
	// on delete
	public void onDelete() { /* Empty, never dies */}
	
	// skin
	public String toString() {
		return "O[" + lives + "]";
	}
	
	// move
	public void move() {
		if(this.posY > -1 && Alive == true) {
			this.posY --;	
		}
		
		else {
			Alive = false; 
			posY = 9;
		}
	}

	// serialize
	public String toStringified() {
		return "O;" + posX + "," + posY + ";" + lives + "\n";
	}
	
	// damage object rewrite
	public void damageObject (int damage) {		
		if (lives - damage == 0) {
			game.receivePoints(points);
			Alive = false;
			posY = 9;
		}
	}

}