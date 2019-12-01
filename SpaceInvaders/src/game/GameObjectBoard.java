package game;

import gameObjects.*;

public class GameObjectBoard {
	
	//______________________ VARIABLES________________________
	
	private GameObject[] objects;
	private int currentObjects;
	
	//______________________CONSTRUCTOR_______________________
	
	public GameObjectBoard (int width, int height) {
		
		objects = new GameObject[0];
		currentObjects = 0;
	}
	
	
	//_______________________METHODS (PRIVATE)_____________________________
		
	// get object in position
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
		for(int i=0; i < currentObjects; i++) {
			if(objects[i].location(x, y)) {
				index=i;
			}
		}
		return index;
	}
	
	// remove
	private void remove(GameObject object) {
		for (int i = 0; i < currentObjects; i++) 
			if (objects[i].equals(object)) {
				int pos = i;
				
				for (int j = pos; j > currentObjects -1; j++) 
					objects[i] = objects[i+1];
				
			}
		
		objects = newList(currentObjects -1);
		objects[currentObjects] = object;
		currentObjects++;
	}
	
	// check attacks
	private void checkAttacks(GameObject object) {
		for(GameObject obj : objects) {
				obj.performAttack(object);
		}	
		
	}

	// remove dead
	private void removeDead() {
		int index = 0;
		boolean found = false;
		for(int i = 0; i < currentObjects; i++) {
			if(!objects[i].isAlive()) {
				found = true;
				index = i;
			}
		}
		
		if(found) {
			for(int i = index; i < currentObjects-1;i++) {
				objects[i] = objects[i+1];
			}
		}
		
	}
	
//_______________________METHODS (PUBLIC)_____________________________
	
	// add
	public void add(GameObject object) {
		objects = newList(currentObjects);
		objects[currentObjects] = object;
		currentObjects++;
	}
	
	// new list
	public GameObject[] newList(int size) {
		GameObject[] list = new GameObject[size +1];
		
		for (int i = 0; i < currentObjects; i++)
			list[i] = objects[i];
		
		return list;
	}
	
	// update
	public void update() {
		for (GameObject go : objects) 
			if (go instanceof AlienShip)
				go.move();
			
			
			else 
				go.move();		
	}
	
	// computer action
	public void computerAction() {
		for(GameObject obj : objects) {
				obj.computerAction();
		}
		
		removeDead();
	}
	
	// to string
	public String toString(int x, int y) {
		for(GameObject obj : objects) {
			if(obj.location(x, y)){
				return obj.toString();
			}
		}
		return " ";
	}

	// get number of enemies
	public int getCurrentEnemies() {
		int num = 0;
		
		for(GameObject obj : objects) 
			if(obj instanceof AlienShip)
				num++;
				
		return num;
	}

	
	public boolean shootLaser() {
		for (GameObject go : objects) 
			if (go instanceof UCMMissile) 
				if (go.isAlive())
					return false;

		return true;
	}


	public boolean shootShockwave() {
		for (GameObject go: objects) {
			if (go instanceof EnemyShip)
				go.damageObject(1);
		}
		
		return true;
	}
			
}
