package homework;

import java.util.Date;

public class Exercise_9_3 {

	public static void main(String[] args) {
		long x = 10000;
		
		Date example = new Date(x); 
		
		for (int i = 0; i < 8; i++){
		
			example.setTime(x);
		
			System.out.println(example.toString());
			
			x*=10;
		}
		
	}

}
