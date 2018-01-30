package homework;

public class RegularPolygon {
	private int numberOfSides = 3;
	private double lenght = 1;
	private double x = 0;
	private double y = 0;
	
	public static void main(String[] args) {
		RegularPolygon try1 = new RegularPolygon();
		System.out.println(try1.getPerimeter()+""+try1.getArea());
		
		RegularPolygon try2 = new RegularPolygon(6, 4);
		System.out.println(try2.getPerimeter()+""+try2.getArea());
		
		RegularPolygon try3 = new RegularPolygon(10, 4, 5.6 , 7.8);
		System.out.println(try3.getPerimeter()+""+try3.getArea());
		

	}
	public RegularPolygon() {
		
	}
	
	public RegularPolygon(int numberSides, double lenghtOfSides){
		numberOfSides = numberSides;
		lenght = lenghtOfSides;
	}
	
	public RegularPolygon (int numberSides, double lenghtOfSides, double coorx, double coory){
		numberOfSides = numberSides;
		lenght = lenghtOfSides;
		x= coorx;
		y = coory;
				
	}
	
	double getPerimeter(){
		return (lenght * numberOfSides);
	}
	
	double getArea(){
		return ((numberOfSides * lenght * lenght)/(4*Math.tan(Math.PI/numberOfSides)));
	}
}
