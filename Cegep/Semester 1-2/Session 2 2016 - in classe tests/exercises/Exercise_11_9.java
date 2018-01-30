package exercises;

import java.util.*;

public class Exercise_11_9 {
	
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Enter something: ");
		int n = input.nextInt();
		
		ArrayList<StringBuilder> x = new ArrayList<>();
		
		for (int i = 0; i < n; i ++){
			x.add(new StringBuilder(""));
			for(int j = 0; j < n; j ++ ){
				x.get(i).append("" + (int)(Math.random()*2));
			}
			
		}
		
		System.out.println(x.toString());
		System.out.println(checkHor(x));
		System.out.println(checkVer(x));

	}
	
	
	static String checkHor(ArrayList<StringBuilder> x){
		int count=0;
		int temp = 0;
		String tempPos ="";
		
		for(int j = 0; j < x.get(0).length(); j ++){
			if(x.get(0).charAt(j) == '1')
				count++;
		}
		temp = count;
		tempPos = "0";
		
		for(int i = 1; i < x.size(); i++ ){
			count = 0;
			//temp
			for(int j = 0; j < x.get(0).length(); j ++){
				if(x.get(i).charAt(j) == '1')
					count++;
			}
			
			if(count > temp){
				temp = count;
				tempPos ="" + i;
			}else if (count == temp){
				tempPos+= ", " + i;
			}
		}
		
		return "Largest row: " + tempPos;
	}
	
	static String checkVer(ArrayList<StringBuilder> x){
		int count=0;
		int temp = 0;
		String tempPos ="";
		
		//temp
		for(int j = 0; j < x.size(); j ++){
			if(x.get(j).charAt(0) == '1')
				count++;
		}
		temp = count;
		tempPos = "0";
		
		for(int i = 0; i < x.get(0).length(); i ++){
			count = 0;
			for(int j = 1; j < x.size(); j ++){
				if(x.get(j).charAt(i) == '1')
					count++;
			}
			if(count > temp){
				temp = count;
				tempPos ="" + i;
			}else if (count == temp){
				if(!tempPos.equals(""+i))
				tempPos+= ", " + i;
			}
		}
		return "Largest column: " +tempPos;
	}

}
