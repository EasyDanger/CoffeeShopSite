package co.easydanger.coffeeShop.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Coffee extends MenuItem {

	private Size size;
	private Boolean caffeine = true;

	public void setSmall() {
		this.setPrice(Math.floor(this.getPrice() * 0.8) + 0.99);
		this.size = Size.SMALL;
	}

	public void setLarge() {
		this.setPrice(Math.floor(this.getPrice() * 1.2) + 0.99);
		this.size = Size.LARGE;
	}

	public void setMedium() {
		this.size = Size.MEDIUM;
	}

	public Size getSize() {
		return size;
	}

	public void setCaf() {
		if (this.caffeine) {
			this.caffeine = false;
		} else {
			this.caffeine = true;
		}
	}

	public Boolean getCaffeine() {
		return this.caffeine;
	}
}
