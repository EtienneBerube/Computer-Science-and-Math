package exercises;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Exercise_20_1 {

	public static void main(String[] args) {
		File file = new File("C:/Users/Étienne Bérubé/Documents/Java/Session 2 2016 - in classe tests/exercises/a.txt");
		System.out.println(file.exists());
		int count = 0;

		try {
			Scanner input = new Scanner(file);
			ArrayList<String> list = new ArrayList<>();

			while (input.hasNext()) {
				list.add(input.next());
				count++;
			}

			System.out.println(count);
			Collections.sort(list);

			/*for (String counter : list)
				System.out.println(counter);
		
		*/
			
			Iterator<String> iterator = list.iterator();
			while(iterator.hasNext()){
				System.out.println(iterator.next());
			}
			
		}catch (Exception ex) {
			System.out.println("File does not exit");
		}

	}

}
