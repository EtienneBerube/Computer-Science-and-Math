package game;

/* Header
 * 
 * The Hero class was made 
 * By
 * 
 * William Adam-Grenier 
 * 
 * & 
 * 
 * Étienne Bérubé
 * 
 * 
 */

/* Class Description
 * 
 * This class is for creating the user's Hero
 * It creates a character that will move around the map and fight enemies 
 * 
 */


public class Hero {
	
	private String name;  //Name of the hero (chose by user in main)
	private String sex;  //Sex of the hero (chose by user in main)
	private String typeOfHero;  //Type of the hero (chose by user in main)
	private int hp;  //Amount of life points of this class (Depends on the type of hero chose. See requirements for details)
	private int baseHP; //Added this variable for the potions (read changelog). This varaible is for restoring health so it does not go over the max health of a class
	private int defence;  //Defense points of a type of hero (Depends on the type of hero chose. See requirements for details)
	
	private int numOfPotions = 3;  //The maximum number of potions for a hero
	private int attack;  //Attack points of a type of hero (Depends on the type of hero chose. See requirements for details)
	private int speed;  //Speed points of a type of hero (Depends on the type of hero chose. See requirements for details)
	private int healing;  //Healing points of a type of hero (Depends on the type of hero chose. See requirements for details)
	private int baseDefense; //Added this variable to be able to return to the base value of defense
	
	
	//Constructor of the Hero class. Take a string for name, sex and typeOfHero. Takes integers for the hp, defense, attack, speed and healing. Created in main class
	public Hero(String name, String sex, String typeOfHero, int hp, int defense, int attack, int speed, int healing){
		this.name = name;
		this.sex = sex;
		this.typeOfHero = typeOfHero;
		this.hp = hp;
		this.defence = defense;
		baseHP = this.hp;
		this.attack = attack;
		this.speed = speed;
		this.healing = healing;
		baseDefense = defense;
		
	}
	
	//Removed the method setHP(int hp) because it was not used anywhere so update UML
	

	//This method is to set the hero's new amount of hp after a hit
	public void setHPAfterHit(int damage){
		this.hp -= damage; 
	}
	
	//This returns the amount of HP left of the hero
	public int getHP(){
		return hp;
	}
	
	//This method is used to set the hero's amount of defense points in combat
	public void setDefense(int defense){
		this.defence = defense;
	}
	
	//This method returns the amount of defense points of the hero
	public int getDefense(){
		return defence;
	}
	
	//This method is used in combat to restore health to hero
	public void healing(int potionHealing){
		
		//To prevent the user to have more hp than its default type allows
		if((hp + potionHealing) <= baseHP)
		hp += potionHealing; 
		
		//if the potions restores more hp than max amount allowed hp goes back to default value
		else
			hp = baseHP;
	}
	
	
	//This method decreases the amount of potions available after each use
	public void setHealingPotions(){
		numOfPotions--;
	}
	
	//This method returns the name of hero in a string
	public String getName(){
		return name;
	}
	
	//This method returns the sex of hero in a String
	public String getSex(){
		return sex;
	}
	
	//This method returns the type of hero in a string
	public String getTypeOfHero(){
		return typeOfHero;
	}
	
	//This method returns the integer of the healing variable
	public int getHealing(){
		return healing;
	}
	
	//This method returns the integer of the attack variable
	public int getAttack(){
		return attack;
	}
	
	//This method returns the integer of the speed variable
	public int getSpeed(){
		return speed;
	}
	
	//This method return the amount of potions left
	public int getNumOfPotions(){
		return numOfPotions;
	}
	
	//This method resets the base points for defense
	public void setBaseDefense(){
		defence = baseDefense;
	}
	
	//End of new methods not included in original UML.
	

}
