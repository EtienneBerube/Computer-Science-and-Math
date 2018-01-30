package exercises;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Exercise_20_6 {

	public static void main(String[] args) {
		
		LinkedList<Integer> list = new LinkedList<>();
		
		for(int i = 0; i < 500000; i++){
			list.add(new Integer((int)(Math.random()*1001)));
		}
		
		long timeStart = System.currentTimeMillis();
		long timeEnd = 0;
		
		for(int i = 0; i < 500000; i++){
			list.get(i);
		}
		
		timeEnd = System.currentTimeMillis();
		
		System.out.println("With .get(i): " + (timeEnd-timeStart)+ "**************************");
		
		Scanner input = new Scanner(System.in);
		input.next();
		
		Iterator<Integer> iterator= list.iterator();
		
		timeStart = System.currentTimeMillis();
		
		while(iterator.hasNext()){
			iterator.next();
		}
		
		timeEnd = System.currentTimeMillis();
		
		System.out.println("With Iterator: " +(timeEnd - timeStart));
	

	}

}
