package by.vladimir.kameko.task5;

import java.util.Comparator;

class VolumeComparator implements Comparator<Item> {

	@Override
	public int compare(Item a, Item b) {
		return Double.compare(b.getValue(), a.getValue());
	}
}
