package hairSalon;

public class Customer {
	String name;
	int hairLength;
	
	public String getName() {
		return name;
	}

	public Customer(String name, int hairLength) {
		this.name = name;
		this.hairLength = hairLength;
	}

	public int getHairLength() {
		return hairLength;
	}
}
