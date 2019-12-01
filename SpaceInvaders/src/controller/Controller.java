package controller;

import java.util.Scanner;

import commands.CommandGenerator;
import commands.Command;

import game.Game;
import game.GamePrinter;
import java.lang.String;

public class Controller {
	
	// ______________________ Variables   ______________________  

	private Game game;
	private Scanner in;
	private GamePrinter pintar;
	
	// ______________________ Constructor ______________________    

	public Controller(Game game) {
		this.game = game;
		in = new Scanner(System.in); 
	}

	// ______________________   Methods   ______________________

	// Run
	public void run() {
		printGame();
		
		while (!game.isFinished()) {
			// Receive Command
			String[] words = in.nextLine().toLowerCase().trim().split("\\s+");
			Command command = CommandGenerator.parse(words);
			
			// Execute
			if (command != null) {
				if (command.execute(game))
					printGame();
				else
					System.out.print("  Command > ");
			}
			
			else 
				// Error message
				System.out.format("  Unkown Command, please try again\n  Command > ");
		}
		
		// End game
		System.out.println(new GamePrinter(game, Game.DIM_X, Game.DIM_Y));		
	}
	
	
	// Print Game
	private void printGame() {
		pintar = new GamePrinter(game, Game.DIM_Y, Game.DIM_X);
		
		System.out.println(game.scoreBoard());
		System.out.print(pintar);
		System.out.print("  Command > ");

	}
}



