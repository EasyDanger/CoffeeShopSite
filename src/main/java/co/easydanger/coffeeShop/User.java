package co.easydanger.coffeeShop;

public class User {
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String name = "It's";
	private String fname = "Just";
	private String lname = "one";
	private String email = "more";
	private String phone = "empty";
	private String pword = "shell";

	public User() {
	}

	public User(String name, String fname, String lname, String email, String phone, String pword) {
	//	this.id = (long) 1;
		this.name = name;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.phone = phone;
		this.pword = pword;
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

	@Override
	public String toString() {
		return "firstName=" + fname + "lastName=" + lname + "&email=" + email + "&phone=" + phone + "&Name=" + name
				+ "&passWord=" + pword;

	}

}
