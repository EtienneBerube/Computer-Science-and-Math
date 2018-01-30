package exercises;

import java.util.Comparator;

public class CompareY implements Comparator<Point>{
	
	public int compare(Point x, Point y){
		if(x.getY() < y.getY())
			return -1;
		else if (x.getY() > y.getY())
			return 1;
		else {
			if(x.getX() < y.getX())
				return -1;
			else if (x.getX() > y.getX())
				return 1;
			else {
				return 0;
			}
		}
	}
}
