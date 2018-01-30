package exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Exercise_20_3 {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
	
		String[][] statecapital = {
				{"Alabama", "Montgomery"},
				{"Alaska", "Juneau"},
				{"Arizona", "Phoenix"},
				{"Arkansas", "Little Rock"},
				{"California", "Sacramento"},
				{"Colorado", "Denver"},
				{"Connecticut", "Hartford"},
				{"Delaware", "Dover"},
				{"Florida", "Tallahassee"},
				{"Georgia", "Atlanta"},
				{"Hawaii", "Honolulu"},
				{"Idaho", "Boise"},
				{"Illinois", "Springfield"},
				{"Maryland", "Annapolis"},
				{"Minnesota", "Saint Paul"},
				{"Iowa", "Des Moines"},
				{"Maine", "Augusta"},
				{"Kentucky", "Frankfort"},
				{"Indiana", "Indianapolis"},
				{"Kansas", "Topeka"},
				{"Louisiana", "Baton Rouge"},
				{"Oregon", "Salem"},
				{"Oklahoma", "Oklahoma City"},
				{"Ohio", "Columbus"},
				{"North Dakota", "Bismark"},
				{"New York", "Albany"},
				{"New Mexico", "Santa Fe"},
				{"New Jersey", "Trenton"},
				{"New Hampshire", "Concord"},
				{"Nevada", "Carson City"},
				{"Nebraska", "Lincoln"},
				{"Montana", "Helena"},
				{"Missouri", "Jefferson City"},
				{"Mississippi", "Jackson"},
				{"Massachusettes", "Boston"},
				{"Michigan", "Lansing"},
				{"Pennslyvania", "Harrisburg"},
				{"Rhode Island", "Providence"},
				{"South Carolina", "Columbia"},
				{"South Dakota", "Pierre"},
				{"Tennessee", "Nashville"},
				{"Texas", "Austin"},
				{"Utah", "Salt Lake City"},
				{"Vermont", "Montpelier"},
				{"Virginia", "Richmond"},
				{"Washington", "Olympia"},
				{"West Virginia", "Charleston"},
				{"Wisconsin", "Madison"},
				{"Wyoming", "Cheyenne"}
		};
		List<String[]> list = Arrays.asList(statecapital);
		game(list);

	}
		public static void game(List<String[]> x){
		Collections.shuffle(x);
		boolean isOK = true;
		String UserAnswer;
		String state;
		int index;
		String capital;
		
		while(isOK){
			
			index = (int)(Math.random()*50);
			state = x.get(index)[0];
			capital = x.get(index)[1];
			
			System.out.println("What is the capital of: " + state);
			UserAnswer = input.next();
			
			if(!(UserAnswer.equals(capital))){
				isOK = false;
				System.out.println("You piece of shit");
				
			}
		
		}
		
		}
	}


