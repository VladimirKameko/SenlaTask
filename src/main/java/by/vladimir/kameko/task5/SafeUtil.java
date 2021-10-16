package by.vladimir.kameko.task5;


import java.util.Arrays;


public class SafeUtil {

	private Safe safe;
	private Item[] items;


	public SafeUtil(Safe safe, Item[] items) {
		this.safe = safe;
		this.items = items;
	}

	public Safe getSafe() {
		return safe;
	}


	public void fillingSafeCorrect() {
		double priceSafe = 0;
		double capacitySafe = safe.getCapacity();
		for (Item i : items) {
			double val = i.getPrice() / i.getVolume();
			i.setValue(val);
		}

		Arrays.sort(items, new VolumeComparator());
		for (Item i : items) {
			if (i.getVolume() <= capacitySafe) {
				safe.getItems().add(i);
				capacitySafe = capacitySafe - i.getVolume();
				priceSafe = priceSafe + i.getPrice();
			}
		}
		safe.setPrice(priceSafe);

	}

}




