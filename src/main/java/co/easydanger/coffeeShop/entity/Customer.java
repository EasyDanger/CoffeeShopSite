package co.easydanger.coffeeShop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name = "";
	private String firstName = "";
	private String lastName = "";
	private String email = "";
	private String pWord = "";
	private String cardNum = "";
//	@OneToOne(mappedBy = "cust")
//	public Cart cart = new Cart();
//	private Map<MenuItem, Integer> cart1 = new HashMap<MenuItem, Integer>();
	private Long githubId;

	public Customer() {
	}

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
//		this.cart = cart1;
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

//	public Map<MenuItem, Integer> getCart() {
//		return cart1;
//	}
//
//	public void addToCart(MenuItem mi) {
//		if (Vali.itemIsKey(mi, cart1)) {
//			Integer val = this.cart1.get(mi);
//			val += 1;
//			this.cart1.put(mi, val);
//		} else {
//			this.cart1.put(mi, 1);
//		}
//	}

	public Long getGithubId() {
		return githubId;
	}

	public void setGithubId(Long githubId) {
		this.githubId = githubId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getpWord() {
		return pWord;
	}

	public void setpWord(String pWord) {
		this.pWord = pWord;
	}

//	public void setCart(Map<MenuItem, Integer> cart) {
//		this.cart1 = cart;
//	}

//	public Cart getCart1() {
//		return cart;
//	}
//
//	public void setCart1(Cart cart1) {
//		this.cart = cart1;
//	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", pWord=" + pWord + ", cardNum=" + cardNum+ "]";
	}

}
