package tests;

public class SalesData {
	private double[] sales = new double[7];
	
	public SalesData(double[] s) {
		sales = s;
	}
	
	double getTotal(){
		double totalSales=0;
		for(int i = 0; i<sales.length;i++){
			totalSales += sales[i];
		}
		
		return totalSales;
	}
	double getAverage(){
		double totalSales=0;
		for(int i = 0; i<sales.length;i++){
			totalSales += sales[i];
		}
		
		return totalSales/7;
	}
	double getHighest(){
		double max = sales[0];
		for (int i =0; i < sales.length;i++){
			if (sales[i] > max){
				max = sales[i];
			}
		}
		return max;
	}
	double getLowest(){
		double min = sales[0];
		for (int i =0; i < sales.length;i++){
			if (sales[i] < min){
				min = sales[i];
			}
		}
		return min;
	}
}
