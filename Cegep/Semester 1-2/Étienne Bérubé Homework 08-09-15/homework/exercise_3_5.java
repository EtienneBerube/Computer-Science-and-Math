package homework;

import java.util.*;

public class exercise_3_5
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int day;
		int numberDays;
		int futurDay;
		
		System.out.print("Entert the number that represents today's day (eg. 1 = sunday, 2 = monday): ");
		day = input.nextInt();
		
		if (day < 1)
			System.out.print("You are dum");
		
		else 
		{
			if (day > 7)
				System.out.print("You are dum");
			else {
				System.out.print("Entert the number of days that passes: ");
				numberDays = input.nextInt();
		
				futurDay = (day + numberDays) % 7;
		
				if (futurDay == 1)
					System.out.print("It will be a Sunday");
				else if (futurDay == 2)
					System.out.print("It will be a Monday");
				else if (futurDay == 3)
					System.out.print("It will be a Tuesday");
				else if (futurDay == 4)
					System.out.print("It will be a Wednesday");
				else if (futurDay == 5)
					System.out.print("It will be a Thursday");
				else if (futurDay == 6)
					System.out.print("It will be a Friday");
				else if (futurDay == 7)
					System.out.print("It will be a Sunday");
			}
		}
	}

}
