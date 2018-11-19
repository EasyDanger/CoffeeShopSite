package co.easydanger.coffeeShop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name = "This";
	private String fname = "user";
	private String lname = "doesn't";
	private String email = "exist";
	private String phone = "in the";
	private String pword = "database";
	private boolean admin = false;

	public User() {
	}

	public User(Long id, String name, String fname, String lname, String email, String phone, String pword) {
		this.id = id;
		this.name = name;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.phone = phone;
		this.pword = pword;

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPword() {
		return pword;
	}

	public void setPword(String pword) {
		this.pword = pword;
	}

	public boolean isAdmin() {
		return admin;
	}
	
	public void toggleAdmin() {
		if (this.admin) {
			this.admin = false;
		}
		else {
			this.admin = true;
		}
	}

	@Override
	public String toString() {
		return "firstName=" + fname + "lastName=" + lname + "&email=" + email + "&phone=" + phone + "&Name=" + name
				+ "&passWord=" + pword + admin;

	}

}
