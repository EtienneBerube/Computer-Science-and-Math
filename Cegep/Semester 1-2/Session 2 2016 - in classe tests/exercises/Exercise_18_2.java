package exercises;

import java.util.Scanner;

public class Exercise_18_2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number (index): ");
		int n = input.nextInt();
		int currentFib=0;
		int f0 =0;
		int f1 = 1;
		
		
		for (int i = 1; i < n;i++){ // mistake in book... is < and not <=
			currentFib = f1+f0;
			f0 = f1;
			f1 = currentFib;
					
		}
		
		System.out.println(currentFib);

	}

}
