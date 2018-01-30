//Might need to change the package
package lab_1;

import java.util.*;
import java.io.*;

//10:57am, the algorithm does NOT sort appropriately.... weirdly enough, the rest of the program works fine and as expected.
//Rest of the program matches the requierments

public class PriorityQueueTest{

	  public static void main(String[] args) throws Exception {
		  //Creates file
		  File jobs = new File("C:/Users/Étienne Bérubé/Documents/Java/Session 2 2016 - in classe tests/lab_1/printerjobs.txt");
		 
		  //Not required but useful
		  System.out.println("File Exists: " + jobs.exists());
		 
		  Scanner input = new Scanner(jobs);
		  
		  ArrayList<Job> list = new ArrayList<>();
		  
		  //Reads from the file and puts it in an ArrayList<Job>
		  int priority;
		  String userName;
		  String task;
		  System.out.println("Arrival order of the jobs");
		  while(input.hasNext()){
			  priority = input.nextInt();
			  System.out.print(priority);
			  userName = input.next();
			  System.out.print(" " +  userName);
			  input.next();
			  input.next();
			  task = input.next();
			  System.out.println(" print file " + task);
			  
			  list.add(new Job(priority,userName,task));	  
		  }
		  
		  //Create first PriorityQueue called printer1 and displays the order
		  PriorityQueue<Job> printer1 = new PriorityQueue<>(list);
		  System.out.println("\nView printer1 queue, uses natural order priority");
		  viewPrinterQueue(printer1);
		  
		  //Create Second PriorityQueue called printer2 and displays the order
		  PriorityQueue<Job> printer2 = new PriorityQueue<>(6, new ComparatorRNO());
		  for(int i = 0; i < list.size(); i++){
			  printer2.offer(list.get(i));
		  }
		  System.out.println("\nView printer2 queue, uses reverse natural order priority");
		  viewPrinterQueue(printer2);
		 
		
 }
	  
	  
	static public void viewPrinterQueue (PriorityQueue<Job> printer) {
		Iterator<Job> iterator = printer.iterator();
		while(iterator.hasNext()){
			System.out.println((iterator.next()));
		}
		
		
	}
			  
}
