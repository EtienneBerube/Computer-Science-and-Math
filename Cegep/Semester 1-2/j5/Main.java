import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		int n = input.nextInt();
		if (n<1 || n>100){
			System.exit(0);
		}
		int[] speedDmo = new int[n];
		int[] speedPeg = new int[n];
		int x = 0;
		for(int i = 0; i < speedDmo.length; i++){
			x = input.nextInt();
			if(x>= 1 && x<=1000000)
				speedDmo[i] = x; 
		} 
		for(int i = 0; i < speedPeg.length; i++){
			x = input.nextInt();
			if(x>= 1 && x<=1000000)
				speedPeg[i] = x; 
		}
		sort(speedDmo);
		sort(speedPeg);
		
		int total = 0;
		
		switch(choice){
		//min
		case 1: 
			for(int i = 0; i < n; i ++){
				total += Math.max(speedDmo[i], speedPeg[i]);
			}
			System.out.println(total);
			
			break;
		//max
		case 2:
			for(int i = 0; i < n; i ++){
				total += Math.max(speedDmo[i], speedPeg[(speedPeg.length -1)-i]);
			}
			System.out.println(total);
			break;
		
		}

	}
	
	public static void sort(int[] x){
		for(int i = 0; i < x.length ;i++){
			int curMin = x[i];
			int curMinPos = i;
			
			for(int j = i+1; j < x.length; j++ ){
				if(x[j] < curMin){
					curMin = x[j];
					curMinPos = j;
			
				}
				if(curMinPos != i){
					int temp = x[i];
					x[i] = x[curMinPos];
					x[curMinPos] = temp;
				}
			
			}
		}
	}

}
