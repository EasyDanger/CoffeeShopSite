package co.easydanger.coffeeShop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import co.easydanger.coffeeShop.Cart;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name = "This";
	private String fname = "customer";
	private String lname = "doesn't";
	private String email = "exist";
	private String pword = "in the";
	private String cardNum = "database";
	private Cart cart;
	
	public Customer() {}
	
	public Customer(Long id, String name, String fname, String lname, String email, String pword, String cardNum,
			Cart cart) {
		super();
		this.id = id;
		this.name = name;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.pword = pword;
		this.cardNum = cardNum;
		this.cart = cart;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPword() {
		return pword;
	}

	public void setPword(String pword) {
		this.pword = pword;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	

}
