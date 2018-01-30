package game;

import java.util.Scanner;
import java.util.Queue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;

public class TestGame {

	static DeckOfCard deck = new DeckOfCard();
	static Scanner input = new Scanner(System.in);
	static Player yourCharacter;
	static Player[] opponents; 
	
	public static void main(String[] args) {
		//test();
		//game();
		initializeOpponents();
	}
	
	public static void test(){
		System.out.println(deck.getNumOfCards());
		
		deck.printCompleteDeck();
		
		deck.shuffleDeck();
		
		System.out.println();
		System.out.println();
		
		deck.printCompleteDeck();
	}
	
	
	public static void game(){
		createCharacter();
		initializeOpponents();
	}
	
	public static void createCharacter(){
		
		System.out.println("Hello sir, Welcome to the Casino. How may I call you?\nEnter your name: ");
		String name = input.next();
		
		System.out.println("Enter your gender(M/F): ");
		String gender ="" + input.next().toUpperCase().charAt(0);
		
		if(gender.equals("F"))
			System.out.println("Oh sorry ma'am... you looked... Nevermind!");
		
		System.out.println("Just being sur... How old are you?");
		
		System.out.println("Enter your age: ");
		byte age = input.nextByte();
		
		if(age < 18){
			System.out.println("You are not allowed to be here young man! Go away!");
			System.exit(0);
		}else
			System.out.println(name + "! You can follow me");
		
		System.out.println("Oh! I can see you brought some money! how much? oh 200$! You'll have enough to have some fun!");
		int account = 200;
		
		yourCharacter = new Player(name, gender,age,account);
		
	}


	public static void initializeOpponents(){
		System.out.println("So you have different tables ranging from 2 to 6 opponents per table. How much do you want to play against?");
		System.out.println("Enter the number of opponents you want from 2 to 6: ");
		
		boolean isOk = false;
		int numOfEnemies=0; 
		
		do{
			isOk=false;
			
			try{
				numOfEnemies= numericalIntTry();
				
				if((numOfEnemies>=2 && numOfEnemies<=6))
					isOk = true;
				else
					System.out.println("Nope, not good ammount...between 2 and 6");
				
			}catch(Exception ex){
			System.out.println("Hmmmm that does not look like a legit number... Try again");
			}
		
		}while(!(isOk));
		
		System.out.println("out");
		
		opponents = new Player[numOfEnemies];//initialize array with number of opponents.
		
		File opponentsFile = new File("C:/Users/Étienne Bérubé/Documents/Java/Texas HoldEm/src/playersTemplate.txt");
		Scanner fileInput = null;
		System.out.println(opponentsFile.exists());//debugging
		
		try {
			fileInput = new Scanner(opponentsFile);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		
		for(int i = 0; i < opponents.length;i++){
			int j = (int)(Math.random()*8);
			System.out.println(j);
			while(fileInput.hasNext()){
				System.out.println("in");
				fileInput.nextLine();
				String index = fileInput.next();
				
				if(index.equals(j+"*")){
					System.out.println("in2");
					String tempName= fileInput.next();
					byte tempAge = Byte.parseByte(fileInput.next());
					String tempGender = fileInput.next();
					int tempAccount = Integer.parseInt(fileInput.next());
					
					opponents[i] = new Player(tempName, tempGender, tempAge, tempAccount);
				}
			
			}
		}
		
		for(int i=0; i < opponents.length; i++){
			System.out.println(opponents[i].toString());
		}
		
		System.out.println("Here is you table sir!");
		
		
	}
	
	public static int numericalIntTry() throws Exception{
		int num;
		try{
			num =input.nextInt();
			return num;
		}catch(Exception ex){
			throw new Exception("Bad numerical value");
		}
	}
	
}
