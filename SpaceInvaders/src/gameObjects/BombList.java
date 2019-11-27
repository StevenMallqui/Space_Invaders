package gameObjects;

import java.util.Random; 
import game.Level;
import game.Game;

public class BombList {
	
	// ______________________  Variables  ______________________
	
	private Level level;
	private Bomb []bomb;
	private Game game;
	private String skin = ".";

	// ______________________ Constructor ______________________
	
	public BombList(Game game, Level level){
		this.level = level;
		this.game = game;
		
		bomb = new Bomb[level.getNumDestroyerAliens()];
		
		for(int i = 0; i < bomb.length; i++) {
			bomb[i] = new Bomb(game, -1, -1);
		}
	}

	
	// ______________________   Methods   ______________________
	
	// ----------------------   Get Info  ----------------------
	
	// Get Skin
	public String toString() {
		return skin;
	}
	
	// Get Number of Bombs
	public int getNumActiveBombs() {
		int num = 0;
		
		for (int i = 0; i < bomb.length; i++)
			if (bomb[i].isAlive())
				num++;
			
		return num;
	}

	// Get Active in Location
	public boolean location(int x, int y) {
		boolean found = false;
		
		for (int i = 0; i < bomb.length && !found; i++)
			if ((bomb[i].isAlive()) && (bomb[i].getPosX() == x && bomb[i].getPosY() == y)) 
				found = true;
			
		return found;
	}
	
	// ----------------------  Operations ----------------------
	
	// Spawn Bombs
	public void spawn(int x, int y, Random rand) {
		boolean continueSearch = true;
		for (int i = 0; i < bomb.length && continueSearch; i++)
			if (!bomb[i].isAlive()) {
				continueSearch = false;
				float frec = rand.nextFloat();
				
				if (frec < level.getShootFrequency()) 
					bomb[i] = new Bomb(game, x, y);
			}
	}
	
	
	// Advance Bombs
	public void goDown(int worldBorder) {
		for (int i = 0; i < bomb.length; i++) 
			if (bomb[i].isAlive()) {
				bomb[i].move();
			
				if(bomb[i].getPosX() >= worldBorder) 
					bomb[i].deactivate();
			}	
	}
	
	// search if impacted
	public boolean impact(int x, int y) {
		boolean impacted = false;
		
		for(int i = 0; i < bomb.length && !impacted; i++)
			if( bomb[i].isAlive() && bomb[i].getPosX() == x && bomb[i].getPosY() == y) {
				bomb[i].deactivate();
				impacted = true;
			}
		return impacted;
	}

	
}
	
	
	

