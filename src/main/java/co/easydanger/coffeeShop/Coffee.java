package co.easydanger.coffeeShop;

public class Coffee extends MenuItem {

	private Size size = Size.MEDIUM; 
	
	public void setSmall() {
		this.setPrice(Math.floor(this.getPrice() * 0.8) + 0.99);
		this.size = Size.SMALL;
	}

	public void setLarge() {
		this.setPrice(Math.floor(this.getPrice() * 1.2) + 0.99);
		this.size = Size.LARGE;		
	}

	public Size getSize() {
		return size;
	}
	

}
