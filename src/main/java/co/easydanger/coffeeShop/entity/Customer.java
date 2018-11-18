package co.easydanger.coffeeShop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name = "";
	private String firstName = "";
	private String lastName = "";
	private String email = "";
	private String pWord = "";
	private String cardNum = "";
	@OneToOne(mappedBy = "cust")
	private Cart cart;
	private Long githubId;
	
	public Customer() {}
	
	public Customer(Long id, String name, String fname, String lname, String email, String pword, String cardNum,
			Cart cart) {
		super();
		this.id = id;
		this.name = name;
		this.firstName = fname;
		this.lastName = lname;
		this.email = email;
		this.pWord = pword;
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
		return firstName;
	}

	public void setFname(String fname) {
		this.firstName = fname;
	}

	public String getLname() {
		return lastName;
	}

	public void setLname(String lname) {
		this.lastName = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPword() {
		return pWord;
	}

	public void setPword(String pword) {
		this.pWord = pword;
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

	public Long getGithubId() {
		return githubId;
	}

	public void setGithubId(Long githubId) {
		this.githubId = githubId;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", pWord=" + pWord + ", cardNum=" + cardNum + ", cart=" + cart + "]";
	}
	

}
