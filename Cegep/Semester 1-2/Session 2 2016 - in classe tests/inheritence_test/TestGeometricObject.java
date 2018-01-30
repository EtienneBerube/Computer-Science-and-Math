package inheritence_test;

import java.util.Scanner;

public class TestGeometricObject {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter three sides: ");
		double s1 = input.nextDouble();
		double s2 = input.nextDouble();
		double s3 = input.nextDouble();
		
		Triangle triangle = new Triangle(s1,s2,s3);
		System.out.println(triangle.toString());
		System.out.println("Enter a color: ");
		String color = input.next();
		triangle.setColor(color);
		System.out.println("Is it filled? (Y/N)");
		String filled = (input.next()).toUpperCase();
		
		while(filled.charAt(0) != 'Y' && filled.charAt(0) != 'N'){
			System.out.println("Wrong input: ");
			filled = (input.next()).toUpperCase();
		}
		
		if(filled.charAt(0) == 'Y')
			triangle.setFilled(true);
		else
			triangle.setFilled(false);
		
		System.out.println(triangle.toString());

	}

}
