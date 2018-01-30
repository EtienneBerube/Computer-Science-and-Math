package tests;

public class BinaryFormatException extends Exception {
	private String binaryString;
	
	public BinaryFormatException(String binaryString) {
		super("Invalid binary sequence " + binaryString);
		this.binaryString = binaryString;
	}

	public String getBinaryString(){
		return this.binaryString;
	}
}
