package exception_Handling;

public class CalculatorException {
	public static void main(String[] x) {
		 // Check number of strings passed
		 String [] args = {"3","-","2"};
		
		if (args.length != 3) {
			System.out.println(
		    "Usage: java Calculator operand1 operator operand2");
		    System.exit(0);
		        }
		   
		// The result of the operation
		int result = 0;
		   
		  // Determine the operator
		try{
		 switch (args[1].charAt(0)) { 
		  case '+': result = Integer.parseInt(args[0]) + 
		                            Integer.parseInt(args[2]);
		  break;
		  case '-': result = Integer.parseInt(args[0]) -
		                            Integer.parseInt(args[2]);
		  break;
		  case '.': result = Integer.parseInt(args[0]) *
		                            Integer.parseInt(args[2]);
		  break;
		  case '/': result = Integer.parseInt(args[0]) /
		                            Integer.parseInt(args[2]);
		  default: System.out.println("No operator");
		 }
		 System.out.println(args[0] + ' ' + args[1] + ' ' + args[2]
		         + " = " + result);
		}
		catch (NumberFormatException y){
			System.out.println("non alphanumeric stuff");
		}
		   
		// Display result
		
	}
}






