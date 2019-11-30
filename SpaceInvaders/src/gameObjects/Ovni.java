package gameObjects;

import game.Game;

public class Ovni extends EnemyShip {
	
	//______________________Variables______________________  
	
	//______________________Constructor______________________    
	
	public Ovni(Game game, int x, int y, int live) {
		super(game, x, y, 1);
		// TODO Auto-generated constructor stub
	}
	
	//______________________Methods______________________
	
	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
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
