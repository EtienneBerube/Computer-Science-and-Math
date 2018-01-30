package homework;

public class Exercise_7_13 {

	public static void main(String[] args) {
		int[] num = new int[54];
		for (int i = 0; i<54; i++){
			num[i]=i;
		}
		System.out.println(getRandom(num));
	}
	public static int getRandom(int... numbers){
		int z = (int)(Math.random()*55);
		
		return numbers[z];
	}
}
