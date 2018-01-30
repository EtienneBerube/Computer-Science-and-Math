import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String stringTime = input.next();
		int hours = Integer.parseInt(stringTime.substring(0, stringTime.indexOf(':')));
		int minutes = Integer.parseInt(stringTime.substring(stringTime.indexOf(':')+1));
		
		double distance = 0;
		int speedNonTraffic = 60;
		int speedTraffic = 30;
		String h = "";
		String m = "";
		
		while(distance <120){
			if(hours >= 7 && hours<10){
				distance += 0.5;
				minutes++;
			}else{
				distance +=1;
				minutes++;
			}
			
			if(minutes == 60){
				minutes = 0;
				hours += 1;
			}
			if(hours == 24){
				hours = 0;
			}
			
		}
		if(hours<10){
			h = "0"+hours;
		}else{
			h = ""+hours;
		}
		
		if(minutes<10){
			m = "0"+minutes;
		}else{
			m = "" + minutes;
		}
		
		System.out.print(h+":"+m);
		
		
	}

}
