package gameObjects;

import game.*;

public class Ovni extends EnemyShip implements IExecuteRandomActions{
	
	
	//______________________Variables______________________  
	
	private boolean enableOvni;
		
	//______________________Constructor______________________    
	
	public Ovni(Game game) {
		super(game, 0, 9, 1, 25);
		enableOvni = false;
	}
	
	//______________________Methods______________________
	
	@Override
	public void computerAction() {
		if(IExecuteRandomActions.canGenerateRandomOvni(game) && enableOvni == false){
			enableOvni = true;
			move();
		}
	}
	
	@Override
	public void onDelete() {
		game.enableShockWave();
		game.receivePoints(this.points);
		game.resetOvni();
	}
	
	@Override
	public String toString() {
		return "O[" + lives + "]";
	}
	
	@Override
	public void move() {
		if(this.posY > -1 && this.enableOvni == true) {
			this.posY --;	
		}
		
		else {
			this.enableOvni = false; 
			this.posY = 10;
		}
	}

	@Override
	public String toStringified() {
		return "O;" + posX + "," + posY + ";" + lives + "\n";
	}
		
}