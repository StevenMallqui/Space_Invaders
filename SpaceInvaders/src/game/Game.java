package game;

import java.util.Random;

public class Game {
		
	// ______________________ Variables   ______________________  
	
	// World Borders :
	private final int NUMFIL = 8;
	private final int NUMCOL = 9 ;
	private final int MinColRow = 0;
	
	// Objects
	private UCMShip ucm;
	private RegularShipList regularList;
	private DestroyerShipList destroyerList;
	private UCMMisil missile;
	private Level level;
	private Ovni ufo;
	private Random rand;
	
	// Variables
	private int cycle = 0;
	private int points = 0;
	private boolean direction = false;
	private boolean shockwave = false;
	private int shockDamage = 1;

	// End
	private boolean end = false;
	private boolean reset = false;

	// ______________________ Constructor ______________________    

	public Game(String level,Random rand) {
		this.rand = rand;
		if(level.equals("EASY")) 
			this.level = Level.EASY;
		
		else if(level.equals("HARD")) 
			this.level = Level.HARD;
		
		else 
			this.level = Level.INSANE;
		
		ucm = new UCMShip();
		regularList = new RegularShipList(this.level);
		destroyerList = new DestroyerShipList(this.level);
		ufo = new Ovni();
		missile = new UCMMisil();
		
	}

	// ______________________   Methods   ______________________

	// -------------------   Screen Printer  -------------------

	//COLLISIONS && PRINTING 
	public String toString(int x,int y) {
		String ship = "";
		
		//UCMSHIP POSITION
		if(ucm.location(x,y)) 
			ship = ucm.toString();
		
		// DESTROYERS POSITION
		else if(destroyerList.location(x, y)) 
			ship = destroyerList.toString(x, y);
		
		//REGULARS POSITION
		else if(regularList.location(x, y))
			ship = regularList.toString(x, y);

		//MISIL POSITION
		else if(missile.getActive() && missile.location(x, y))
			ship = missile.toString();
		 
		//BOMBS POSITION 
		else if(destroyerList.bombLocation(x, y))
			ship = destroyerList.bombSkin();
		 
		//OVNI POSITION
		else if(ufo.getActive() && ufo.location(x, y))
			ship = ufo.toString();
		
		return ship;
	}
	
	// User Info
	public String scoreBoard() {
		String text = "";
		int suma = destroyerList.getCounter()+regularList.getCounter();
		
		text += "  Life : " + ucm.getLife();
		text += "\n  Number of cycles : " + cycle;
		text += "\n  Points : " + points;
		text += "\n  Remaining aliens : " + suma;
		text += "\n  Shockwave : " + shockwave;
		
		return text;
	}
	
	// ----------------------   Update   -----------------------

	// Update
	public void update() {
		cycle++;
		
		updateMissile();
		updateBombs();
		checkHorizontalBorder();
		
		if (cycle % level.getNumCyclesToMoveOneCell() == 0) 
			updateEnemies();
		
		updateUFO();
	}
	
	// Update Missile
	private void updateMissile() {
		boolean impact = false;
		missile.moveMisil(MinColRow);;
		
		// Impact destroyer
		for (int i = 0; !impact && i < destroyerList.getCounter(); i++)
			if (missile.getActive() && destroyerList.location(missile.getX(), missile.getY())) {
				destroyerList.damage(missile.getX(), missile.getY(), missile.getDamage());
				impact = true;
				points += destroyerList.getPoints();
				missile.deactivate();
			}
		
		// Impact regular
		for (int i = 0; !impact && i < regularList.getCounter(); i++)
			if (missile.getActive() &&  regularList.location(missile.getX(), missile.getY())) {
				regularList.damage(missile.getX(), missile.getY(), missile.getDamage());
				impact = true;
				points += regularList.getPoints();
				missile.deactivate();
			}

		// impact ufo
		if (missile.getActive() &&  ufo.location(missile.getX(), missile.getY())) {
			ufo.damage(missile.getX(), missile.getY(), missile.getDamage());
			impact = true;
			shockwave = true;
			points += ufo.getPoints();
			missile.deactivate();
		}
		
		// impact bomb
		if ( missile.getActive() && destroyerList.bombDestroyed(missile.getX(), missile.getY())) {
			impact = true;
			missile.deactivate();
		}
	}
	
