package pr2.view;

import pr2.game.Game;

public interface GamePrinter {
	String toString(Game game);
	public GamePrinter parse(String name);
	public String helpText();
}
