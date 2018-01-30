package In_Class;

import java.util.Scanner;
import In_Class.Rectangle;

public class TestRectangle {


	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		double rectangleWidth = 0;
		double rectangleLenght = 0;
		
		System.out.print("Please enter the width of the rectangle: ");
		rectangleWidth = input.nextDouble();
		
		System.out.print("Please enter the lenght of the rectangle: ");
		rectangleLenght = input.nextDouble();
		
		Rectangle rectangle1 = new Rectangle(rectangleWidth, rectangleLenght); 
		System.out.println("the width is " + rectangle1.getWidth() + "and the lenght is " + rectangle1.getLenght() 
				+ ". The area is " + rectangle1.getArea() + " and the perimeter is " + rectangle1.getPerimeter());
	}
}
