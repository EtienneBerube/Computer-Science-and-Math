package game;
import java.util.Scanner;

/*
 * Program Name
 * 
 * Dungeon of the Hero
 * 
 * 
 */
		
/*
 *
 * 
 * Program Description
 * 
 * 1- The program lets the user to choose a type of hero, a name, sex and difficulty
 * 1.1- The statistics of each classes impact the gameplay mechanics
 * 2- The program lets the user move in a dungeon
 * 3- The program lets the user fight enemies in the dungeon
 * 3.1- The program lets the user decide to attack, defense, heal or look during combats
 * 3.1.1- The user has 3 potions to heal himself
 * 4- The program ends when the user's hero reaches the end of the dungeon
 * 5- The program ends when the user's hero dies
 * 
 * 
 * 
 */

/*
 * 
 * Program Header
 * 
 * Program Made 
 * By
 * William Adam-Grenier @ william.a-g@hotmail.com
 * Étienne Bérubé @ neti97@hotmail.com
 * Cedrik Dubois @ dubois98@gmail.com
 * Steven (Add last name here. Sorry Steven :/ ) @ yourEmailAddress@here.com
 * 
 * Version: 2.0
 * 
 * 
 * 
 * Requirements
 * By
 * Cédrik Dubois
 * 
 * 
 * Design
 * By
 * Étienne Bérubé
 * 
 * 
 * 
 * 
 * Implementtation
 * By
 * Steven
 * 
 * 
 * 
 * 
 * Debugging 
 * By
 * William Adam-Grenier
 * 
 */


/* Header
 * 
 * The Test class was Made
 * By
 * 
 * William Adam-Grenier
 * 
 * 
 */


public class Test {

	static Scanner input = new Scanner(System.in);  //This is for the input. It is static so it can be used by every methods in this class
	static Hero userHeros;  //This initializes the hero of the user
	static Map dungeonMap;  //This initializes the map of the game
	
	//UPDATE UML!!!!
	static EnemyCharacter enemyToFight;  //This initializes the enemy for the game
	
  
	
	
	
	
	public static void main(String[] args) {
		
		//pressEnterToContinue(); Works but crashes if anything is entered except from a direct 'Enter' //Fixed
		
		characterCreationType(); //DONE
		mapCreation(); //Done
		gameRules(); //Done
		pressEnterToContinue();
		
		 
		
		//Core of game begins here
		while(isTheEndOfDungeon() == false){
		printMap();  //Done
		move();  //Done
		fight();  //Done
		}
		
		biscuitMessage();
		
		
		//Core of game ends here
		

	}
	
	
	
	
	/*
	 * 
	 * 
	 * 
	 * This comment is just to help me visualize the blocks
	 * It has no purpose
	 * 
	 * 
	 * 
	 */
	
	
	
	
	//Beginning of the method block related to the character creation

	
	//This method is for selecting the type of hero the user wants
	public static void characterCreationType(){
		System.out.println("What type of hero do you wish to be?\n1- Warrior\n2- Sorcerer\n3- Archer\n4- Thief");
		char userChoiceChar;
		
		do{
			
		String userChoiceString = input.nextLine();
		
		//In case the user simply presses enter it catches the error and prevents the program from crashing
		if(userChoiceString.length() == 0){
			System.out.println("\nPlease Enter Something!\n");
			userChoiceChar = '7';
		}
		
		else{
		userChoiceChar = userChoiceString.charAt(0);
		
		if(userChoiceChar == '1'){
			characterCreationName("Warrior", 120, 10, 7, 3, 5);
			/*
			 * HP of 120
			 * DEFENCE of 35
			 * 
			 */
		}
		
		else if(userChoiceChar == '2'){
			characterCreationName("Wizard", 80, 5, 10, 4, 6);
			/*
			 * HP of 90
			 * DEFENCE of 50
			 */
		}
		
		else if(userChoiceChar == '3'){
			characterCreationName("Archer", 100, 7, 7, 5, 6);
			/*
			 * HP of 100
			 * DEFENCE of 40
			 */
		}
		
		else if(userChoiceChar == '4'){
			characterCreationName("Thief", 90, 4, 6, 10, 5);
			/*
			 * HP of 95
			 * DEFENCE of 45
			 */
		}
		
		else
			System.out.println("\nInvalid input.\nEnter 1 for Warrior\nEnter 2 for Sorcerer\nEnter 3 for Archer\nEnter 4 for Thief");
		
		}
		
		}while(isOK(userChoiceChar) != true);
		
	}
	
	
	
