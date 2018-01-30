package experiments;

import java.util.*;

public class Test_1 
{

	public static void main(String[] args) 
	{
		
		Scanner input = new Scanner(System.in);
		
		byte age;
		
		System.out.print("Please enter your age ");
		age = input.nextByte();
		
		if (age <= 12)
		{
			System.out.println("You are a kid");
		}
		
		else 
		{
			if (age <= 18)
			{
				System.out.println("You are a teenager");
			}
			
			else
			{
				
				if ( age <= 25)
				{
					System.out.println("you are a young adult");
				}
				
				else 
				{
					if (age <= 50)
					{
						System.out.println("You are an experienced human being");
					}		
					
					else 
					{
						if (age <= 75)
						{
							System.out.println("You're retired for good");
						}
							
						
						else
						{	
								if (age <= 100)
								{
										System.out.println("Ok, let's face it, you're old...");
							
								}
						
								else
								{
										if (age <= 127)
										{
											System.out.println("Ok... now you're really old");
										}
								}
						}
					}
				
				}	
				
			}
		}
	}
}
		



