package homework;

public class Exercise_7_7 {

	public static void main(String[] args) {
		int[] num = new int[100];
		int[] count = new int[10];
				
				for(int i = 0; i < 100; i++){//assigning 
					num[i] = (int)(Math.random()*10);
					System.out.print(num[i]);
				}
				System.out.println("");
				
				for (int i = 0; i<100; i++){
					
					for (int j = 0; j<10;j++){
						
						if (num[i] == j){
							
							for(int k = 0; k<10; k++){
								
								if(num[i] == k){
									count[k]++;
								}
							}
						}
					}
				}
				for (int i = 0; i <10; i++){
					System.out.println("For the number " + i + " the number have printed " +count[i]);
				}
	
	
	}
	
	

}
