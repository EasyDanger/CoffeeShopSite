package co.easydanger.coffeeShop.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="product_type", 
discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue("0")
public class MenuItem implements Comparable<MenuItem> {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private Double price;
	@ManyToOne
	private Cart cart;

	public MenuItem() {
	}
	
	public MenuItem(Long id, String name, String description, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public MenuItem(String item, Double price2, String desc) {
		this.name = item;
		this.price = price2;
		this.description = desc; 
	}

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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int compareTo(MenuItem other) {
		// TODO Auto-generated method stub
		return name.compareTo(other.name);
	}

	public boolean checkName(MenuItem s) {
		return this.name.equalsIgnoreCase(s.name);
	}

//	@Override
//	public String toString() {
//		DecimalFormat df = new DecimalFormat("0.00");
//		df.setRoundingMode(RoundingMode.CEILING);
//		return String.format("$%-6s%-20s%",  df.format(price), name, description);
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
