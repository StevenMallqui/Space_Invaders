package main;

import controller.Controller;
import game.Game;
import java.util.Random;


public class Main {
	
	// Static main class
	 public static void main(String[] args) {
		 boolean reset;
		 long seed = 0l;
		 String level;
		 
		 
		 // Read arguments
		 if (args.length > 0) {
			 
			 // Read level
			 level = args[0];
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
			 
			 do {
			 Game game = new Game(level, rand);
			 Controller controlador = new Controller(game);
			 
			 // Run game
			 controlador.run();
			 
			 reset = controlador.getReset();
			 } while (reset);
		 }
		 
		 else 
			 System.err.println("   No level detected ... ");
		 
	 } 
}



// ______________________ Variables   ______________________  

// ______________________ Constructor ______________________    


// ______________________   Methods   ______________________

// ----------------------   Get Info  ----------------------


// ----------------------   Set Info  ----------------------


// ----------------------  Operations ----------------------
