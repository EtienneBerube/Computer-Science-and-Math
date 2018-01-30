package exercises;
import java.util.Scanner;
import java.text.DecimalFormat;
public class Exercise_8_6 {

	public static void main(String[] args) {
		double[][] matrix1 = new double[3][3];
		double[][] matrix2 = new double[3][3];
		double[][] total = new double[3][3];
		
		populate(matrix1);
		populate(matrix2);
		total = multiplyMatrix(matrix1, matrix2);
		System.out.println("The matrix are multiplied as follow: ");
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
	
	public static void print(double[][] x){
		DecimalFormat format = new DecimalFormat("#,##0.#");
		for (int i= 0; i < x.length; i++){
			for (int j = 0; j < x[i].length; j++){
				System.out.print(format.format(x[i][j]) + " ");
			
			}
			System.out.println("");
		}
	}
	
	public static double[][] multiplyMatrix(double[][] a, double[][] b){
		double[][] c = new double[3][3];
		for (int i= 0; i < a.length; i++){
			for (int j = 0; j < a[i].length; j++){
				c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j] + a[i][2] * b[2][j];
			}
		}
		return c;
	}
	
}
