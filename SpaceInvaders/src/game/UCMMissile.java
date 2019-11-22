package game;


public class UCMMissile extends Weapons {
	
	// ______________________ Variables   ______________________  

	// ______________________ Constructor ______________________    

	public UCMMissile(Game game, int x, int y, int live) {
		super(game, x, y, live);
		// TODO Auto-generated constructor stub
	}

	public void computerAction() {
		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		posY--;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "oo";
	}

	// ______________________   Methods   ______________________

	// ----------------------   Get Info  ----------------------


	// ----------------------   Set Info  ----------------------


	// ----------------------  Operations ----------------------

	
}