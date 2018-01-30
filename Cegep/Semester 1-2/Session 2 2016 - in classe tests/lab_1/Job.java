package lab_1;

/* make all necessary changes and additions to support natural order prioritizing of Job objects 
 * You will need to implement one interface and add its important method(s) */

public class Job implements Comparable<Job>{
	
	private int priority;
	private String task;
	private String userName;
	private static int num_jobs;
	
	public Job(int newPriority, String newUserName, String newTask){
		priority = newPriority;
		userName = newUserName;
		task = newTask;
		num_jobs++;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public String getUserName() {
		return userName;
	}
	
	
		

	@Override
	public String toString() {
		return (priority + " " + userName + " print file " + task); 
	}

	@Override
	public int compareTo(Job o) {

		if (this.priority == o.getPriority()){
			if ((this.getUserName()).compareTo(o.getUserName()) > 0){
				return 1;
			}else if((this.getUserName()).compareTo(o.getUserName()) < 0){
				return -1;
			}else{ 
				return 0;
			}
		}else if(this.priority > o.getPriority()){
			return 1;
		}else{ 
			return -1;
		}
	}
	
		
}
	

