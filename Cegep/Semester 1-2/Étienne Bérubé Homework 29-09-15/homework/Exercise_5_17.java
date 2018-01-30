package homework;

import java.util.*;

public class Exercise_5_17 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int numberOfLine;

		System.out.print("Please enter the number of lines: ");
		numberOfLine = input.nextInt();

		for (int i = 0; i < numberOfLine; i++) { // 

			for (int j = 0; j < (numberOfLine - (i + 1)); j++) {
				System.out.print("  ");
			}

			
			for (int k = 0; k <= i; k++){
				System.out.print(" " + (i-(k-1)));
			}
			
			for (int l = 0 ; l < i; l++){ // there
				System.out.print(" " + (l +2 ));
			}

			System.out.println("");
		}
	}

}
