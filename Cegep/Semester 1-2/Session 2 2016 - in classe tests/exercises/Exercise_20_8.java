package exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Exercise_20_8 {

	public static void main(String[] args) {
	
			int lottery =(int)(Math.random()*1000);
			System.out.println(lottery);
			Scanner input=new Scanner (System.in);
			System.out.println("Enter a guess(3digits):");
			int guess=input.nextInt();
			
			int lottery1 = lottery / 100;
		    int lottery2 = (lottery % 100) / 10;
		    int lottery3 = lottery % 10;
		    
		    int guess1 = guess / 100;
		    int guess2 = (guess % 100) / 10;
		    int guess3 = guess % 10;
		    
		    List<Integer> listLottery=new ArrayList<>();
		    
		    listLottery.add(lottery1);
		    listLottery.add(lottery2);
		    listLottery.add(lottery3);
		    Collections.sort(listLottery);
		    
		    List<Integer> listGuess=new ArrayList<>();
		    
		    listGuess.add(guess1);
		    listGuess.add(guess2);
		    listGuess.add(guess3);
		    Collections.sort(listGuess);
		    
		    if(guess==lottery){
		    	System.out.println("Perfect guess");
		    }
		    else if(listLottery.equals(listGuess)){
		    	System.out.println("3 match");
		    }
		    else if(listLottery.containsAll(listGuess.subList(0, 2)) || listLottery.containsAll(listGuess.subList(1, 3))){
		    	System.out.println("2 match");
		    }
		    else if(listLottery.contains(guess1) ||listLottery.contains(guess2) ||listLottery.contains(guess3) ){
		    	System.out.println("1 match");
		    }
		    else
		    	System.out.println("No match");
		}

	}


