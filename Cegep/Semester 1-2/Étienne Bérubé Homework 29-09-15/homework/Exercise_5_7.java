package homework;

public class Exercise_5_7 {

	public static void main(String[] args) {
		double initialTuition = 10000;
		double tuitionCost;
	

		for (int numberOfYear = 0; numberOfYear < 10; numberOfYear++) {
				initialTuition*=1.05;
		}
		
		tuitionCost = initialTuition;
		
		for (int numberOfYear = 0; numberOfYear < 4; numberOfYear++){
				tuitionCost*=1.05;
		}
	
		System.out.printf("In ten years, the tuition costs will be: %5.2f $", tuitionCost);
	}

}
