package exercises;

public class Point implements Comparable<Point>{
int x;
int y;
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		public int getX(){
			return x;
		}
		
		public int getY(){
			return y;
		}
		
		public int compareTo(Point x){
			if(this.x < x.getX()){
				return -1;
			}else if((this.x) > x.getX()){
				return 1;
			}else
				if(this.y < x.getY()){
					return -1;
				}else if(this.y > x.getY()){
					return 1;
				}else
					return 0;					
		}
		
		@Override
		public String toString(){
			return"(x,"+" y)";
		}
}
