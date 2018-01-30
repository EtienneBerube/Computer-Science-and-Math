package exercises;
import java.util.Scanner;

public class Exercise_10_8 {
		
		
	
		public static void main(String[] args) {
		double income;
		Scanner input = new Scanner(System.in);
		System.out.println("1) Single Filer \n2) Married jointly or qualying window\n3) Married separately\n4) Head of household\nEnter status:");
		int status = input.nextInt();
		status--;
		
		int[][] brackets2001 = 
				{{0,0,0,0},
				{27051, 45201,22601,36251},
				{65551,109251,54626,93651},
				{136751,166501,83251,151651},
				{297351,297351,148676,297351}
				};
		
		int[][] brackets2009 = 
				{{0,0,0,0},
				{8351,16701,8351,11951},
				{33951,67901,33951,45501},
				{82251,137051,68526,117458},
				{171551,208851,104426,190201},
				{372951,372951,186476,372951},
					};
		
		double[] rates2001 = {15,27.5,30.5,35.5,39.1};
		double[] rates2009 = {10,15,25,28,33,35};
		
		System.out.println("Enter your income: ");
		income = input.nextDouble();
		
		Tax tax2001 = new Tax(status, brackets2001,rates2001,income);
		tax2001.printCompleteChart();
		
		Tax tax2009 = new Tax(status,brackets2009,rates2009,income);
		tax2009.printCompleteChart();
		
		
		System.out.println(tax2009.getTax());

	}

}
