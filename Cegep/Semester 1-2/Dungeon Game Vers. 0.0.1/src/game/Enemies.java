package game;

/*
 * 
 * The Enemies class was made 
 * By
 * 
 * Cédrik Dubois
 * 
 * 
 */

/*
 * 
 * This class is to create and return random enemies to the main class of the game
 * 
 * 
 */


public class Enemies {
	
	//An array of EnemyCharacter 
	private static EnemyCharacter[] enemyList = new EnemyCharacter[5];
	
	
	//The no-argument constructor of Enemies fills the enemyList Array
	public Enemies(){
		enemyList[0] = new EnemyCharacter("Pirate", 35, 17);
		enemyList[1] = new EnemyCharacter("Ghost", 20, 14);
		enemyList[2] = new EnemyCharacter("Kangaroo", 25, 7);
		enemyList[3] = new EnemyCharacter("Slug", 15, 10);
		enemyList[4] = new EnemyCharacter("Living Rock", 40, 10);
	}
	
	//This method returns a random enemy in the enemyList Array
	public static EnemyCharacter getRandomEnemy(){
		return enemyList[(int)(Math.random() * 5)];
	}
	
}
