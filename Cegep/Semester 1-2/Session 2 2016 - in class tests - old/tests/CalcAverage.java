package tests;
import java.util.Scanner;
import tests.Grader;

public class CalcAverage {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("How many kids are there in this shit? :");
		int n = input.nextInt();
		
		double[] shittyShit = new double[n];
		
		for (int i = 0; i<n ;i++){ //fill array
			System.out.print("Enter Score #" + (i+1) + ": ");
			shittyShit[i] = input.nextDouble();
		}
		
		
		Grader grades = new Grader(shittyShit);
		
		System.out.println("The lowest is: " + grades.getLowsetScore(shittyShit));
		
		System.out.println("");
	}

	
}
