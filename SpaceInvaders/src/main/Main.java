
/*   PRACTICA DE MARCOS CONNOLLY LOPEZ Y STEVEN MALLQUI AGUILAR  */
				/*              2 D                 */

package main;

import controller.Controller;
import game.Game;
import game.Level;

import java.util.Random;


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