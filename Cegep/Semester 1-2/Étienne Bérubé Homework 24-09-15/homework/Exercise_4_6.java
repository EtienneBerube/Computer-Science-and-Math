package homework;

public class Exercise_4_6 
{

	public static void main(String[] args) 
	{
		double angleA1;
		double angleB1;
		double angleC1;
		
		double x1;
		double y1;
		double x2;
		double y2;
		double x3;
		double y3;
		
		double distance1_2;
		double distance1_3;
		double distance2_3;
		
		final double RADIUS = 40;
		
		double angleA2;
		double angleB2;
		double angleC2;
		
		angleA1 = Math.toRadians(Math.random()*360);
		angleB1 = Math.toRadians(Math.random()*360);
		angleC1 = Math.toRadians(Math.random()*360);
		
		x1 = RADIUS * Math.cos(angleA1);
		y1 = RADIUS * Math.cos(angleA1);
		
		x2 = RADIUS * Math.cos(angleB1);
		y2 = RADIUS * Math.cos(angleB1);
		
		x3 = RADIUS * Math.cos(angleC1);
		y3 = RADIUS * Math.cos(angleC1);
		
		distance1_2 = Math.sqrt( (Math.pow((x2 - x1),2) + Math.pow((y2 - y1),2) ));
		distance1_3 = Math.sqrt( (Math.pow((x3 - x1),2) + Math.pow((y3 - y1),2) ));
		distance2_3 = Math.sqrt( (Math.pow((x3 - x2),2) + Math.pow((y3 - y2),2) ));
		
		angleA2 = Math.acos((distance1_2 *distance1_2 - distance1_3 * distance1_3 - distance2_3 * distance2_3 )/ (-2 * distance1_3 * distance2_3));
		angleB2 = 15;
		angleC2 = 15;
		
	
		
		

	}

}
