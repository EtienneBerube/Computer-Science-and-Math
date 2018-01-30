package game;

public class Player {
	private String name;
	private String gender;
	private byte age;
	private int account;
	private Hand hand = new Hand();
	
	public Player(String name, String gender, byte age, int baseAccount){
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.account = baseAccount;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}
	
	public String toString(){
		return name + " " + account+ "$";
	}

	
}
