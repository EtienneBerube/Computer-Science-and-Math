package exercises;

public class Exercise_22_7 {
	private static Pair pair1;
	private static Pair pair2;
	private static Pair pair3;
	
	public static void main(String[] args) {
		Point[] p = new Point[50];
		
		for(int i = 0; i < p.length; i++){
			p[i]= new Point((int)(Math.random()*101),(int)(Math.random()*101));
		}
		
		int n;
		int m;
		
		if((p.length%2) == 0){
			n = p.length/2;
			m = p.length/2;
		}else{
			n = (p.length/2)+1;
			m= (p.length/2) -1;
		}
		java.util.Arrays.sort(p);
		
		Point[] q1 = new Point[n];
		Point[] q2 = new Point[m];
		
		System.arraycopy(p, 0, q1, 0,q1.length);
		System.arraycopy(p, n-1, q2, 0, q2.length);
		
		print(q1);
		System.out.println();
		print(q2);
		
		pair1=getClosestPair(q1);
		pair2=getClosestPair(q2);
		
		double dist = Math.min(pair1.getDistance(), pair2.getDistance());
		
		pair3 = distance(q1,q1.length-dist,dist,q2);
			
	}
	
	public static void print(Point[] x){
		for(Point point: x){
			System.out.println(point.getX() + ", " + point.getY());
		}
	}
	
	
	public static Pair getClosestPair(Point[] points){
		double temp =distance(points[0],points[1]);
		Point p1 = points[0];
		Point p2 = points[1];
		
		for(int i = 1; i < points.length; i ++){
			
			for(int j = (1+i); j < points.length; j ++){
				
				if(distance(points[i],points[j]) < temp){
					temp = distance(points[i],points[j]);
					p1 = points[i];
					p2 = points[j];
				}
			
			}
		
		}
		
		return new Pair(p1, p2);
	
	}
	
	public static Pair distance(Point[] pointsOrderedOnX,
	double low, double high, Point[] pointsOrderedOnY){
		return null; //TODO fill that
	}
	
	
	public static double distance(Point p1, Point p2){
		return (int)Math.sqrt(Math.pow((p2.getX()-p1.getX()), 2)+Math.pow((p2.getY()-p1.getY()), 2));
	}
	

}


