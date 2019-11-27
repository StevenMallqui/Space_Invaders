package main;

import controller.Controller;
import game.Game;
import game.Level;

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
			 Level nvl = null;
			 
				if (level.equals("EASY"))
					nvl = Level.EASY;
					
				else if (level.equals("HARD"))
					nvl = Level.HARD;
					
				else if (level.equals("Insane"))
					nvl = Level.INSANE;
		 
			 do {
			 Game game = new Game(nvl, rand);
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