	//This method is for the user to enter a name for his hero
    public static void characterCreationName(String typeOfHero, int HP, int defense, int attack, int speed, int healing){
		System.out.println("\nEnter a name for your Hero: ");
		String userEnterName = input.nextLine();
		
		characterCreationSex(typeOfHero, userEnterName, HP, defense, attack, speed, healing);
		
		
		
	}
	
    
    
	//This method is for selecting the character's sex
	public static void characterCreationSex(String typeOfHero, String name, int HP, int defense, int attack, int speed, int healing){
		char userChoiceSexChar;
		
		do{
		System.out.println("\nWhat is your character's sex?\n1- Male\n2- Female\n3- Animal\n4- Unspecified");
		String userSexChoiceString = input.nextLine();
		
		//In case the user simply presses enter it catches the error and prevents the program from crashing
		if(userSexChoiceString.length() == 0){
			System.out.println("\nPlease Enter Something!\n");
			userChoiceSexChar = '7';
		}
		
		else{
		userChoiceSexChar = userSexChoiceString.charAt(0);
		
		if(userChoiceSexChar == '1'){
			characterCreationFinal(typeOfHero, name, HP, defense, "Male", attack, speed, healing);
		}
		
		else if(userChoiceSexChar == '2'){
			characterCreationFinal(typeOfHero, name, HP, defense, "Female", attack, speed, healing);
		}
		
		else if(userChoiceSexChar == '3'){
			characterCreationFinal(typeOfHero, name, HP, defense, "Animal", attack, speed, healing);
		}
		
		else if(userChoiceSexChar == '4'){
			characterCreationFinal(typeOfHero, name, HP, defense, "Unspicified", attack, speed, healing);
		}
		
		else
			System.out.println("\nInvalid input.\nEnter 1 for Male\nEnter 2 for Female\nEnter 3 for Animal\nEnter 4 for Unspecified");
			
		}
		
		}while(isOK(userChoiceSexChar) != true);
		
				
	}
	
	
	
	//This method creates the hero with the right variables
    public static void characterCreationFinal(String typeOfHero, String name, int HP, int defense, String sex, int attack, int speed, int healing){
		
    	//Creates the hero object
			userHeros = new Hero(name, sex, typeOfHero, HP, defense, attack, speed, healing);
		
	}
    
	
	//End of methods block related to character creation
	
	
    
    
	/*
	 * 
	 * 
	 * 
	 * This comment is just to help me visualize the blocks
	 * It has no purpose
	 * 
	 * 
	 * 
	 */
	
    
    
	
	//Beginning block of methods related to the map
	
    
	//This method creates the map and sets the number of enemies inside the map
	public static void mapCreation(){
		char userChoiceChar;
		
		do{
			
		System.out.println("\nWhat difficulty do you wish to play?\n1- Easy (10 enemies)\n2- Medium (20 enemies)\n3- Hard (35 enemies)\n4- Very Hard (55 enemies)");
		String userChoiceString = input.nextLine();
		
		//In case the user simply presses enter it catches the error and prevents the program from crashing
		if(userChoiceString.length() == 0){
			System.out.println("\nPlease Enter Something!\n");
			userChoiceChar = '7';
		}
		
		else{
		userChoiceChar = userChoiceString.charAt(0);
		
		if(userChoiceChar > '4' || userChoiceChar < '1')
			System.out.println("\nInvalid input.\nEnter 1 for Easy (10 enemies)\nEnter 2 for Medium (20 enemies)\nEnter 3 for Hard (35 enemies)\nEnter 4 for Very Hard (55 enemies)");
		}
		
		}while(isOK(userChoiceChar) != true);
		
		if(userChoiceChar == '1')
			dungeonMap = new Map(9);
		
		else if(userChoiceChar == '2')
			dungeonMap = new Map(19);
		
		else if(userChoiceChar == '3')
			dungeonMap = new Map(34);
		
		else if(userChoiceChar == '4')
			dungeonMap = new Map(54);

		
		
	}
	
	
	//This method is used to print the map on the Terminal
    public static void printMap(){
		
		//This loop is used for clearing the screen of previous messages/actions
		for(int i = 0; i < 10; i++)
			System.out.println();
		
		dungeonMap.printMapArray();
	}
		
	
	//End of the method block related to the map creation
    
	
    
    
	/*
	 * 
	 * 
	 * 
	 * This comment is just to help me visualize the blocks
	 * It has no purpose
	 * 
	 * 
	 * 
	 */
	
    
    
	
	//Beginning block of methods related to gameplay mechanics
    
    
    
