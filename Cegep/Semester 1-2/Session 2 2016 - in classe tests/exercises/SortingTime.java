package exercises;

public class SortingTime {
	private int[] bigArray;
	
	public SortingTime(int n) {
		bigArray = new int[n];
		
		initialize();
	}

	public int[] getArray(){
		return bigArray;
	}
	
	private void initialize(){
		for(int i = 0; i < bigArray.length; i++){
			bigArray[i] = (int)(Math.random()*10000);
		}
	}
	
	public void reset(){
		initialize();
	}
	
}
	
