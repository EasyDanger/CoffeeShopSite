package co.easydanger.coffeeShop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String menuId;
	private Integer quant = 0;
	private Double price = 0.00;
    private Long customerId;
    
    public Cart() {
    }
    
	public Cart(String menuId, Long customerId) {
		super();
		quant += 1;
		this.menuId = menuId;
		this.customerId = customerId;
		}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public Integer getQuant() {
		return quant;
	}
	public void setQuant(Integer quant) {
		this.quant = quant;
	}
	public Long getCust() {
		return customerId;
	}
	public void setCust(Long customerId) {
		this.customerId = customerId;
	}
	
	public void addQuant() {
		this.quant += 1;
	}
	public void setPrice(MenuItem mi) {

		Double p = mi.getPrice();
		this.price = this.quant * p;
	}
	public Double getPrice() {
		return this.price;
	}

	public void minusQuant() {
		this.quant -=1;
		
	}

}
