package gameObjects;

import game.*;

public class Bomb extends Weapons{
	
		private DestroyerAlien destroyer;
	// ______________________ Constructor ______________________    


	public Bomb(Game game, int x, int y,DestroyerAlien destroyer) {
		super(game, x, y, 1);
		this.destroyer = destroyer;
	}

	// ______________________ METHODS _______________________
	
	//_______________________ abstract _____________________
	
	@Override
	public void onDelete() {
	}
	
	@Override
	public void computerAction() {
	}

	@Override
	public void deactivate() {
		lives = 0;
		destroyer.set(false);
	}

	//_______________________ move __________________________
	public void move() {
		posX++;
		if (Game.DIM_X == posX) {
			deactivate();
			destroyer.set(false);
		}
	}

	//________________________ get skin _________________________
	
	public String toString() {
		return "*";
	}

	//________________________ recieve missil attack ____________
	
	public boolean receiveMissileAttack(int damage) {
		damageObject(damage);
		return true;
	}

	@Override
	public String toStringified() {
		return "B;" + posX + "," + posY + "\n";
	}
}

