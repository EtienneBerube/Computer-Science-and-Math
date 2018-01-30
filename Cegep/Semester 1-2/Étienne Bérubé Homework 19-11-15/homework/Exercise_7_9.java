package homework;
import java.util.Scanner;
public class Exercise_7_9 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double[] num = new double[10];
		
		for ( int i = 0; i<10; i++){
			System.out.print("Enter the number: ");
			num[i] = input.nextDouble();
		}
		
		System.out.println(min(num));
		
		input.close();
	}
public static double min(double[] array){
	double min = array[0];
	
	for (int i = 0; i<10; i++){
		if(array[i] < min)
			min = array[i];
	}
	return min;
}
}
