package game;

public class UCMShip extends Ship {
	
	private boolean shockwave = false;

	// ______________________ Constructor ______________________    

	public UCMShip(Game game, int x, int y, int live) {
		super(game, 7, 4, 3);
		// TODO Auto-generated constructor stub
	}

	// ______________________   Methods   ______________________
	
	// computer action -----------------------------------------
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

	// on delete -----------------------------------------------
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}


	// get shock wave
	public boolean getShockwave() {
		return shockwave;
	}

	@Override
	// not used -----------------------------------------------
	public void move() {
		// Empty
		
	}
	public void enableShockWave() {
		
	}

}