	//This method is for healing the hero
	public static void healingPotion(){
		
		//Looks if the user still has any potions
		if(userHeros.getNumOfPotions() > 0){
			
			//Decrease the number of potions
			userHeros.setHealingPotions();
			
			//Calculates the amount of hp tp restore
			userHeros.healing((userHeros.getHealing() * 10));
			
			System.out.println("\n" + userHeros.getName() + " now has " + userHeros.getHP() + " points of life." 
			+ "\n" + userHeros.getName() + " has " + userHeros.getNumOfPotions() + " potions left.\n");
			
			
		}
		
		else
			System.out.println("\n" + userHeros.getName() + " does not have any potion left.");
	}
	
	
	//This method is for when the user attacks
	public static void attack(){
		
		//Calculates the amount of damage from the user
		int damage = (int) (Math.random() * userHeros.getAttack() + (userHeros.getSpeed() * 1.5));
		System.out.println("\n" + userHeros.getName() + " has done " + damage + " points of damage to the " + enemyToFight.getName() + ".\n");
		
		//Sets the new amount of life to the enemy
		enemyToFight.setHealth(damage);
	}
	
	
	//This method is for when the user defense
	public static void defense(){
		//Increases the amount of defense of the hero
		userHeros.setDefense((userHeros.getDefense() + 4));
		System.out.println("\n" + userHeros.getName() + " has increased his defense.\n");
		
	}
	
	
	
	//This method is for moving around the map
    public static void move(){
		//The keys WASD are used to move around the dungeon
		

		String userMoveInputString;
		char userMoveInputChar;
		
		do{
			
			System.out.println("\nWhere does your heart desire to go?\n");
			userMoveInputString = input.nextLine();
			
			//In case the user simply presses enter it catches the error and prevents the program from crashing
			if(userMoveInputString.length() == 0){
				System.out.println("\nPlease Enter Something!\n");
				userMoveInputChar = '7';
			}
			
			//If the user enters something
			else
			userMoveInputChar = userMoveInputString.toUpperCase().charAt(0);
		
		}while(canGoThere(userMoveInputChar) == false); //Breaks the loop if the user enters a valid key to move
		
		
	}
	
	
    //This method is used to create a random enemy
	public static void generateEnemy(){
		
		//Creates a new object every time so the program does not point back to an already defeated enemy
		Enemies enemiesObjectRandom = new Enemies();//Creates a new the object for the enemies
		enemyToFight = enemiesObjectRandom.getRandomEnemy();
	}
	
	
	//This method is used for the fight mechanic it calls the methods attack, defense & healingPotion for the action the user chooses
    public static void fight(){
    	
    	//Takes the hero's current location
		int heroPositionInX = dungeonMap.mapArray[0][0].getHeroPositionX();
		int heroPositionInY = dungeonMap.mapArray[0][0].getHeroPositionY();
		
		
		//Checks if there is an enemy at the current position. If yes, combat begins.
		if(dungeonMap.mapArray[heroPositionInX][heroPositionInY].getIsEnemy()){
			//Combat Begins here
			
			//Generates a new Enemy
			generateEnemy();
			char userActionFightChar;
			
			System.out.println("\nYou have encountered a dangereous " + enemyToFight.getName() + ".\nPrepare to fight!");
			
			//First loop is for the game to know when to end the battle
			while(enemyToFight.getHealth() > 0 && userHeros.getHP() > 0){
				pressEnterToContinue();
				//Second loop is for the user to enter a correct input
				do{
					
					/*
					 * 
					 * 1- Attack
					 * 2- Defense
					 * 3- Heal
					 * 4- Look
					 * 
					 */
					
					System.out.println("\nHow do you wish to proceed?\n1- Attack\n2- Defense\n3- Heal\n4- Look\n");
					
					String userActionFightString = input.nextLine();
					
					//In case the user simply presses enter it catches the error and prevents the program from crashing
					if(userActionFightString.length() == 0){
						System.out.println("\nPlease Enter Something!\n");
						userActionFightChar = '7';
					}
					
					//If the string is not empty the program goes here
					else{
					
					userActionFightChar = userActionFightString.charAt(0);
					
					
					if(userActionFightChar == '1')  //attack
						attack();
					
					else if(userActionFightChar == '2')  //defense
						defense();
					
					else if(userActionFightChar == '3')  //heal
						healingPotion();
					
					else if(userActionFightChar == '4')  //Look
						System.out.println("\n" + userHeros.getName() + " gently looked at the " 
					+ enemyToFight.getName() + ".\nIt does nothing.\n");
					
					else
						System.out.println("\nInvalid input.\nEnter 1 to Attack\nEnter 2 for Defense\nEnter 3 for Potions\nEnter 4 to Look");
					
					}
					
				}while(isOK(userActionFightChar) != true); //end of second loop
				

			
				
				pressEnterToContinue();
				
				//Checks if the enemy still has hp
				if(enemyToFight.getHealth() > 0){
					
				//This is the enemy turn to attack
					
				//Generates a hit damage 	
				int damage = (int) (Math.random() * enemyToFight.getAttack() - (userHeros.getDefense() / 2));
				
				//In case where the defense is too high the hit will not give back life
				if(damage < 0)
					damage = 0;
				
				System.out.println(enemyToFight.getName() + " has done " + damage + " points of damage to " 
				+ userHeros.getName() + ".\n");
				
				
				pressEnterToContinue();
				
				//Sets the hero's amount of hp after the hit
				userHeros.setHPAfterHit(damage);
				
				
				combatStatus();
				
				
				
				}
				
				//To set the defense of the hero back to its initial value
				userHeros.setBaseDefense();
				
				
			}//End of first loop
			
			//Normal case where the enemy is defeated. Goes back to the map
			if(enemyToFight.getHealth() <= 0)
			System.out.println("\n" + userHeros.getName() + " has defeated " + enemyToFight.getName() + ".\n");
			
			//In case where the hero dies, the game ends here
			else if (userHeros.getHP() <= 0){
				System.out.println("\n" + enemyToFight.getName() + " has defeated " + userHeros.getName() + ".\n");
				
				//Prints the game over message to meet the requirements
				gameOverMessage();
				
				//Program exits
				System.exit(1);
			}
			
			//This is called when the combat is over
			combatOver(heroPositionInX, heroPositionInY);
			
			
		}
		
		
	}
	

