package exercise_chap6;

import java.util.*;

public class exercise_6_7 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double initial;
		double interestRate;
		double monthlyInterestRate;
		int numberOfYears;
		double finalInvestementValue;
		
		
		System.out.print("Enter the initial ammount: ");
		initial = input.nextDouble();
		
		System.out.print("Enter the annual interest rate: ");
		interestRate = input.nextDouble();
		monthlyInterestRate = interestRate / 1200;
		
		System.out.print("Enter the number of years: ");
		numberOfYears = input.nextInt();
		
		finalInvestementValue = futureInvestementValue(initial, monthlyInterestRate, numberOfYears);
		System.out.printf("%-10.2f\n",finalInvestementValue);
		
		printTableOfInvestement(initial, monthlyInterestRate, numberOfYears);
		
		input.close();

	}
	public static double futureInvestementValue(double investementAmount, double monthlyInterestRate, int Years ){
		double value = 0;
		
		value = investementAmount * Math.pow((1 + monthlyInterestRate), (Years * 12));
		return value;
	}
	public static void printTableOfInvestement(double investementAmount, double monthlyInterestRate, int Years ){
		int i = 1; 
		double value = 0;
		System.out.printf("%-20s%-20s\n","Years", "Futur value");
		
		while (i <= Years){
			value = investementAmount * Math.pow((1 + monthlyInterestRate), (i * 12));
			System.out.printf("%-20d%-20.2f\n",i, value);
			i++;
		}
	}
}
