package main;

import controller.Controller;
import game.Game;
import game.Level;

import java.util.Random;
import java.util.Scanner;

public class Main {
	
	// Static main class
	 public static void main(String[] args) {
		 long seed = 0l;
		 String level;
		 
		 	
		 // Read arguments
		 while (args.length == 0) {
			System.out.print("   Introduce Level and/or seed : ");
		 	@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			args = scan.nextLine().toUpperCase().trim().split("\\s+");
			
		 }
		 
		 // Read level
		 level = args[0];
		 System.out.println("Level : " + level);
		 
		 
		 // Read seed
		 if(args.length == 2) {
			 try {
				 seed = Integer.parseInt(args[1]);
			 }
			 
			 catch(NumberFormatException e) {
				 System.out.println("   Generating random seed ...");
				 seed = new Random(System.currentTimeMillis()).nextInt();  
			 }
		 }
		 
			 
		 Random rand = new Random(seed);
		 Level nvl = null;
		 
			if (level.equals("EASY"))
				nvl = Level.EASY;
				
			else if (level.equals("HARD"))
				nvl = Level.HARD;
				
			else if (level.equals("INSANE"))
				nvl = Level.INSANE;
	 
		 Game game = new Game(nvl, rand);
		 Controller controlador = new Controller(game);
		 
		 // Run game
		 controlador.run();
		 
	 }
	 
	 
	 
	 
}


