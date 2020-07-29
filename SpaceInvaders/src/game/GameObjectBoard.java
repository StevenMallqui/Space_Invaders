package game;

import gameObjects.*;

public class GameObjectBoard {
	
	//______________________ VARIABLES _______________________
	
	private GameObject[] objects;
	private int currentObjects;
	
	//_____________________ CONSTRUCTOR ______________________
	
	public GameObjectBoard (int width, int height) {
		
		objects = new GameObject[width*height];
		currentObjects = 0;
	}
	
	
	// _______________________  METHODS ________________________
	
	// -----------------------  PRIVATE  -----------------------

	// get object in position
	private GameObject getObjectInPosition (int x,int y ) {
		return objects[getIndex(x, y)];
	}
	
	// get index
	private int getIndex(int x, int y) {
		int index=0;
		for(int i=0; i < currentObjects; i++) {
			if (objects[i] != null)
				if(objects[i].location(x, y)) {
					index=i;
				}
		}
		return index;
	}
	
	// remove
	private void remove(GameObject object) {
		for (int i = 0; i < currentObjects; i++) 
			if (objects[i] != null)
				if (objects[i].equals(object)) {
					for (int j = i; j < currentObjects-1; j++) 
						objects[j] = objects[j+1];
					
				}
		
		currentObjects--;
//		objects = newList(currentObjects);
	}
	
	// check attacks
	private void checkAttacks(GameObject object) {
		for (int j = 0; j < currentObjects; j++)
			if (objects[j] != null)
				if (object.getPosX() == objects[j].getPosX())
					if (object.getPosY() == objects[j].getPosY())
						object.performAttack(objects[j]);
	}

	// remove dead
	private void removeDead() {
		for(int i = 0; i < currentObjects; i++) 
			if (objects[i] != null)
				if(!objects[i].isAlive()) {
					objects[i].onDelete();
					remove(objects[i]);
					i--;
				}
	}
	
	
	// ----------------------   Public   -----------------------
	
	// add
	public void add(GameObject object) {
//		objects = newList(currentObjects +1);
		objects[currentObjects] = object;
		currentObjects++;
	}
	
	
	// update
	public void update() {
		for (GameObject obj : objects) {
			if (obj != null) {
				obj.move();
				checkAttacks(obj);
			}
		}
		
		removeDead();
	}
		
	// computer action
	public void computerAction() {
		for(GameObject obj : objects) {
			if (obj != null) {
				obj.computerAction();
				checkAttacks(obj);

			}
		}
		
		removeDead();
	}
	
	// to string
	public String toString(int x, int y) {
		for(GameObject obj : objects) {
			if(obj != null && obj.location(x, y)){
				return obj.toString();
			}
		}
		
		return "";
	}
	
	// shoot shock wave
	public boolean shootShockwave() {
		for (GameObject go: objects) {
			if (go != null)
				go.receiveShockWaveAttack(1);
		}
		
		removeDead();
		return true;
	}


	// explode ship
	public void explode(int x, int y) {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++) 
				if (getObjectInPosition(x -1 +i, y -1 +j) != null) {
					getObjectInPosition(x -1 +i, y -1 +j).receiveMissileAttack(1);
				}
	}

	// Board info to Serialize
	public String toStringifier() {
		String text = "";
		
		for (GameObject obj : objects) 
			if (obj != null)
				text += obj.toStringified();
		
		return text;
	}

}
