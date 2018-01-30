package machine;

public class Items {
private String name = "";
private double price= 0;
private int quantity = 20;//max
	
public Items(String name, double price) {
		this.name = name;
		this.price = price;
	}
	double getPrice(){
		return price;
	}
	
	int getQuantity(){
		return quantity;
	}
	
	String getName(){
		return name;
	}
	
	void refill(){
		quantity = 20;
	}
	
	void buy(){
		quantity--;
	}

}
