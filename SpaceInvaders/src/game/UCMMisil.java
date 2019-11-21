package game;


public class UCMMisil extends Weapons {
	
	// ______________________ Variables   ______________________  
	
	private int posX;
	private int posY;
	private boolean active;
	private final int damage = 1;

	// ______________________ Constructor ______________________  

	public UCMMisil() {
		active = false;
	}

	// ______________________   Methods   ______________________

	// ----------------------   Get Info  ----------------------

	// Get skin
	public String toString() {
		return "oo";
	}

	// Is in x position
	public boolean location(int x, int y) {
		return(posX== x && posY== y);
	}

	// Get active
	public boolean getActive() {
		return active;
	}
	
	// get height
	public int getX() {
		return posX;
	}
	
	// Get column
	public int getY() {
		return posY;
	}
	
	// get damage
	public int getDamage() {
		return damage;
	}

	// ----------------------  Operations ----------------------

	// advance missile
	public void moveMisil(int min) {
		posX--;
		
		if(posX < min) 
			active = false;
	}
		
	// shoot missile
	public void shoot(int x, int y) {
		posX=x;
		posY=y;
		active = true;
		
	}
	
	// deactivate missile
	public void deactivate() {
		active = false;
	}
	
	
}