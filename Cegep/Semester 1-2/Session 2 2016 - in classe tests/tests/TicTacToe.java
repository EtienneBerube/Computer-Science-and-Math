package tests;

import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		boolean win = false;
		String[][] ticTacGrid ={
				{"7","8","9"},
				{"4","5","6"},
				{"1","2","3"}
		};
		
		String[][] template ={
				{"7","8","9"},
				{"4","5","6"},
				{"1","2","3"}
		};
	
		printGrid(ticTacGrid);
		for(int i = 0; i< 5; i++){
			
			playX(ticTacGrid,template);
			win = check(ticTacGrid, "X",win);
			if (win){
				printGrid(ticTacGrid);
				break;
			}
			printGrid(ticTacGrid);
			playO(ticTacGrid,template);
			win = check(ticTacGrid, "O",win);
			if (win){
				printGrid(ticTacGrid);
				break;
			}
			printGrid(ticTacGrid);
		
		}
		System.out.println("Nobody won :)"); 
	}


	static void printGrid(String[][] x){
		System.out.println("-------------");
		System.out.println("| " + x[0][0]+ " | " +x[0][1] + " | "+x[0][2] + " | ");
		System.out.println("-------------");
		System.out.println("| " + x[1][0]+ " | " +x[1][1] + " | "+x[1][2] + " |");
		System.out.println("-------------");
		System.out.println("| " + x[2][0]+ " | " +x[2][1] + " | "+x[2][2] + " |");
		System.out.println("-------------");
	}
	
	static void playX(String[][] x, String[][] temp){
		Scanner input = new Scanner(System.in);
		boolean isValid;
		
		do{
		isValid = false;
		System.out.print("Please enter the position to play (X): ");
		String choice = input.next();
		
		while(!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") && !choice.equals("5") && !choice.equals("6") && !choice.equals("7") && !choice.equals("8") && !choice.equals("9")){
			System.out.print("Wrong input, try again: ");
			choice = input.next();
		}
		
		
		
		for(int i = 0; i < temp.length; i++ ){
			for (int j = 0; j < temp[i].length;j++){
				if (temp[i][j].equals(choice)){
					if(x[i][j].equals("X") || x[i][j].equals("O")){
						System.out.println("This space is already used");
						isValid = true;
						
					}else{
						x[i][j] = "X";
						break;
					}
				}
			}
		}
		}while(isValid);
		
	}
	
	static void playO(String[][] x, String[][] temp){
		Scanner input = new Scanner(System.in);
		boolean isValid;
		
		do{
		isValid = false;	
		System.out.print("Please enter the position to play(O): ");
		String choice = input.next();
		
		while(!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") && !choice.equals("5") && !choice.equals("6") && !choice.equals("7") && !choice.equals("8") && !choice.equals("9")){
			System.out.print("Wrong input, try again: ");
			choice = input.next();
		}
		
		
		
		for(int i = 0; i < temp.length; i++ ){
			for (int j = 0; j < temp[i].length;j++){
				if (temp[i][j].equals(choice)){
					if(x[i][j].equals("X") || x[i][j].equals("O")){
						System.out.println("This space is already used");
						isValid = true;
						
					}else{
						x[i][j] = "O";
						break;
					}
				}
			}
		}
		}while(isValid);
		
	}
	
	static boolean check(String[][] x, String play, boolean win){
		if(x[0][0].equals(play) && x[1][1].equals(play) && x[2][2].equals(play)){
			win = true;
		}else if (x[0][2].equals(play) && x[1][1].equals(play) && x[2][0].equals(play)){
			win = true;
		}
		
		for(int i =0; i<x.length; i++){
			if(x[i][0].equals(play) && x[i][1].equals(play) && x[i][2].equals(play)){
				win = true;
				break;
			}
		}
		
		for (int j =0; j< x[0].length; j++){
				if(x[0][j].equals(play) && x[1][j].equals(play) && x[2][j].equals(play)){
					win = true;
					break;
				}

		}
	if (win){
		System.out.println("The winner is " + play);
	}
	return win;
	}

}
