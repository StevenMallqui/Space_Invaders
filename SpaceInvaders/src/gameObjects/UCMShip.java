package gameObjects;

import exceptions.CommandExecuteException;
import exceptions.buysupermissileException;
import exceptions.limitException;
import game.Game;

public class UCMShip extends Ship {
	
	private boolean shockwave = false;
	private boolean missile = false;
	private String skin = "^__^";
	private int points;
	
	private int numSpacesMove;
	private int superMissile = 0;

	// ______________________ Constructor ______________________    

	public UCMShip(Game game, int x, int y) {
		super(game, y, x, 3);
		points = 0;
	}

	// ______________________   Methods   ______________________

	public void computerAction() {
		
	}
	
	public void decreaseSuperMissiles() {
		if(superMissile > 0) {
			superMissile--;
		}
	}
	
	public boolean performAttack(GameObject other) {
		if (other != null)
			return missile;
		
		else
			return false;
	}

	public void onDelete() {
		game.endGame();
		skin = "!xx!";
	}

	public String toString() {
		return skin;
	}
	
	public boolean receiveBombAttack(int damage) {
		if (lives > 0) {
			damageObject(damage);
			return true;
		}
		
		return false;
	}

	public void addSuperMissile() {
		superMissile++;
	}

	public void substractMissile() {
		superMissile--;
	}

	@Override
	public String toStringified() {
		return "P;" + posX + "," + posY + ";" + lives + ";" + points +
				";" + shockwave + ";" + superMissile +"\n";
	}

	//__________________MOVE__________________
	
	public void move() {
		posY += numSpacesMove;
		numSpacesMove = 0;
	}

	public boolean emove(int num) throws CommandExecuteException {
		boolean ok = false;
		try {	
			if (getPosY() + num >= 0 && getPosY() + num <= Game.DIM_Y) {
				ok = true;
				setMovement(num);
			}
			else {
				throw new limitException();
			}
		}
		catch(limitException e) {
			throw new CommandExecuteException(e.getMessage());
		}
			
		return ok;
	}

	//__________________SHOOT__________________
	
	public boolean shootLaser() {
		if (getActiveMissile())
			return false;
		
		else {
			game.getBoard().add(new UCMMissile(game, getPosX(), getPosY()));
			setMissileActive(true);
			return true;
		}
	
	}

	public boolean shockWave() {
		if (getShockwave()) {
		game.getBoard().shootShockwave();
		setShockWave(false);
		return true;
		}
		
		else 
			return false;
	
	}
	
	public boolean shootSuperMissile() {
		if (getActiveMissile() ||getNumSuperMissile() < 1)
			return false;
			
		else {
			game.getBoard().add(new UCMSuperMissile(game,getPosX(),getPosY()));
			setMissileActive(true);
			points--;
			substractMissile();
			return true;
		}
	}
	
	//__________________BUY SUPERMISSILE__________________
	
	public void buySuperMissile() throws CommandExecuteException{
		try {
			if (points >= 20) {
					System.out.println("   Missile acquired");
					addSuperMissile();
					points -= 20;
			}
			
			else 
				throw new buysupermissileException();
		}
		catch(buysupermissileException e) {
			throw new CommandExecuteException (e.getMessage());
		}
	}
	
	//__________________GETTERS & SETTERS__________________
	
	public boolean getShockwave() {
		return shockwave;
	}
	
	public boolean getMissile() {
		return missile;
	}

	public int getLives() {
		return this.getLive();
	}
	
	public int getPoints() {
		return points;
	}
	
	public int getNumSuperMissile() {
		return superMissile;
	}
	
	public boolean getActiveMissile() {
		return missile;
	}

	public void setShockWave(boolean sk) {
		shockwave = sk;
	}
	
	public void setMovement(int num) {
		numSpacesMove = num;
	}
	
	public void setPoints(int num) {
		points += num;
	}

	public void setMissileActive(boolean actv) {
		missile = actv;
	}
}