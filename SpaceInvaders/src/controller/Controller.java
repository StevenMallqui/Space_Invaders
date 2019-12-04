package controller;

import java.util.Scanner;

import commands.CommandGenerator;
import exceptions.*;
import commands.Command;

import game.Game;

import view.GamePrinter;
import view.PrinterGenerator;

import java.lang.String;

public class Controller {
	
	// ______________________ Variables   ______________________  

	private Game game;
	private Scanner in;
	
	String printerType = "boardprinter";
	
	// ______________________ Constructor ______________________    

	public Controller(Game game) {
		this.game = game;
		in = new Scanner(System.in); 
	}

	// ______________________   Methods   ______________________

	// Run
	public void run() {
		GamePrinter printer = PrinterGenerator.parse(printerType);
		System.out.print(printer.toString(game));
		
		while (!game.isFinished()) {
			// Receive Command
			String[] words = in.nextLine().toLowerCase().trim().split("\\s+");
			
			try {
			Command command = CommandGenerator.parse(words);

				if (command != null) {
					if (command.execute(game))
						System.out.print(printer.toString(game));
					else {
						System.out.print("  Command > ");
					}
				}
			}
			catch (CommandParseException|CommandExecuteException ex) {
					
					System.err.println(ex.getMessage()); 
					System.out.print(" Command > ");
			}
			
		}
		
		System.out.println(game.getWinnerMessage());
	}
	
	public void changePrinter() {
		if (printerType.equals("bordprinter"))
			printerType = "stringifier";
		
		else
			printerType = "boardPrinter";
	}
}



