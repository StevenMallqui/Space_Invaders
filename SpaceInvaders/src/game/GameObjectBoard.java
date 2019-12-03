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
			
			if(objects[i].location(x, y)) {
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
				
				for (int j = pos; j < currentObjects-1; j++) 
					objects[j] = objects[j+1];
				
			}
		
		currentObjects--;
		objects = newList(currentObjects);
	}
	
	// check attacks
	private void checkAttacks(GameObject object) {
		for (GameObject obj : objects) {
				obj.performAttack(object);
		}	
	}

	// remove dead
	private void removeDead() {
		for(int i = 0; i < currentObjects; i++) 
			if(!objects[i].isAlive()) {
				remove(objects[i]);
				i--;
			}
				
			
				
	}
	
//_______________________METHODS (PUBLIC)_____________________________
	
	// add
	public void add(GameObject object) {
		objects = newList(currentObjects +1);
		objects[currentObjects] = object;
		currentObjects++;
	}
	
	// new list
	public GameObject[] newList(int size) {
		GameObject[] list = new GameObject[size];
		
		for (int i = 0; i < currentObjects; i++)
			list[i] = objects[i];
		
		return list;
	}
	
	// update
	public void update() {
		for (GameObject obj : objects) {
			if (!(obj instanceof AlienShip)) 
				obj.move();				
		}
		
		boolean goDown = false;
		for (GameObject obj : objects) {
			if (obj instanceof AlienShip && !goDown)
				goDown = ((AlienShip) obj).checkBorders();
		}
		
		if (goDown) {
			for (GameObject obj : objects) {
				if (obj instanceof AlienShip)
					((AlienShip) obj).goDown();
			}
		}
		
		else {
			for (GameObject obj : objects) {
				if (obj instanceof AlienShip)
					obj.move();
			}
		}
		
		objectImpact();
	}
		
	// computer action
	public void computerAction() {
		for(GameObject obj : objects) {
				obj.computerAction();
				checkAttacks(obj);
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

	// shoot laser
	public boolean shootLaser() {
		for (GameObject go : objects) 
			if (go instanceof UCMMissile) 
				return false;
		
		return true;
	}

	// shoot shock wave
	public boolean shootShockwave() {
		for (GameObject go: objects) {
			go.receiveMissileAttack(1);

		}
		
		return true;
	}
	
	// all dead
		public boolean allDead() {			
			for (GameObject go : objects) {
				if (go.isAlive())
					return false;
			}
			
			return true;
		}
		
		// have landed
		public boolean haveLanded() {
			for (GameObject go : objects) {
				if (go instanceof AlienShip || go.getPosX() == Game.DIM_X -1)
					return false;
			}
			
			return true;
		}

		// object impact
		public void objectImpact() {
			for (GameObject obj : objects) {
				if (obj instanceof UCMMissile) {
					GameObject imp = getObjectInPosition(obj.getPosX(), obj.getPosY());
					if (imp.receiveMissileAttack(((UCMMissile) obj).getDamage()))
						((Weapons) obj).deactivate();
					
				}
				
				else if (obj instanceof Bomb) {
					GameObject imp = getObjectInPosition(obj.getPosX(), obj.getPosY());
					if (imp.receiveBombAttack(((Bomb) obj).getDamage()))
						((Weapons) obj).deactivate();
					
				}
			}
			removeDead();
		}
}
