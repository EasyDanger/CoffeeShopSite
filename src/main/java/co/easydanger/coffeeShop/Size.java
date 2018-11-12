/**
 * 
 */
package co.easydanger.coffeeShop;

/**
 * @author EasyDanger
 *
 */
public enum Size {
	SMALL, MEDIUM, LARGE;

	public String toString() {
		if (this == SMALL) {
			return "Small";
		} else if (this == LARGE) {
			return "Large";
		} else {
			return "Medium";
		}
	}
}
