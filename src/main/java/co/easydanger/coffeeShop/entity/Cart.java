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
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany(mappedBy = "cart")
	private List<MenuItem> menuItems = new ArrayList<>();
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id")
    private Customer cust;
	

	public Cart(Long id) {
		super();
		this.id = id;
	}

	public Cart(Long id, List<MenuItem> menuItems) {
		super();
		this.id = id;
		this.menuItems = menuItems;
	}

	public Cart() {
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

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}
}
