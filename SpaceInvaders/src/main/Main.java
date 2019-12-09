
/*   PRÁCTICA DE MARCOS CONNOLLY LÓPEZ Y STEVEN MALLQUI AGUILAR  */
				/*              2º D                 */

package main;

import controller.Controller;
import game.Game;
import game.Level;

import java.util.Random;
import java.util.Scanner;

public class Main {
	
	// Static main class
	 public static void main(String[] args) {
		 int seed = 0;
		 String level = null;
		 boolean entry = false;

		 
		// Read arguments
				 while (!entry) {
					System.out.print("   Introduce Level and/or seed : ");
				 	Scanner scan = new Scanner(System.in);
					args = scan.nextLine().toUpperCase().trim().split("\\s+");
					
					 if(args.length == 2) {
						
							 if(args[0].equals("EASY")||args[0].equals("HARD")||args[0].equals("INSANE")) {
								 level = args[0];
								 System.out.println("Level : " + level);
								 try {
									 seed = Integer.parseInt(args[1]);
								 }
								 
								 catch(NumberFormatException e) {
									 System.out.println("   Generating random seed ...");
									 seed = new Random(System.currentTimeMillis()).nextInt();  
								 }
								 entry = true;
							 
							}
							 
							 else {
								 	System.out.println("   Level must be one of: EASY, HARD, INSANE.");
							 }
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
	 
	 
	 
	 
	 

	 
