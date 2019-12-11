
/*   PRÁCTICA DE MARCOS CONNOLLY LÓPEZ Y STEVEN MALLQUI AGUILAR  */
				/*              2º D                 */

package main;

import controller.Controller;
import exceptions.*;
import game.Game;
import game.Level;

import java.util.Random;
import java.util.Scanner;


public class Main{
	
	public static void main(String[] args) {
		
		 long seed = 0l;
		 String level;
		
	 if (args.length > 0) {
			 
			 // Read level
			 level = args[0].toUpperCase();
			 System.out.println("Level : " + level);
			 
			 
			 // Read seed
			 if(args.length == 2) {
				 try {
					 seed = Integer.parseInt(args[1]);
				 }
				 
				 catch(NumberFormatException e) {
					 System.out.println("   Loading random seed ...");
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
		
	 else 
		 System.err.println("   No level detected ... ");
		 
	}
	
}


/* public class Main {
	
	// Static main class
	 public static void main(String[] args) {
		 long seed = 0l;
		 String level = null;
		 boolean entry = false;

		 
		// Read arguments
		 
				 while (!entry) {
					 
					try {
					 
					System.out.print("   Introduce Level and/or seed : ");
				 	Scanner scan = new Scanner(System.in);
					args = scan.nextLine().toUpperCase().trim().split("\\s+");
					
						 if(args.length == 2) {
							
								 if(args[0].equals("EASY")||args[0].equals("HARD")||args[0].equals("INSANE")) {
									 level = args[0];
									 
									 seed = Integer.parseInt(args[1]);
									 System.out.println("Level : " + level);
									 entry = true;
								 
								}
								 
								else {
									 throw new levelException();
							    }
						 }
					 }
					
					 catch(levelException|NumberFormatException e) {
						 System.out.println(e.getMessage());
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
	 

	 
} */
	 
	 
	 
	 
	 

	 
