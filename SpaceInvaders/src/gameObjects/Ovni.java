package gameObjects;

import game.*;

public class Ovni extends EnemyShip implements IExecuteRandomActions{
	
	//______________________Variables______________________  
	
	private UCMShip ucm;
		
	//______________________Constructor______________________    
	
	public Ovni(Game game, int x, int y, int live) {
		super(game, x, y, live, 25);
	}
	
	//______________________Methods______________________
	
	@Override
	public void computerAction() {
		if(IExecuteRandomActions.canGenerateRandomOvni(game)){
			move();
		}
	}
	
	@Override
	public void onDelete() {
		ucm.enableShockWave();
		game.setPoints(this.points);
	}
	
	@Override
	public String toString() {
		return "O[" + lives + "]";
	}
	
	public void move() {
		if(this.posY > 0) {
			this.posY--;	
		}
		else {
			this.posY = 9;
		}
	}
		
}