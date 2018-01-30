package exercises;

public class Tax {
	
	public static final int SINGLE_FILER = 0;
	public static final int MARRIED_JOINTLY_OR_QUALIFYING_WIDOW = 1;
	public static final int MARRIED_SEPARATELY= 2;
	public static final int HEAD_OF_HOUSEHOLD = 3;
	
	private int fillingStatus;
	private int[][] brackets;
	private double[] rates;
	private double taxableIncome;
	
	public Tax(int status, int[][] brackets, double[] rates, double income) {
		this.brackets = brackets;
		fillingStatus = status;
		this.rates = rates;
		taxableIncome = income;
	}

	void printCompleteChart(){
		for (int i = 0; i < brackets.length; i++){
			System.out.printf("%-1.1f%%  | ",rates[i]);
			for (int j = 0; j < brackets[i].length; j++){
				System.out.printf("%-6d |", brackets[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	double getTax(){
		for (int i = brackets.length-1; i>=0;i--){
			if(taxableIncome > brackets[i][fillingStatus]){
				return (taxableIncome * (rates[i]/100));
			}
		}
		return -1;
	}
}
