package exercises;

public class Pair {
	private Point p1;
	private Point p2;
	private int distance;
	
	public Pair(Point p1, Point p2) {
		// TODO Auto-generated constructor stub
	}
	
	public int getDistance(){
		return (int)Math.sqrt(Math.pow((p2.getX()-p1.getX()), 2)+Math.pow((p2.getY()-p1.getY()), 2));
	}

}
