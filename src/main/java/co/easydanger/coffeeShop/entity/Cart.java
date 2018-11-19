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
	private Long menuId;
	private Integer quant = 1;
    private Long customerId;
    
    public Cart() {
    }
    
	public Cart(Long menuId, Long customerId) {
		super();
		this.menuId = menuId;
		this.customerId = customerId;
		}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getMenuId() {
		return menuId;
	}
	public void setMenuId(Long menuId) {
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
	public void addToCart(MenuItem mi) {

	}
	
	public void addQuant() {
		quant += 1;
	}

}
