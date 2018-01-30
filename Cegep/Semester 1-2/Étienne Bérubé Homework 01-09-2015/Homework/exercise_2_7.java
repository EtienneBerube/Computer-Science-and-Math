package Homework;

import java.util.*;

public class exercise_2_7 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		long minutes;
		double year;
		long day;
		
		System.out.print("Enter the quatity of minutes ");
		minutes = input.nextLong();
		year = (minutes / 60 / 24 / 365);
		day = (minutes /60 / 24 % 365);
		System.out.println("there is " + year +" years and " + day + " days in " + minutes + " minutes");
	}

}
