package controller;

import java.util.Scanner;

import commands.CommandGenerator;
import commands.Command;

import game.Game;
import view.BoardPrinter;
import java.lang.String;

public class Controller {
	
	// ______________________ Variables   ______________________  

	private Game game;
	private Scanner in;
	private BoardPrinter printer;
	
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
				else {
					System.out.print("  Command > ");
				}
			}
			
			else 
				// Error message
				System.out.format("  Unkown Command, please try again\n  Command > ");
		}
		
		// End game
		BoardPrinter bp = new BoardPrinter(Game.DIM_Y, Game.DIM_X);
		System.out.println(bp.toString(game));		
	}
	
	
	// Print Game
	private void printGame() {
		printer = new BoardPrinter(Game.DIM_Y, Game.DIM_X);
		
		System.out.println(printer.scoreBoard(game));
		System.out.print(printer.toString(game));
		System.out.print("  Command > ");
	}
}



