package file_Test;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class File_Test {
	
	public static void main(String[] args) throws Exception{
		Scanner humanInput = new Scanner(System.in);
		
		File file1 = new File("C:/Users/Étienne Bérubé/Documents/Java/Session 2 2016 - in classe tests/file_Test/a.txt");
		File file2 = new File("C:/Users/Étienne Bérubé/Documents/Java/Session 2 2016 - in classe tests/file_Test/b.txt");
		System.out.println(file1.exists());
		System.out.println(file2.exists());
		

		
		PrintWriter output = new PrintWriter(file2);
		Scanner input = new Scanner(file1);
		
		
		String x = input.nextLine();
		System.out.println(x);
		output.write("Hello");
		
		output.close();
		input.close();
		
		
		
		
	}

}
