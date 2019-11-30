package gameObjects;

import game.*;

public class Ovni extends EnemyShip implements IExecuteRandomActions{
	
	//______________________Variables______________________  
	
	//______________________Constructor______________________    
	
	public Ovni(Game game, int x, int y, int live) {
		super(game, x, y, 1);
	}
	
	//______________________Methods______________________
	
	@Override
	public void computerAction() {
		IExecuteRandomActions.canGenerateRandomOvni(game);
	}
	
	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public String toString() {
		return "O[" + lives + "]";
	}
	
	
	
}
