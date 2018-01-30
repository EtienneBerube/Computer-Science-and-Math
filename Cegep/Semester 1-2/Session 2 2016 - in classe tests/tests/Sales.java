package tests;
import java.util.Scanner;
import java.text.DecimalFormat;
public class Sales {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		double[] sales = new double[7];
		DecimalFormat dollar = new DecimalFormat( "#,##0.00" );
		
		for (int i = 0; i<7;i++){
		System.out.println("Please Enter the sales for the day #" + (i + 1) + ": ");
		sales[i] = input.nextDouble();
		}
		SalesData salesObject = new SalesData(sales);
		System.out.println("The total is: $" + dollar.format(salesObject.getTotal()));
		System.out.println("The average is: $" + dollar.format(salesObject.getAverage()));
		System.out.println("The highest day is: $" + dollar.format(salesObject.getHighest()));
		System.out.println("The lowest is: $" + dollar.format(salesObject.getLowest()));
		
	}

}
