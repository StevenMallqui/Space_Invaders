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
	
	private boolean reset = false;

	// ______________________ Constructor ______________________    

	public Controller(Game game) {
		this.game = game;
		in = new Scanner(System.in); 
	}

	// ______________________   Methods   ______________________

	// Run
	public void run() {
		printGame();
		
		while (!game.gameFinished()) {
			// Receive Command
			String[] words = in.nextLine().toLowerCase().trim().split("\\s+");
			Command command = CommandGenerator.parse(words);
			
			// Execute
			if (command != null) {
				if (command.execute(game))
					printGame();
			}
			
			else 
				// Error message
				System.out.format("  Unkown Command, please try again\n  Command > ");
		}
		
		// End game
		System.out.println(new GamePrinter(game,game.getNUMFIL(),game.getNUMCOL()));
		
		
		// Reset game?
		reset = game.getReset();
	}
	
	
	
	// Print Game
	private void printGame() {
		pintar = new GamePrinter(game,game.getNUMFIL(),game.getNUMCOL());
		game.scoreBoard();
		
		System.out.println(game.scoreBoard());
		System.out.print(pintar);
		System.out.print("  Command > ");

	}
	
	/*
	// Is command valid
	private boolean validCommand(String[] words) {
		boolean correct = false;
		
		// Valid command cycle			
		if (words.length == 1) {
			switch(words[0]) {
			// Non formal commands
			case "help":
			case "h": 
				game.showInstructions();
				break;
			case "list":
			case "l":
				game.list();
				break;
				
			// Exit commands
			case "r":
			case "reset":
				reset = true;
				break;
			case "exit":
			case "e":
				exit = true;
				correct = false;
				System.out.println("GAME OVER");
				break;
				
			// Executable commands
			case "":
				correct = true;
				break;
			case "shoot":
			case "s":
				if (!game.getActiveMissile())
					correct = true;
				else
					System.err.println("  Not available ");
				break;
			case "shockwave":
			case "w":
				if (game.getShockwave())
				correct = true;
				else 
					System.err.println("  Not available ");
			break;
			
			// Not found commands
			default:
				System.err.println("  Command not found ...");
			}
		}

		// Movement command
		else if (words.length == 3) 
			if (words[0].equals("move")||words[0].equals("m")) 
				if(words[1].equals("left") || words[1].equals("right")) 
					if (words[2].equals("1") || words[2].equals("2"))
						correct = true;	
		
		return correct;
	}*/
	
	// get reset
	public boolean getReset() {
		return reset;
	}
}



