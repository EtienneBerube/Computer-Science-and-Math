package exercises;

import java.util.Scanner;
/*
 * O(n)
 */

public class Exercise_22_2 {
	
	private static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter: ");
		String popo = input.next();
		String reconstructedString = "";
		char index = 0000000;
		
		for(int i = 0; i < popo.length(); i++){
			if(index<popo.charAt(i)){
				reconstructedString += popo.charAt(i);
				index=popo.charAt(i);
			}
		}
		System.out.println(reconstructedString);

	}

}
