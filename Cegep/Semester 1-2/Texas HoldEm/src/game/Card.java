package game;

public class Card implements Comparable<Card>{
	
	private String face;
	private int value;
	private String color;
	private String symbole;
	
	public Card(int value, String color, String symbole ){
		this.value = value;
		this.color = color;
		this.symbole= symbole;
		
		if(value == 1)
			face = "A";
		else if(value==11)
			face = "Bishop"; // change name
		else if(value == 12)
			face = "Queen";
		else if(value == 13)
			face = "King";
		else 
			face = ""+value;
	}
	
	public int getValue(){
		return value;
	}
	
	public void setValue(int x){
		value=x;
		
		if(value == 1)
			face = "A";
		else if(value==11)
			face = "Bishop"; // change name
		else if(value == 12)
			face = "Queen";
		else if(value == 13)
			face = "King";
		else 
			face = ""+value;
	}
	
	public String getColor(){
		return color;
	}
	
	public void setColor(String color){
		this.color = color;
	}
	
	public void setSymbole(String symbole){
		this.symbole = symbole;
	}
	
	public String getSymbole(){
		return symbole;
	}
	
	@Override
	public String toString(){
		return face +" of " + symbole;
		
	}

	@Override
	public int compareTo(Card arg0) {
		
		if(this.value > arg0.getValue())
			return 1;
		else if(this.value < arg0.getValue()) 
			return -1;
		else
			return 0;

	}
}
