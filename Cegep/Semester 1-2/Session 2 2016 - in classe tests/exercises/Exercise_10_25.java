package exercises;

public class Exercise_10_25 {

	public static void main(String[] args) {
		String s = "#hel#?lo#";
		String[] x = split(s, "[#?]");
		for(int i = 0; i < x.length; i++){
			System.out.print(x[i]);
		}

	}
	
	static String[] split(String s, String regex){
		int countRegex = 0;
		int n = 0;
		int pos = 0;
		int start = 0;
		
		regex = regex.substring(1, regex.length()-1);
		
		
		//counting needed cell in the arraw
		for(int i = 1; i < s.length()-1; i ++){
			
			for(int j = 0; j < regex.length(); j ++){
				
				if(s.charAt(i)==regex.charAt(j))
					countRegex++;
				if(s.charAt(0)==regex.charAt(j))
					n++;
				if(s.charAt(s.length()-1)==regex.charAt(j))
					n++;
			}
		}
		
		//section count
		n += (2 * countRegex + 1);
		
		
		String[] splitted = new String[n];
		
		
		//initializing
		for(int i =0; i < splitted.length; i++){
			splitted[i]="";
		}
		
		for(int i = 0; i < s.length(); i ++){
			
			for(int j = 0; j < regex.length(); j ++){
				if(s.charAt(i)==regex.charAt(j)){
					splitted[pos] = s.substring(start, (i));
					start = (i+1);
					splitted[++pos]+=(regex.charAt(j));
					pos++;
					continue;
				}
				if(i == s.length()-1){
					splitted[pos] = s.substring(start, s.length());
				}
			}
		}
		
		return splitted;
	}

}
