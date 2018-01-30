package tests;

public class RecursiveSort {

	public static void main(String[] args) {
		int[] pop = new int[10];
		for(int i = 0; i< pop.length; i++){
			pop[i] = (int)(Math.random()*10);
		}
		for(int i = 0; i<pop.length;i++){
			System.out.println(pop[i]);
		}
		SelectionSort(pop, 0);
		
		System.out.println("new");
		
		for(int i = 0; i<pop.length;i++){
			System.out.println(pop[i]);
		}

	}
	
	static void SelectionSort(int[] x, int status){
		if(status != x.length-1){
			
		if(x[status] <= x[status+1]){
			SelectionSort(x, status+1);
		}else{
			int temp = x[status];
			x[status] = x[status+1];
			x[status+1]=temp;
			SelectionSort(x, status+1);
		}
		}
	}

}
