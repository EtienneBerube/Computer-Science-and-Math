package exercises;
import java.util.Scanner;
public class J3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String alphabet = ("abcdefghijklmnopqrstuvwxyz");
		String line = input.nextLine();
		String pigLine = "";
		int pos = 0;
		int posVowelR=0;
		int posVowelL =0;
		int vowelCheckR = 0 ;
		int vowelCheckL = 0;
		boolean isVowelR = false;
		boolean isVowelL = false;
		
		for(int i = 0; i < line.length();i++){
			
			pos = 0;
			posVowelR=0;
			posVowelL = 0;
			vowelCheckR = 0 ;
			vowelCheckL = 0;
			isVowelR = false;
			isVowelL = false;
			
			if (line.charAt(i)!='a' && line.charAt(i)!='e' && line.charAt(i)!='i' && line.charAt(i)!='o' && line.charAt(i)!='u'){
				pigLine +=line.charAt(i);//add good consonant
				
				for (int m = 0; m < alphabet.length();m++){
					if(alphabet.charAt(m)== line.charAt(i)){
						pos=m;
						break;
					}
				}
				//VOWEL
				//right
				
				for(int j = (pos+1); j < alphabet.length(); j++ ){
					if(alphabet.charAt(j)=='a' || alphabet.charAt(j)=='e' || alphabet.charAt(j)=='i' || alphabet.charAt(j)=='o' || alphabet.charAt(j)=='u'){
						posVowelR = j;
						vowelCheckR = (j-pos);
						isVowelR = true;
						break;
					}
				}
			
				//left
				System.out.println(pos);
				for(int k = (pos-1); k > 0; k-- ){
					if(alphabet.charAt(k)=='a' || alphabet.charAt(k)=='e' || alphabet.charAt(k)=='i' || alphabet.charAt(k)=='o' || alphabet.charAt(k)=='u'){
						posVowelL = k;
						vowelCheckL = (pos-k);
						isVowelL = true;
						break;
					}
				}
					
				if(isVowelL && isVowelR){
					
					if (vowelCheckR < vowelCheckL){
						pigLine += alphabet.charAt(posVowelR);
					}
					
					else{
						pigLine += alphabet.charAt(posVowelL);
					}
				}
				
				else if (!isVowelR){
					pigLine+= alphabet.charAt(posVowelL);
				}
				
				else
					pigLine += alphabet.charAt(posVowelR);
					
					
				//NEXT CONSONANT
				if(line.charAt(i)=='z'){
					pigLine+="z";
				}
				
				else{
					for(int l = (pos+1); l < alphabet.length();l++){
						if (alphabet.charAt(l)!='a' && alphabet.charAt(l)!='e' && alphabet.charAt(l)!='i' && alphabet.charAt(l)!='o' && alphabet.charAt(l)!='u'){
							pigLine += alphabet.charAt(l);
							break;
						}
					}
				}
					
				
			}else
				pigLine +=line.charAt(i);
			
		}
		System.out.println(pigLine);

	}

}
