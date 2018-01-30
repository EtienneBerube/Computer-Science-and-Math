package exercises;
import java.util.*;

public class Exercise_8_19 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean isCons = false;
		int[][] grid ; 
		
		System.out.println("1) Predefined Array (7x7) \n 2) User input Array ");
		int choice = input.nextInt();
		
		while(choice != 1 && choice != 2){
			System.out.print("Wrong input try again: ");
		}
		
		switch(choice){
		case 1:	
				grid=populateArray();
				print(grid);
				isCons = isConsecutiveFour(grid);
				break;
		
		case 2: System.out.print("How many rows?: ");
				int row = input.nextInt();
				System.out.print("How many columns?: ");
				int column = input.nextInt();
				
				grid = new int[row][column];
				 
				for (int i = 0; i<grid.length;i++){
					for (int j = 0; j < grid[j].length; j++ ){
						System.out.print("Enter a number: ");
						grid[i][j] = input.nextInt();
						isCons = isConsecutiveFour(grid);
					}
					System.out.println("CAREFUL, we change row!");
				}
				break;
		
		}
		
		
		System.out.println((isCons)? "The grid has 4 consecutive numbers" : "The grid doesn't have 4 consecutive numbers");
		
	}
	
	public static int[][] populateArray(){
		int [][]x = {
				{1,2,2,4,5,6,5},
				{2,3,6,4,4,5,9},
				{3,9,1,3,5,7,4},
				{2,6,2,5,3,8,4},
				{2,2,4,3,1,7,5},
				{8,5,3,0,1,2,1},
				{2,3,2,2,3,6,5}};
		
		return x;
	}

	public static boolean isConsecutiveFour(int[][] values){
		boolean isCons = false;
		
		for (int i = 0; i < values.length; i++){
			for (int j = 0; j<values[i].length;j++){
				
				if (checkHori(i, j, values) || checkVert(i, j, values) || checkDiaRight(i, j, values) || checkDiaLeft(i, j, values)){ // put back checkDiaLeft
					isCons = true;
				}
				
			}}
		return isCons;
	}
	
	public static void print(int[][] x){
		for (int i = 0; i < x.length; i++){
			for (int j = 0; j < x[i].length;j++){
				System.out.print(x[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	public static boolean checkHori(int i, int j, int[][] values){
		boolean isCons = false;
		int count = 0;
		int column = j;
		int value = values[i][j];
		if (column < values[i].length-1 && isCons==false){//safety
			column++;
			count = 0;
			while(column < values[i].length){ 
				if (count == 3){
					isCons = true;
					break;
				}
				
				if(value != values[i][column]){
					break;
				}
			
				
				count++;
				column++;
			}
		}
		
		return isCons;
	}
	
	
	public static boolean checkVert(int i, int j, int[][] values){
		boolean isCons = false;
		int count = 0;
		int row = i;
		int column = j;
		int value = values[i][j];
		
		if(row < values.length-1&&isCons==false){ //safety
			count = 0;
			row++;
			while(row < values.length){ //check verticale
				
				if (count == 3){
					isCons = true;
					break;
				}
				
				if(value != values[row][j]){
					break;
				}
			
				
				count++;
				row++;
			}
		}
		
		return isCons;
	}
	
	
	public static boolean checkDiaRight(int i, int j, int[][] values){
		boolean isSameNum = true;
		int value = values[i][j];
		int count = 0;
		
		while(i < values.length && j < values[i].length && isSameNum == true){
			if (values[i][j] != value){
				isSameNum = false;
			}
			count++;
			j++;
			i++;
		}
		
		if (count<4){
			return false;
		}
		return isSameNum;
		
	}
	
	public static boolean checkDiaLeft(int i, int j, int[][] values){
		
		boolean isSameNum = true;
		int value = values[i][j];
		int count = 0;
		
		while(i < values.length && j > 0 && isSameNum == true){
			if (values[i][j] != value){
				isSameNum = false;
			}
			count++;
			j--;
			i++;
		}
		
		if (count<4){
			return false;
		}
		return isSameNum;
		
		
	}
	
}
