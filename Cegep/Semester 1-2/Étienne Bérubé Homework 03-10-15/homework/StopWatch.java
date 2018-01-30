package homework;

import java.util.Scanner;

public class StopWatch {
	double startTime = 0;
	double endTime = 0;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StopWatch time = new StopWatch();
		time.start();
		int y = 0;
		
		System.out.println("Enter the alphabet");
		String alphabet = input.next();
		
		time.end();
		System.out.println(time.getElapsedTime()+"sec");
		
		input.close();

	}
	
	StopWatch(){
		startTime = System.currentTimeMillis();
	}
	void start(){
		startTime = System.currentTimeMillis();
	}
	void end(){
		endTime = System.currentTimeMillis();
	}
	double getElapsedTime(){
		double z = 0;
		z = (endTime - startTime)/1000;
		return z;
	}
	
}
	