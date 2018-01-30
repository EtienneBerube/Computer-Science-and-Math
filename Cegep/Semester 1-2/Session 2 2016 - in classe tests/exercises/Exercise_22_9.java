package exercises;

import javafx.geometry.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class Exercise_22_9 {
	
	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Enter the number of pairs: ");
		int num = input.nextInt();
		
		int[][] popo = new int[num][2];
		
		for(int i = 0; i < num; i++){
			
			System.out.println("Enter x coord:");
			popo[i][0]=input.nextInt();
			
			System.out.println("Enter y coord:");
			popo[i][1]=input.nextInt();
		
			System.out.println();
			
			ArrayList<Point> x = getConvexHull(popo);
			System.out.println(x.toString());
		}
	}
	
	public static ArrayList<Point> getConvexHull(int[][] x) {
		Point[] y = new Point[x.length];
		
		for(int i = 0; i < x.length; i ++){
			y[i]=(new Point(x[i][0], x[i][1]));
		}
		
		java.util.Arrays.sort(y);
		
		//find smallest y value
		Point startingPoint = y[0];		
		int currentIndex=0;
		
		for(int i = 0; i < y.length; i ++){
			
			if(y[i].getY() <= startingPoint.getY()){
				startingPoint = y[i];
				currentIndex = i;
			}
			
		}
		
		ArrayList<Point> ho = new ArrayList<>();
		
		checkRight(y, ho);
		checkLeft(y, ho);
		
		for(Point point: ho){
			System.out.println(point.toString());
		}
		
		return ho;
	}
		
		
	
	public static void checkRight(Point[] list, ArrayList<Point> ho ){
		ho.add(list[0]);//add first element
		
		Point p1=list[0];
		int indexP1 = 0;
		Point p2=null;
		Point p3 = null;
		
		/*
		int isLeft = 0;
		int isRight = 0;
		*/
		
		for(int i = 1; i < list.length; i++){
			p2 = list[indexP1+i];
			
			if(i < list.length-1){
				for(int j = i+1; j < list.length; j++){
					p3 = list[j];
					int value = ((p2.getX()- p1.getX())*(p3.getY()-p1.getY()))-((p3.getX()-p1.getX())*(p2.getY()-p1.getY()));
				
					if(value<0)
						break;
					else{
						ho.add(p2);
						p1 = p2;
						indexP1 = i;
					}
				}
				/*
				if(value > 0)
					isLeft++;
				else if (value<0)
					isRight++;
				else
					isLeft+=0; //Do nothing
				
				if(isRight==0)
				*/
					
				
			}else{
				ho.add(list[i]);
			}
		}
	}
	
	public static void checkLeft(Point[] list, ArrayList<Point> ho ){
		
		Point p1=list[0];
		int indexP1 = 0;
		Point p2=null;
		Point p3 = null;
		
		/*
		int isLeft = 0;
		int isRight = 0;
		*/
		
		for(int i = list.length; i > 0; i--){
			p2 = list[indexP1+i];
			
			if(i < list.length-1){
				for(int j = i-1; j > 0; j--){
					p3 = list[j];
					int value = ((p2.getX()- p1.getX())*(p3.getY()-p1.getY()))-((p3.getX()-p1.getX())*(p2.getY()-p1.getY()));
				
					if(value<0)
						break;
					else{
						ho.add(p2);
						p1 = p2;
						indexP1 = i;
					}
					/*
					if(value > 0)
						isLeft++;
					else if (value<0)
						isRight++;
					else
						isLeft+=0; //Do nothing
				
					if(isRight==0)
					 */
					
				}
			}
		}
	}
	
	
	
}
