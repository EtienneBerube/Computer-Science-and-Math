import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		String s = (input.next()).toLowerCase();
		int best = 1;
		int temp = 0;
		if(s.length() < 1 || s.length() > 40){
			System.exit(0);
		}else{
			for(int i = 1; i < s.length()-1; i ++){
				temp = countPalidromeLength(s, i);
				if (temp  > best)
					best = temp;
			}
			System.out.println(best);
		}

	}
	
	static int countPalidromeLength(String s, int pos){
		int count;
		int count1 =0;
		int count2 =0;
		if((s.charAt(pos-1) == s.charAt(pos+1)) || (s.charAt(pos) == s.charAt(pos+1))){
			
			if (s.charAt(pos-1) == s.charAt(pos+1)){ // WORKS
				count1 = 3;
				for (int i = 2; (pos-i) >= 0 && (pos+i) <s.length(); i++){
					if(s.charAt(pos-i) == s.charAt(pos+i))
						count1 +=2;
					else 
						break;
				}
		
			}
			
			if(s.charAt(pos) == s.charAt(pos+1)){
				count2 =2;
			
				for (int i = 1; (pos-i) >= 0 && (pos+i+1) <s.length(); i++){
					if(s.charAt(pos-i) == s.charAt(pos+i+1))
						count2 +=2;
					else 
						break;
				}
		
			}
		}else 
			 return count =1;
		
		if(count1 > count2)
			return count1; 
		else
			return count2;
	}

}
