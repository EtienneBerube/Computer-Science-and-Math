package PriceSorter;

public class Item {

	private ItemType type;
	private double price;
	private String brand;
	
	Item(ItemType itype, double iprice, String ibrand) {
		type = itype;
		price = iprice;
		brand = ibrand;
	}

	public enum ItemType {
	    JUICE, SOUP, COOKIES, BREAD,
	    VEGETABLES, MEAT, FRUIT 
	}
	
	public double getPrice() {
		return price;
	}
	
	public ItemType getType() {
		return type;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setPrice(double newPrice) {
		price = newPrice;
	}
	
	public void setType(ItemType newType) {
		type = newType;
	}
	
	public void setBrand(String newBrand) {
		brand = newBrand;
	}
}
