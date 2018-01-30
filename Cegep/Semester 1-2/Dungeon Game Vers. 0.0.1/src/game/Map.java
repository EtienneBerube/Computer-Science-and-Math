package game;

/* Header
 * 
 * The Map class was made 
 * By
 * 
 * Étienne Bérubé
 * 
 */

/* Class Description
 * 
 * The Map class makes an object of an array of Rooms
 * It is used in the main as the dungeon
 * 
 * 
 */


public class Map {
	
	//Changed the modifier of mapArray to public.
	public Rooms[][] mapArray = new Rooms[12][12];  //This creates the map as an array of rooms
	
	private int numOfEnemies;  //Initializes the integer variable of numOfEnemies 
	
	//This is the constructor Of map. it takes an amount of enemies set in the main 
	
	public Map(int numOfEnemies){
		
		
		this.numOfEnemies = numOfEnemies;  //Sets the number of enemies in the map
		
		//This fills the map of empty rooms
		for(int i = 0; i < mapArray.length; i++)
			for(int j = 0; j < mapArray[i].length; j++)
				mapArray[i][j]= new Rooms();
	
		//This fills the rooms with the right properties
		this.initializeMap();
	}
	
	
	//This method is called to print the map in a string format
	void printMapArray(){
		
		//This prints the map
		for (int i =0; i < mapArray.length;i++){
			for (int j = 0; j < mapArray[i].length; j++)
				System.out.print(mapArray[i][j].printCell());
			  
		    System.out.println();
		 }
		
	}
	
	
	
	//This method creates the walls(fixed), enemies(varies) and the ending(fixed)
	private void initializeMap(){
		
		//vertical left
		for(int i = 0; i < mapArray.length; i++)
			mapArray[i][0].setBloc();
		
	
		//vertical right
		for(int i = 0; i < mapArray.length; i++)
			mapArray[i][mapArray[i].length - 1].setBloc();
		
		
		//horizontal up
		for(int i = 0; i < mapArray[0].length; i++)
			mapArray[0][i].setBloc();
		
		
		//horizontal down
		for(int i = 0; i < mapArray[mapArray.length - 1].length; i++)
			mapArray[mapArray.length - 1][i].setBloc();
		
		
		//wall #1 column
		for(int i = 1; i < mapArray.length - 2; i++)
			mapArray[i][2].setBloc();
		
		
		//wall #2 row
		for(int i = 3; i < mapArray[9].length - 2; i++)
			mapArray[9][i].setBloc();
		
		
		//wall #3 row
		for(int i = 4; i < mapArray[7].length; i++)
			mapArray[7][i].setBloc();
		
		
		//wall #4 column
		for(int i = 2; i < mapArray.length - 4; i++)
			mapArray[i][4].setBloc();
		
		
		//wall #5 column
		for(int i = 1; i < mapArray.length - 6; i++)
			mapArray[i][6].setBloc();
		
		
		//wall #6 column
		for(int i = 2; i < mapArray.length - 4; i++)
			mapArray[i][8].setBloc();
		
		
		//wall #7 row
		for(int i = 9; i < mapArray[2].length - 2; i++)
			mapArray[2][i].setBloc();
		
		
		//wall#8 row
		for(int i = 10; i < mapArray[4].length - 1; i++)
			mapArray[4][i].setBloc();
		
		
		//Starting point
		mapArray[1][1].setHeroPosition();
		
		//end point
		mapArray[6][10].setEnd();
		
		
	
		int EnemyCount = 0;
		while(EnemyCount <= numOfEnemies ){ // The number in the condition is the number of enemies that will appear on the map (cannot be more than 57)
			int a = (int)(1 + Math.random() * 10);
			int b = (int)(1 + Math.random() * 10);
			
			
			//Checks to not put any enemies at the starting point and in a bloc
			if(!(mapArray[a][b].printCell().equals("[ ]")) 
					&& !(mapArray[a][b].printCell().equals("{O}"))
					&& !(a == 1 && b == 1) 
					&& !(mapArray[a][b].getIsEnemy())) 
			{

				mapArray[a][b].setEnemy();
				EnemyCount++;
				
			}
		
		}
		
		
	}
	

}
