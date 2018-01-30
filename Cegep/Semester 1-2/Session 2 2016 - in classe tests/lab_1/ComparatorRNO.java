package lab_1;

import java.util.Comparator;

//RNO stands for reverse natural order

public class ComparatorRNO implements Comparator<Job>{

	@Override
	public int compare(Job x, Job y) {
		if (x.getPriority() == y.getPriority()){
			if ((x.getUserName()).compareTo(y.getUserName()) > 0){
				return -1;
			}else if((x.getUserName()).compareTo(y.getUserName()) < 0){
				return 1;
			}else{ 
				return 0;
			}
		}else if(x.getPriority() > y.getPriority()){
			return -1;
		}else{ 
			return 1;
		}
	}

}
