package exercises;
import java.util.Scanner;
public class Exercise_8_5 {

	public static void main(String[] args) {
		double[][] matrix1 = new double[3][3];
		double[][] matrix2 = new double[3][3];
		double[][] total;
		
		populate(matrix1);
		populate(matrix2);
		total = addMatrix(matrix1, matrix2);
		System.out.println("The matrix are added as follow: ");
		print(total);
		

	}
	
	public static void populate(double[][] x){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the numbers in the matrix");
		for (int i = 0; i < x.length; i++){
			for (int j = 0; j < x[i].length; j++){
				x[i][j] = input.nextDouble();
			}
		}
		
	}
	
	public static double[][] addMatrix(double[][] a, double[][] b){
		double[][] c = new double [3][3];
		for (int i= 0; i < a.length; i++){
			for (int j = 0; j < a[i].length; j++){
				c[i][j] = a[i][j] + b[i][j];
			}
		}
		return c;
	}
	
	
	public static void print(double[][] x){
		for (int i= 0; i < x.length; i++){
			for (int j = 0; j < x[i].length; j++){
				System.out.print(x[i][j] + " ");
			
			}
			System.out.println("");
		}
	}
}