	// update Bombs
	private void updateBombs() {
		destroyerList.shootBombs(rand);
		destroyerList.advanceBombs(NUMFIL);
		
		if (destroyerList.bombDestroyed(ucm.getX(), ucm.getY())) 
			ucm.takeLife(destroyerList.getDamage());
			
		else if (missile.getActive() && destroyerList.bombDestroyed(missile.getX(), missile.getY()))
			missile.deactivate();
	}
	
	// update UCM ship
	public void shootMissile() {
		missile.shoot(ucm.getX(), ucm.getY());
	}
	
	// Move ship
	public void moveUCMShip(String dir, String num) {
		int spaces = Integer.parseInt(num);
		
		if (dir.equals("right")) 
			ucm.move(spaces);
		else
			ucm.move(-spaces);
	}

	// update Enemies
	private void updateEnemies() {
		destroyerList.advanceDestroyers(direction);
		regularList.advanceRegulars(direction);
	}
	
	// checkHorizontalBorder
	private void checkHorizontalBorder() {
		if (destroyerList.reachLimit(NUMCOL-1, MinColRow, direction) || regularList.reachLimit(NUMCOL-1, MinColRow, direction)) {
			destroyerList.goDestroyersDown();
			regularList.goRegularsDown();
			
			if (direction)
				direction = false;
			else
				direction = true;
		}
	}
	
	// update ufo
	private void updateUFO() {
		if (ufo.getActive())
			ufo.moverY(MinColRow);
		
		else {
			double num = rand.nextFloat();
			if (num < level.getOvniFrequency()) 
				ufo.starting();
		}
	}
	
	//GAME OVER 
	public boolean gameFinished() {
		boolean finished = false;
		
		if(ucm.getLife() == 0) {
			finished = true;
			ucm.setSkin("!xx!?");
			System.out.println("\n   ALIENS WIN");
		}
		
		else if(regularList.reachBottom(NUMFIL-1) || destroyerList.reachBottom(NUMFIL-1)) {
			finished = true;
			System.out.println("\n   ALIENS WIN");
		}
		
		else if (end) {
			finished = true;
		}
		
		else if (reset) {
			finished = true;
		}
		
		else if(regularList.getCounter() == 0 && destroyerList.getCounter() == 0) {
			finished = true;
			System.out.println("\n   PLAYER WIN");
		}
		
		return finished; 
	}

	
	// ----------------------  Operations ----------------------		
	
	//ACTIVATE SHOCKWAVE 
	public void shootShockwave() {
		if (!ufo.getActive())
			shockwave = false;
		for (int i = 0; i < NUMFIL; i++)
			for (int j = 0; j < NUMCOL; j++) {
				points += regularList.damage(i, j, shockDamage);
				points += destroyerList.damage(i, j, shockDamage);
				points += ufo.damage(i, j, shockDamage);
			}
		
	}

	// End game
	public void endGame() {
		end = true;
	}
	
	// Reset Game
	public void resetGame() {
		reset = true;
	}
	
	// ----------------------  Get  Info  ----------------------		

	// get reset
	public boolean getReset() {
		return reset;
	}
	// get number of rows
	public int getNUMFIL() {
		return NUMFIL;
	}
	
	// get number of columns
	public int getNUMCOL() {
		return NUMCOL;
	}
	
	//COUNTER (CYCLE)
	public int getCycle() {
		return cycle;
	}

	// get active missile
	public boolean getActiveMissile() {
		return missile.getActive();
	}
	
	// get shock wave
	public boolean getShockwave() {
		return shockwave;
	}

	public boolean validMovement(String direction, String spaces) {
		boolean ok = false;
		int num = Integer.parseInt(spaces);
		if (direction.equals("right") || direction.equals("left"))
			if (num == 1 || num == 2) 
			ok = true;
		
		if (ok) {
			if (direction.equals("left")) {
				if ((ucm.getY() - num) < MinColRow)
					ok = false;
			}
			else	
				if ((ucm.getY() + num) > NUMCOL-1)
					ok = false;

			
		}
			
		
		return ok;
	}
}