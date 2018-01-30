package In_Class;

import java.util.Scanner;

public class Rectangle {
	private double width =1;
	private double lenght =1;
	
	Rectangle (){
		
	}
	
	Rectangle (double x, double y){
		width = x;
		lenght = y;
	}
	
	double getArea(){
		double z = 0;
		
		z = width * lenght;
		
		return z;
	}
	
	double getPerimeter(){
		double z = 0;
		z = 2* width + 2 * lenght;
		
		return z;
		
	}
	
	double getWidth(){
		return width;
	}
	
	double getLenght(){
		return lenght;
	}
	
}
