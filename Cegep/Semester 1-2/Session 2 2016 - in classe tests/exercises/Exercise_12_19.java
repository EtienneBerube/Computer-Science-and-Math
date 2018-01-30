package exercises;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Exercise_12_19 {

	public static void main(String[] args) throws MalformedURLException {
		int count = 0;
		try{
		URL url = new URL("http://cs.armstrong.edu/liang/data/Lincoln.txt");
		
		Scanner input = new Scanner(url.openStream()); // What is an open Stream
			
			while(input.hasNext()){
				input.next();
				count++;
			}
		
		}catch(MalformedURLException ex){
			System.out.println("Bad URL");
		}
		catch(IOException ex){
			System.out.println("Bad input");
		}
			System.out.println("There is: " + count +" words");
		
		
	}

}
