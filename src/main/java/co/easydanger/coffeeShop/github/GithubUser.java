package co.easydanger.coffeeShop.github;

import co.easydanger.coffeeShop.entity.Customer;

/**
 * Used internally by GithubService.
 */
class GithubCust {
	private Long id;
	private String name;

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

	public void copyToCust(Customer cust) {
		cust.setGithubId(id);
		cust.setName(name);
	}

}