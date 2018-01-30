package exception_Handling;

public class CheckPointsTest {

	public static void main(String[] args) {
		/*try {
			method();
			System.out.println("After the method call");
			}
			catch (RuntimeException ex) {
			System.out.println("RuntimeException in main");
			}
			catch (Exception ex) {
			System.out.println("Exception in main");
			}
*/
		System.out.println(isNumeric("1"));
	}
	static void method() throws Exception {
		try {
		String s = "abc";
		System.out.println(s.charAt(3));
		}
		catch (RuntimeException ex) {
		System.out.println("RuntimeException in method()");
		}
		catch (Exception ex) {
		System.out.println("Exception in method()");
		}
		}
	
	public static boolean isNumeric(String token) {
		try {
		Double.parseDouble(token);
		return true;
		}
		catch (java.lang.NumberFormatException ex) {
		return false;
		}
		}

}
/*
*12.21)yes
*yes yes
*yes no
*
*12.22) yes
*if(Character.isNumeric(token.charAt(0))){
*return true;
*}else
*return false;
*
*12.23)yes yes 
*yes yes
*yes no
*yes no
*
*12.24)java.lang.Exception: New info from method1
at ChainedExceptionDemo.method1(ChainedExceptionDemo.java:16)
at ChainedExceptionDemo.main(ChainedExceptionDemo.java:4)
*
*12.25)we extend Exception class
*
*12.26) Exception in method
*Exception in main
*
*
*/	