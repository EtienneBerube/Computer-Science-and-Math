package Homework;

import java.util.*;

public class exercise_2_8 
{

	
	public static void main(String[] args) 
	{
		long TotalMilliseconds;
		long TotalSeconds;
		long CurrentSecond;
		long TotalMinutes;
		long CurrentMinute;
		long TotalHours;
		long CurrentHour;
		int TimeZone;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter your GMT time zone: ");
		
		TimeZone = input.nextInt();
		
		TotalMilliseconds = System.currentTimeMillis();
		
		TotalSeconds = TotalMilliseconds / 1000;
		
		CurrentSecond = TotalSeconds % 60;
		
		TotalMinutes = TotalSeconds / 60;
		
		CurrentMinute = TotalMinutes % 60;
		
		TotalHours = (TotalMinutes / 60)  + TimeZone;
		
		CurrentHour = TotalHours % 24;
		
		System.out.print("Current time is " + CurrentHour + ":" + CurrentMinute + ":" + CurrentSecond);

	}

}
