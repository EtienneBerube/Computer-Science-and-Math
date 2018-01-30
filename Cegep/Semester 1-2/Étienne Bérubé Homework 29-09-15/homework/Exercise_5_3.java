package homework;

public class Exercise_5_3 // and 5.5
{

	public static void main(String[] args) 
	{
		int count = 1;
		int pound = 20;
		
		System.out.printf("%-20s%1s   |   %-5s%20s\n","Kilograms","pounds","pounds","kilograms");
		while (count < 200)
		{
			
			System.out.printf("%-20.0f%-6.2f   |   %-20.0f%1.1f\n",(float)count,(count * 2.2),(float)pound,(pound/2.2));
			count += 2;
			pound += 5;
		}
				
				
		

	}

}
