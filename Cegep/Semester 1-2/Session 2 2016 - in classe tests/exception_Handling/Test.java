package exception_Handling;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		ArrayList<Integer> x = new ArrayList<>();
		x.add(0);
		x.add(new Integer("2"));
		x.add(5);
		System.out.println(x.toString());
		System.out.println();
		
		try{
		x.add(z(x.get(1)));
		}
		catch(Exception k){
			System.out.println("Something is 0");
			System.out.println(k);
			k.printStackTrace();
		}
		finally{
			System.out.println("Always prints anyway");
		}
		
		System.out.println(x.toString());

	}
	public static int z(int y) throws Exception{
		if (y != 0){
			try{
				int w = z2(y+1);
				return w;
			}catch (Exception m){
				throw new Exception("x is beauty", m);
			}
		}
		else 
			throw new Exception("Argument is zero");
	}
	
	public static int z2(int y) throws Exception{
		throw new Exception("second method");
	}
}
