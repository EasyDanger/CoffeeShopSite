package co.easydanger.coffeeShop;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer qaunt;
	@OneToMany(mappedBy = "cart")
	private List<MenuItem> menuItems;


	public Cart(Long id, Integer qaunt) {
		super();
		this.id = id;
		this.qaunt = qaunt;
	}

	public Cart(Long id, Integer qaunt, List<MenuItem> menuItems) {
		super();
		this.id = id;
		this.qaunt = qaunt;
		this.menuItems = menuItems;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQaunt() {
		return qaunt;
	}

	public void setQaunt(Integer qaunt) {
		this.qaunt = qaunt;
	}

	public List<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}
}
