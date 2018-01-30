package exercises;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Exercise_12_31 {

	public static void main(String[] args) {
		Scanner humanInput = new Scanner(System.in);
		
		String tempUrl = "http://www.ssa.gov/oact/babynames/";
		String temp = "babynameranking";	
		System.out.println("Enter a year from 2001, 2002 or 2010: ");
		String choice = humanInput.next();
		
		while(!choice.equals("2001") && !choice.equals("2002") && !choice.equals("2010")){
			System.out.println("Wrong input, try again: ");
			choice = humanInput.next();
		}
		
		String url = tempUrl + temp + choice + ".txt";
		System.out.println(url);
			
		try{	
			URL rank = new URL(url);
			//URL rank = new URL("https://www.ssa.gov/cgi-bin/popularnames.cgi");
			Scanner urlInput = new Scanner(rank.openStream());
			
			System.out.println("Enter a name: ");
			String name = humanInput.next();
			
			String ranking = "";
			int count = 0; // debugging
			while(urlInput.hasNext()){
				count++;
				String tempName = urlInput.next();
				System.out.println(tempName);
				if (tempName.equals(name)){
					ranking = urlInput.next();
				}
			}
			System.out.println(count);
			System.out.println(name + " is ranked " + ranking +" in " + choice);
			
		}catch(MalformedURLException ex){
			System.out.println("Bad URL");
		}catch(IOException ex){
			System.out.println("Bad Input");
		}

	}

}
