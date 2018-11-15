package co.easydanger.coffeeShop.dao;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.easydanger.coffeeShop.entity.Customer;

@Repository
@Transactional
public class CustomerDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Customer> findAll() {
		return em.createQuery("FROM Customer", Customer.class).getResultList();
	}
	
	public Customer findById(Long id) {
		return em.find(Customer.class, id);
	}
	
	public Customer findByName(String name) {
		try {
			return em.createQuery("FROM Customer WHERE name = :name", Customer.class).setParameter("name", name)
					.getSingleResult();
		} catch (NullPointerException ex) {
			Customer cust = new Customer();
			return cust;
		}
	}
	
	public void update(Customer item) {
		em.merge(item);
	}

	public void create(Customer item) {
		em.persist(item);
	}

	public void delete(Long id) {
		Customer cust = em.getReference(Customer.class, id);
		em.remove(cust);
	}

	public Set<String> findAllNames() {
		List<String> nameList = em.createQuery("SELECT DISTINCT name FROM Customer", String.class).getResultList();
		return new TreeSet<>(nameList);
	}
}
