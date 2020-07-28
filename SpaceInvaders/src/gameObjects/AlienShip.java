package gameObjects;

import game.Game;

public abstract class AlienShip extends EnemyShip {
	
	protected static boolean direction = false;
	private static boolean landed = false;
	private static boolean allDead = false;
	
	private static int goDownCycle = -1;
	private static int checkCycle = -1;
	
	// ______________________ Constructor ______________________    

	public AlienShip(Game game, int x, int y, int live, int points) {
		super(game, x, y, live, points);
		// TODO Auto-generated constructor stub
	}

	// ______________________   Methods   ______________________
	
	// --------------------- move & update ---------------------
	
	// update
	public void move() {
		if (goDownCycle == game.getCycle()) {
			goDown();
		}
		
		// move
		else if (game.getCycle() % game.getLevel().getNumCyclesToMoveOneCell() == 0) {
			
			if (checkCycle != game.getCycle()) {
				if (direction) 
					posY++;
				
				else 
					posY--;
			}
			
			else {
				if (direction) 
					posY--;
				
				else 
					posY++;
			}
		}
		if (checkCycle != game.getCycle())
			checkBorder();
	}
	
	public static boolean haveLanded() {
		return landed;
	}
	
	public static boolean allDead() {
		if(game.numEnemies() == 0) {
			allDead = true;
		}
		return allDead;
	}
	
	// descend
	private void checkBorder() {		
		if (direction) {
			if(Game.DIM_Y == posY) {
				direction = !direction;
				goDownCycle = game.getCycle() +1;
				checkCycle = game.getCycle();
			}
		}
		
		else 
			if (0 == posY) {
				direction = !direction;
				goDownCycle = game.getCycle() +1;
				checkCycle = game.getCycle();
			}
	}

	// go Down
	private void goDown() {
			posX++;
				
			// Check if reached bottom row 
			reachBottom();	
	}
	
	// --------------------- Reached end ---------------------

	// Get Reached bottom
	private void reachBottom() {
		if (posX == Game.DIM_X -2)
			landed = true;
	}
}

/*
 * package gameObjects;

import game.Game;

public abstract class AlienShip extends EnemyShip {
	
	private static int Shipcont = 0;
	protected static boolean direction = false;
	private static boolean goDown = false;
	private static boolean landed = false;
	private static boolean allDead = false;
	
	// ______________________ Constructor ______________________    

	public AlienShip(Game game, int x, int y, int live, int points) {
		super(game, x, y, live, points);
		// TODO Auto-generated constructor stub
	}

	// ______________________   Methods   ______________________
	
	// --------------------- move & update ---------------------
	
	// update
	public void move() {
		// Check descend
		checkBorder();
		
		if (goDown) {
			// go down
			goDown();
		}
		
		// move
		else if (game.getCycle() % game.getLevel().getNumCyclesToMoveOneCell() == 0) {
			if (direction) 
				posY++;
			
			else 
				posY--;	
		}
	}
	
	public static boolean haveLanded() {
		return landed;
	}
	
	public static boolean allDead() {
		if(game.numEnemies() == 0) {
			allDead = true;
		}
		return allDead;
	}
	
	// descend
	private void checkBorder() {		
		if (direction) {
			if(Game.DIM_Y == posY) {
				direction = !direction;
				goDown = true;
				Shipcont = 0;
			}
		}
		
		else 
			if (0 == posY) {
				direction = !direction;
				goDown = true;
				Shipcont = 0;
			}
	}

	// go Down
	private void goDown() {
		if (goDown) {
			if (Shipcont < game.numEnemies()) {
				posX++;
				Shipcont++;
				
				// Check if reached bottom row 
				reachBottom();
			}
			
			else {
				goDown = false;
			}
		}
	}
	
	// --------------------- Reached end ---------------------

	// Get Reached bottom
	private void reachBottom() {
		if (posX == Game.DIM_X -2)
			landed = true;
	}
}
*/
