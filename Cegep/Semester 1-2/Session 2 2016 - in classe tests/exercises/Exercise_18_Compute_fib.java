package exercises;

import java.util.Scanner;

public class Exercise_18_Compute_fib {
static int timeCalled = 0;
		
	public static void main(String[] args) {
		/** Main method */
		// Create a Scanner
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an index for a Fibonacci number: ");
		int index = input.nextInt();
		
		// Find and display the Fibonacci number
		System.out.println("The Fibonacci number at index "
		+ index + " is " + fib(index));
		}
	
		/** The method for finding the Fibonacci number */
		public static long fib(long index) {
		 if (index == 0) // Base case
		 return 0;
		
		
		else if (index == 1) // Base case
		return 1;
		
		else{ // Reduction and recursive calls
			long popo = fib(index - 1) + fib(index - 2);
			timeCalled++;
			System.out.println(timeCalled);
			return popo;
		}
		}

	}


