package by.vladimir.kameko.task5;

public class Item {
	private String name;
	private double price;
	private double volume;
	private double value;



	public Item(String name, double price, double value) {
		this.name = name;
		this.price = price;
		this.volume = value;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public double getVolume() {
		return volume;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public void setPrice(double price) {
		this.price = price;
	}




	@Override
	public String toString() {
		return "Item{" +
				", name='" + name + '\'' +
				", price=" + price +
				", volume=" + volume +
				", value=" + value +
				'}';
	}
}