package co.easydanger.coffeeShop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Cart1 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany(mappedBy = "cart")
	private List<MenuItem> menuItems = new ArrayList<>();
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id")
    private Customer cust;
	

	public Cart1(Long id) {
		super();
		this.id = id;
	}

	public Cart1(Long id, List<MenuItem> menuItems) {
		super();
		this.id = id;
		this.menuItems = menuItems;
	}

	public Cart1() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}
	
	public void addToList(MenuItem mi) {
		this.menuItems.add(mi);
	}
	
	public void removeList(MenuItem mi) {
		for (MenuItem item: this.menuItems) {
			if (item.equals(mi)) {
				this.menuItems.remove(item);
				break;
			}
		}
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}
	
	@Override
	public String toString() {
		
		return "list:" + menuItems.get(0);
	}
}
