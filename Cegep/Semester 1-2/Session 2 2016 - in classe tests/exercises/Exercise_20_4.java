package exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;

public class Exercise_20_4 {

	public static void main(String[] args) {
		Point[] list =new Point[100];
		
		for(int i = 0; i < 100; i++){
			list[i] =(new Point(((int)(Math.random()*101)),(int)(Math.random()*101)));
		}
		Point[] listY = new Point[100];
		Point[] listX = new Point[100];
		
		java.lang.System.arraycopy(list, 0, listY, 0, 100);
		java.lang.System.arraycopy(list, 0, listX, 0, 100);
		
		// by Y
		Arrays.sort(listY, new CompareY());
		
		for(int i=0; i<listY.length; i++){
			System.out.println(listY[i].getX() + ", "+list[i].getY());
		}
		System.out.println();
		Arrays.sort(listX);
		for(int i=0; i<listX.length; i++){
			System.out.println(listX[i].getX() + ", "+listX[i].getY());
		}
		
		

	}

}
