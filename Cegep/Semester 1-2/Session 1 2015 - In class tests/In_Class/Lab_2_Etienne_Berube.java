package In_Class;

import java.util.*;

public class Lab_2_Etienne_Berube 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		String message;
		
		System.out.print("Please enter the word or the sentence you want to analyse: ");
		message = input.nextLine();
		message = message.toLowerCase();
		
		int a = message.lastIndexOf('a');
		int e = message.lastIndexOf('e');
		int i = message.lastIndexOf('i');
		int o = message.lastIndexOf('o');
		int u = message.lastIndexOf('u');
		
			if (a > 0 || e > 0 || i > 0 || o > 0 ||u > 0)
		{
			if (a > e){
				if (a > i)
				{
					if (a > o)
					{
						if (a > u)
						{
							System.out.println("The last vowel is: a and it's last position is" + a);
						}
					}
				}
			}	
			else if ( e > a){
				if (e > i)
				{
					if (e > o)
					{
						if (e > u)
						{
							System.out.println("The last vowel is: e and it's last position is " + e);
						}
					}
				}
			}
			else if ( i > a){
				if (i > e)
				{
					if (i > o)
						{
						if (i > u)
							{
								System.out.println("The last vowel is: i and it's last position is" + i);
							}
						}
					}
			}
			else if ( o > a){
					if (o > e)
						{
						if (o > i)
							{
							if (o > u)
								{
									System.out.println("The last vowel is: o and it's last position is" + o);
								}
							}
						}
			}
			else if ( u > a){
					if (u > e)
						{
							if (u > o)
								{
								if (u > i)
									{
										System.out.println("The last vowel is: u and it's last position is" + u);
									}
								}
					
						}
							}
		
		}
		else 
		{
			System.out.println("There is no vowel in this word or sentence");
		}
	
	}
}
