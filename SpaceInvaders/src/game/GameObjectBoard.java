package game;

import gameObjects.GameObject;

public class GameObjectBoard {
	
	//______________________ VARIABLES________________________
	
	private GameObject[] objects;
	private int currentObjects;
	
	//______________________CONSTRUCTOR_______________________
	
	public GameObjectBoard (int width, int height) {
		
		objects = new GameObject[width * height];
		currentObjects = 0;
	}
	
	
	//_______________________METHODS (PRIVATE)_____________________________
	
	// get current objects
	private int getCurrentObjects () {
		return this.currentObjects; 
	}
	
	// get objet in position
	private GameObject getObjectInPosition (int x,int y ) {
		
		for(int i = 0; i < currentObjects; i++) {
			
			if(objects[i].getPosX() == x && objects[i].getPosY() == y) {
				return objects[i];
			}
		}
		return null;
	}
	
	// get index
	private int getIndex(int x, int y) {
		int index=0;
		for(int i=0; i < objects.length; i++) {
			if(objects[i].location(x, y)) {
				index=i;
			}
		}
		return index;
	}
	
	// remove
	private void remove (GameObject object) {
		int index = 0;
		boolean found = false;
		for(int i=0; i < objects.length; i++) {
			if(objects[i].equals(object)) {
				index = i;
				found = true;
			}
		}
		if(found) {
			for(int i = index;i< currentObjects-1;i++) {
				objects[i] = objects[i+1];
			}
		}
	}
	
	// check attacks
	private void checkAttacks(GameObject object) { // Preguntar si hace esta funcion
		for(GameObject aux : objects) {
			aux.performAttack(object);
		}	
		
	}

	// remove dead
	private void removeDead() {
		int index = 0;
		boolean found = false;
		for(int i = 0; i < currentObjects;i++) {
			if(!objects[i].isAlive()) {
				found = true;
				index = i;
			}
		}
		
		if(found) {
			for(int i = index;i< currentObjects-1;i++) {
				objects[i] = objects[i+1];
			}
		}
		
	}
	
//_______________________METHODS (PUBLIC)_____________________________
	
	// add
	public void add (GameObject object) {
		objects[currentObjects] = object;
		currentObjects++;
	}
	
	// update
	public void update() { // Preguntar si solo se mueven al hace update
		for(GameObject obj : objects) {
			obj.move();
		}
	}
	
	// computer action
	public void computerAction() {
		for(GameObject obj : objects) {
			obj.computerAction();
		}
	}
	
	// to string
	public String toString(int x, int y) {
		for(GameObject obj : objects) {
			if(obj != null && obj.location(x, y)){
				return obj.toString();
			}
		}
		return " ";
	}
	
}
