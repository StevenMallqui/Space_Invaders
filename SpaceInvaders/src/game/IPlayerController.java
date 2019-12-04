package game;

import exceptions.CommandExecuteException;

public interface IPlayerController {
	
	// PLAYER ACTIONS	
	public boolean move (int numCells) throws CommandExecuteException;
	public boolean shootLaser() throws CommandExecuteException;
	public boolean shockWave();
	
	// CALLBACKS
	public void receivePoints(int points);
	public void enableShockWave();
	public void enableMissile();
	
}
