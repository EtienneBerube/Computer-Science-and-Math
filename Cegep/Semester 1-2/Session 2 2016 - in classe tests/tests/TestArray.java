package tests;

public class TestArray {

	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4};
		for (int i = 0; i <a.length; i++){
			System.out.println(a[i]);
		}
		modif(a);
		for (int i = 0; i <a.length; i++){
			System.out.println(a[i]);
		}
	}
	
	static void modif(int[] x){
		x[0] = 9000;
	}

}
