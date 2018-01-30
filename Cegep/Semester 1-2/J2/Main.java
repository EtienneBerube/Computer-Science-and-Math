import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[][] grid = new int[4][4];
		
		//input 16 3 2 13 5 10 11 8 9 6 7 12 4 15 14 1
		
		for (int i = 0; i < grid.length; i++){
			for (int j = 0; j < grid[i].length;j++){
				grid[i][j] = input.nextInt();
			}
		}
		
		/* TEST
		for (int i = 0; i < grid.length; i++){
			for (int j = 0; j < grid[i].length;j++){
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
		*/
		
		System.out.println(checkMagic(grid));

	}
	
	public static String checkMagic(int[][] x){
		if(checkHorizontal(x) && checkVertical(x) && checkDiagonalRight(x) && checkDiagonalLeft(x))
			return "magic";
		else
			return "not magic";
	}
	
	private static boolean checkHorizontal(int[][] x){ // works
		boolean isMagic = true;
		int rowTemplate =0;
		int row =0;
		
		
		for (int j = 0; j < x[0].length;j++){
				rowTemplate += x[0][j];
		}
		
		for (int i = 0; i < x.length; i++){
			row = 0;
			for (int j = 0; j < x[i].length;j++){
				row += x[i][j];
			}
			if(row != rowTemplate)
				isMagic = false;
		}
		//System.out.println(isMagic);
		return isMagic;
		
		
	}
	
	private static boolean checkVertical(int[][] x){ //works
		boolean isMagic = true;
		int columnTemplate =0;
		int column =0;
		
		
		for (int j = 0; j < x.length;j++){
				columnTemplate += x[j][0];
		}
		
		for (int i = 0; i < x[0].length; i++){
			column = 0;
			for (int j = 0; j < x.length;j++){
				column += x[j][i];
			}
			if(column != columnTemplate)
				isMagic = false;
		}
		//System.out.println(isMagic);
		return isMagic;
	}
	
	private static boolean checkDiagonalRight(int[][] x){ // works
		boolean isMagic = true;
		int columnTemplate =0;
		int rowTemplate =0;
		int diaRight = 0;
		
		for (int j = 0; j < x.length;j++){ // template
			columnTemplate += x[j][0];
		}
		for (int j = 0; j < x[0].length;j++){ // template
			rowTemplate += x[0][j];
		}
		
		for (int i = 0, j = 0; i < x.length ; i++, j++){
			diaRight += x[i][j];
		}
		
		if(diaRight != rowTemplate || diaRight != columnTemplate)
				isMagic = false;
		//System.out.println(isMagic);
		return isMagic;
	}
	private static boolean checkDiagonalLeft(int[][] x){
		boolean isMagic = true;
		int columnTemplate =0;
		int rowTemplate =0;
		int diaLeft = 0;
		
		for (int j = 0; j < x.length;j++){ // template
			columnTemplate += x[j][0];
		}
		for (int j = 0; j < x[0].length;j++){ // template
			rowTemplate += x[0][j];
		}

		
		for (int i = 0, j = 3; i < x.length ; i++, j--){
			diaLeft += x[i][j];
		}
		
		if(diaLeft != rowTemplate || diaLeft != columnTemplate)
				isMagic = false;
		
		return isMagic;
	}

}
