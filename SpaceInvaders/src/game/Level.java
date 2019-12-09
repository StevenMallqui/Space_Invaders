package game;


public enum Level {
 
	EASY(4, 2, 0.2, 3, 0.5), 
	HARD(8, 4, 0.3, 2, 0.2),
	INSANE(12, 4, 0.5, 1, 0.1);

	private int numRegularAliens;
	private int numDestroyerAliens;
	private int numCyclesToMoveOneCell;
	private double ovniFrequency;
	private double shootFrequency;
	private double turnExplodeFrequency = 0.005;

	private Level(
			int numRegularAliens, 
			int numDestroyerAliens, 
			double shootFrequency, 
			int numCyclesToMoveOneCell, 
			double ovniFrequency
			)
	{
		this.numRegularAliens = numRegularAliens;
		this.numDestroyerAliens = numDestroyerAliens;
		this.shootFrequency = shootFrequency;
		this.numCyclesToMoveOneCell = numCyclesToMoveOneCell;
		this.ovniFrequency = ovniFrequency;
	}
	
	public int getNumCyclesToMoveOneCell() {
		return numCyclesToMoveOneCell;
	}

	
	
	public static Level parse(String cadenaEntrada) {
		for (Level level : Level.values())
			if (level.name().equalsIgnoreCase(cadenaEntrada))
				return level;
	    return EASY;
	}
	
	// Weapons
	public double getShootFrequency() {
		return shootFrequency;
	}
	
	public double getTurnExplodeFrequency(){
		return turnExplodeFrequency;
	}


	// Regular
	public int getNumRegularAliens() {
		return numRegularAliens;
	}
	
	public int getRegularStartingRow() {
		return 1;
	}
	
	public int getRegularStartingCol() {
		return 3;
	}
		
	public int getNumAliensPerRow() {
		return 4;
	}


	// Destroyers
	public int getDestroyerStartingRow() {
		return getRegularStartingRow() + (numRegularAliens / getNumAliensPerRow());
	}
	

	public int getNumDestroyerAliens() {
		return numDestroyerAliens;
	}

	public int getDestroyerStartingCol() {
		if (numDestroyerAliens == 2)
			return 4;
		return 3;
	}

	// Ovni
	public double getOvniFrequency() { 
		return ovniFrequency;
	}

	
}
