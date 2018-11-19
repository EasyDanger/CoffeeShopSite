package co.easydanger.coffeeShop.dao;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.easydanger.coffeeShop.entity.Cart;
import co.easydanger.coffeeShop.entity.Customer;

@Repository
@Transactional
public class CartDao {
	
	@PersistenceContext
	private EntityManager em;

	public List<Cart> findAll() {
		return em.createQuery("From Cart", Cart.class).getResultList();
	}

	public Cart findById(Long id) {
		return em.find(Cart.class, id);
	}
	
	public Cart findByCust(Customer cust) {
		return em.createQuery("FROM Cart WHERE cust = :cust", Cart.class).setParameter("cust", cust).getSingleResult();
	}
	public List<Cart> findByCust(long cust) {
		return em.createQuery("FROM Cart WHERE customer_id = :cust", Cart.class).setParameter("cust", cust).getResultList();
	}
	
	public void addToCart() {
		
	}
	
	public void update(Cart item) {
		em.merge(item);
	}
	
	public void create(Cart item) {
		em.persist(item);
	}
	
	public void delete(Cart cart) {
		Long id = cart.getId();
		Cart item = em.getReference(Cart.class,  id);
		em.remove(item);
	}

	public Set<Customer> findAllCust() {
		List<Customer> custList = em.createQuery("SELECT DISTINCT cust FROM Cart", Customer.class).getResultList();
	return new TreeSet<>(custList);
	
	}

}
