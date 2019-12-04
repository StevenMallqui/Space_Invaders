package view;

import game.Game;


public class Stringifier implements GamePrinter {
	
	Game game;

	public Stringifier() {

	}
	
	@Override
	public String toString(Game game) {
		String text = "\n";
		
		text += "-- Space Invaders --\n\n";
		text += "G:" + game.getCycle() + "\n";
		text += "L:" + game.getLevel() + "\n";
		text += game.boardToStringifier();
		
		return text;
	}

	@Override
	public GamePrinter parse(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String helpText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setGame(Game game) {
		// TODO Auto-generated method stub
		
	}

}