    //This method is used to print how much HP is left to the hero and the enemy
    public static void combatStatus(){
    	//Prints the hero's status
		System.out.println("\n" + userHeros.getName() + " has " + userHeros.getHP() + " points of life left.\n");
		
		//Prints the enemy's status
		System.out.println(enemyToFight.getName() + " has " + enemyToFight.getHealth() + " points of life left.\n");
	}
	
	
	//This method is to put the variable isEnemy to false in the room once combat is over
	public static void combatOver(int heroPositionInX, int heroPositionInY){
		//Removes the enemy from this room
		dungeonMap.mapArray[heroPositionInX][heroPositionInY].removeEnemy();
		
		//Sets the hero's new location
		dungeonMap.mapArray[heroPositionInX][heroPositionInY].setHeroPosition();
		
	}
	
	
	//End block of methods related to gameplay mechanics
	
	
	
	
	/*
	 * 
	 * 
	 * 
	 * This comment is just to help me visualize the blocks
	 * It has no purpose
	 * 
	 * 
	 * 
	 */
		
	
	
	
	//Beginning block of methods related to input verification
	
	
	//This method checks if the input entered is valid
	public static boolean isOK(char i){
		boolean isOK = false;
		
		//Checks if the input is 1, 2, 3 or 4
		if(i == '1' || i == '2' || i == '3' || i == '4')
			isOK = true;
		
		return isOK;
	}
	
	
	//This method is called when the user moves to verify if his input is possible and if the block where he wants to go is possible
	public static boolean canGoThere(char moveTurn){
		
		boolean canGoThere = false;
		
		//No need to be precise where because the variable is static
		int heroPositionInX = dungeonMap.mapArray[0][0].getHeroPositionX();
		int heroPositionInY = dungeonMap.mapArray[0][0].getHeroPositionY();
		
		
			
			
		switch(moveTurn){
		
		//W = UP, so in the array it should be x = x - 1, y = y
		case 'W': 
			
			//Checks if the user can go this new place
			if(dungeonMap.mapArray[heroPositionInX - 1][heroPositionInY].getCanGo()){
				
				//Moves the character to new location
			dungeonMap.mapArray[heroPositionInX - 1][heroPositionInY].setHeroPosition();
			
			//Removes from the map its old location
			dungeonMap.mapArray[heroPositionInX][heroPositionInY].setBlankcell();
			
			//Sets the new position of hero
			dungeonMap.mapArray[heroPositionInX - 1][heroPositionInY].setHeroPositionX(heroPositionInX -1);

			
			canGoThere = true;
			}
			
			else{
				printMap();
				System.out.println("\nSomething blocks your way.\nYou try to move it but it is too heavy.\n");
				
			}
		          break;
			
		
			
			
		//A = LEFT, so in the array it should be i = i, k = k - 1	
		case 'A':  
			
			//Checks if the user can go this new place
			if(dungeonMap.mapArray[heroPositionInX][heroPositionInY - 1].getCanGo()){
				
				//Moves the character to new location
			dungeonMap.mapArray[heroPositionInX][heroPositionInY - 1].setHeroPosition();
			
			//Removes from the map its old location
			dungeonMap.mapArray[heroPositionInX][heroPositionInY].setBlankcell();
			
			//Sets the new position of hero
			dungeonMap.mapArray[heroPositionInX][heroPositionInY].setHeroPositionY(heroPositionInY - 1);
			
			canGoThere = true;
			}
			
			else{
				
				printMap();
				System.out.println("\nSomething blocks your way.\nYou try to move it but it is too heavy.\n");
				
			}
			
			break;
			
		
			
			
		//S = DOWN, so in the array it should be i = i + 1, k = k	
		case 'S':
			
			//Checks if the user can go this new place
			if(dungeonMap.mapArray[heroPositionInX + 1][heroPositionInY].getCanGo()){
				
				//Moves the character to new location
			dungeonMap.mapArray[heroPositionInX + 1][heroPositionInY].setHeroPosition();
			
			//Removes from the map its old location
			dungeonMap.mapArray[heroPositionInX][heroPositionInY].setBlankcell();
			
			//Sets the new position of hero
			dungeonMap.mapArray[heroPositionInX][heroPositionInY].setHeroPositionX(heroPositionInX + 1);
			
			
			canGoThere = true;
			}
			
			else{
				printMap();
				System.out.println("\nSomething blocks your way.\nYou try to move it but it is too heavy.\n");
				
			}
			
			break;
			
			
		
			
			
		//D = RIGHT, so in the array it should be i = i, k = k + 1	
		case 'D': 
			
			//Checks if the user can go this new place
			if(dungeonMap.mapArray[heroPositionInX][heroPositionInY + 1].getCanGo()){
				
				//Moves the character to new location
			dungeonMap.mapArray[heroPositionInX][heroPositionInY + 1].setHeroPosition();
			
			//Removes from the map its old location
			dungeonMap.mapArray[heroPositionInX][heroPositionInY].setBlankcell();
			
			//Sets the new position of hero
			dungeonMap.mapArray[heroPositionInX][heroPositionInY].setHeroPositionY(heroPositionInY + 1);
			
			canGoThere = true;
			}
			
			else{
				printMap();
				System.out.println("\nSomething blocks your way.\nYou try to move it but it is too heavy.\n");
			}
			
			break;
			
			
		
			
		default: 
			printMap();
			System.out.println("\nEnter a valid key.\n");
		         break;
		         
		
		
		
		
		}
		
		return canGoThere;
	}
	
	
	//This method is for the user to press enter so the computer goes to the next printing
	public static void pressEnterToContinue(){
		
		System.out.println("\nPress Enter to continue...\n");
		String dummyVariableString = input.nextLine();

	}
	
	
	//This method is for the user to press enter so the computer goes to the next printing
	public static boolean isTheEndOfDungeon(){
		
		 //Takes the current position of the hero
		int heroPositionInX = dungeonMap.mapArray[0][0].getHeroPositionX();
		int heroPositionInY = dungeonMap.mapArray[0][0].getHeroPositionY();
		
		//Returns if the hero's current location is the same as the ending one
		return dungeonMap.mapArray[heroPositionInX][heroPositionInY].getIsEnd();
	}
	
	
	//End of methods block related to input verification
	
	
	
	
	
