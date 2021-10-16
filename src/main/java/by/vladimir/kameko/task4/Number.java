package by.vladimir.kameko.task4;

public class Number {


	private String[] formatNumber;
	private boolean isHighest;

	public Number(String[] formatNumber, boolean isHighest) {
		this.formatNumber = formatNumber;
		this.isHighest = isHighest;
	}


	public String[] getFormatNumber() {
		return formatNumber;
	}

	public boolean isHighest() {
		return isHighest;
	}

	public void setHighest(boolean highest) {
		isHighest = highest;
	}
}
