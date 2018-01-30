package In_Class;

import java.util.*;

/* Étienne Bérubé, 420-201-RE sect. 01880, This programm will read in investement amount, annual interest rate, 
 * and number of years and finally, displays the futur investement value using a given formula.
 */

public class Assignement_1 
{

	public static void main(String[] args) 
	{
		//creating Scanner and declaring variables
		Scanner input = new Scanner(System.in);
		double InitialAmount;
		double AnnualInterest;
		double NumberOfYears;
		double Value;
		
		//starting the input process
		System.out.println("This programs gives the the effect of the annual interest rate for a given time on an initial Amount");
		System.out.println(""); // this serve as "enter" keys
		
		System.out.print("Please enter the initial Amount in CAD$: ");
			InitialAmount = input.nextDouble();
		
		System.out.print("Please enter the annual interest rate in %: ");
			AnnualInterest = input.nextDouble();
		
		System.out.println("Please take note that the interests are compiled monthly"); // note for the user
		
		System.out.print("Please enter the number of years ");
			NumberOfYears = input.nextDouble();
			
			
		//Starting the math
		
		Value = InitialAmount * Math.pow(( 1 + ((AnnualInterest/100)/12)), (NumberOfYears*12));
		
		
		//Final result
		
		System.out.println("The value of " + InitialAmount + "$ with a Annual interest rate of " + AnnualInterest + "% over a period of " + NumberOfYears + " years is " + ((int) (Value*100)) / 100.00 + "$");
			
		// I converted my "double" value to an "int" and after x100 and /100.0 to give a money-like precision

	}

}
