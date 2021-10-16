package by.vladimir.kameko.task5;

import java.util.List;
import java.util.stream.Collectors;

public class Safe {
	private List<Item> items;
	private int capacity;
	private double price;

	public Safe(List<Item> items, int capacity) {
		this.items = items;
		this.capacity = capacity;
	}


	public List<Item> getItems() {
		return items;
	}

	public int getCapacity() {
		return capacity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return items.size() == 0 ? "" : items.stream()
				.map(Item::getName)
				.collect(Collectors.joining("+")) + "-" + getPrice();
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Safe safe = (Safe) o;

		if (capacity != safe.capacity) return false;
		if (Double.compare(safe.price, price) != 0) return false;
		return items != null ? items.equals(safe.items) : safe.items == null;
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = items != null ? items.hashCode() : 0;
		result = 31 * result + capacity;
		temp = Double.doubleToLongBits(price);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
}