	/*
	 * 
	 * 
	 * 
	 * This comment is just to help me visualize the blocks
	 * It has no purpose
	 * 
	 * 
	 * 
	 */
	
	
	
	
	//Beginning of the method block related to printing rules and end game messages
	
	
	//This method is used to print the rules to the user's Terminal
    public static void gameRules(){
		System.out.println("\nYou start with 3 healing potions.\nYou will encounter enemies throughout the dungeon.\nYou must defeat them in order to progress.\nYou are \\0/.\nThe ending is {0}. " 
	+ "\nThe game ends when you die or complete the dungeon.\n\nUse 'W' to go up.\nUse 'A' to go left.\nUse 'S' to go down.\nUse 'D' to go right.");
	}
	
	
    //This method is used when the hero dies and prints the game over message
	public static void gameOverMessage(){
		for(int i = 0; i < 10; i++)
			System.out.println();
		System.out.println(userHeros.getName() + " was defeated.\nGAME OVER");
	}
	
	
	//This method is used when the hero reaches the end of the dungeon
	public static void biscuitMessage(){
		for(int i = 0; i < 10; i++)
			System.out.println();
		System.out.println("CONGRATULATION!" + userHeros.getName() + " COMPLETED THE DUNGEON!\nHAVE A COOKIE");
	}

	
	//End of the method block related to printing rules and end game messages
	
	
}
