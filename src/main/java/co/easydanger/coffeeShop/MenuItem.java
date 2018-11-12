package co.easydanger.coffeeShop;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MenuItem implements Comparable<MenuItem> {
	private String name;
	private String description;
	private double price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int compareTo(MenuItem other) {
		// TODO Auto-generated method stub
		return name.compareTo(other.name);
	}

	public boolean checkName(String s) {
		return name.equalsIgnoreCase(s);
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.CEILING);
		return String.format("$%-6s%-20s%", df.format(price), name, description);
	}
}
