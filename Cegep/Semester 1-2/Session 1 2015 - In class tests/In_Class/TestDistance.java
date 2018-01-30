package In_Class;

import java.util.*;

public class TestDistance {

	public static void main(String[] args) {

		double charlotteX = 35.2270869;
		double charlotteY = -80.8431267;
		double savannahX = 32.0835407;
		double savannahY = -81.0998342;
		double atlantaX = 33.7489954;
		double atlantaY = -84.3879824;
		double orlandoX = 28.5383355;
		double orlandoY = -81.3792365;
		
		double areaTop = 0;
		double areaBottom = 0;
		double totalArea = 0;

		//sides
		double distanceCharlotteSavannah = 0;
		double distanceCharlotteAtlanta = 0;
		double distanceAtlantaSavannah = 0;
		double distanceAtlantaOrlando = 0;
		double distanceOrlandoSavannah = 0;
		
		// call calcGreatCircleDistance()
		distanceCharlotteSavannah = calcGreatCricleDistance(charlotteX, charlotteY, savannahX, savannahY);
		distanceCharlotteAtlanta = calcGreatCricleDistance(atlantaX, atlantaY, charlotteX, charlotteY);
		distanceAtlantaSavannah = calcGreatCricleDistance(atlantaX, atlantaY, savannahX, savannahY);
		distanceAtlantaOrlando = calcGreatCricleDistance(atlantaX, atlantaY, orlandoX, orlandoY);
		distanceOrlandoSavannah = calcGreatCricleDistance(orlandoX, orlandoY, savannahX, savannahY);
		
		// print distance between the Two cities
		System.out.printf("The distance between Charlotte and Savannah is: %5.2fkm\n",distanceCharlotteSavannah);
		System.out.printf("The distance between Charlotte and Atlanta is: %5.2fkm\n",distanceCharlotteAtlanta);
		System.out.printf("The distance between Atlanta and Savannah is: %5.2fkm\n",distanceAtlantaSavannah);
		System.out.printf("The distance between Atlanta and Orlando is: %5.2fkm\n",distanceAtlantaOrlando);
		System.out.printf("The distance between Orlando and Savannah is: %5.2fkm\n",distanceOrlandoSavannah);
		
		areaTop = calcAreaOfTriangle(distanceCharlotteAtlanta, distanceCharlotteSavannah, distanceAtlantaSavannah);
		areaBottom = calcAreaOfTriangle(distanceOrlandoSavannah, distanceAtlantaOrlando, distanceAtlantaSavannah);
		totalArea = areaTop + areaBottom;
		
		System.out.printf("The Total area covered by the zone is: %5.2fkm^2\n",totalArea);
		
	}// close main method

	// create new method
	public static double calcGreatCricleDistance(double x1, double y1, double x2, double y2) {

		// declare return variable
		double distance = 0;
		final double RADIUS = 6371.01;

		// calculate distance between the cities
		
		distance = RADIUS * Math.acos(
				Math.sin(Math.toRadians(x1))* Math.sin(Math.toRadians(x2)) + Math.cos(Math.toRadians(x1)) * Math.cos(Math.toRadians(x2)) * Math.cos(Math.toRadians(y1 - y2))
				);
		
		return distance;
	} // close method
	
	public static double calcAreaOfTriangle(double side1, double side2, double side3){
		
		double area = 0;
		double s;
		
		s = (side1 + side2 + side3)/2; 
		area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
		
		return area;
	}
} // close class
