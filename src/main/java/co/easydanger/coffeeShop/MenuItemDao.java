package co.easydanger.coffeeShop;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class MenuItemDao {

	@PersistenceContext
	private EntityManager em;
	
	public List<MenuItem> findAll() {
	
		return em.createQuery("FROM MenuItem", MenuItem.class).getResultList();

	}
	public MenuItem findById(Long id) {
		return em.find(MenuItem.class, id);
	}
	
	public MenuItem findByName(String name) {
		return em.createQuery("FROM MenuItem WHERE name = :name", MenuItem.class).setParameter("name", name).getSingleResult();
	}
	
	public void update(MenuItem item) {
		em.merge(item);
	}
	
	public void create(MenuItem item) {
		em.persist(item);
	}
	
	public void delete(Long id) {
		MenuItem item = em.getReference(MenuItem.class,  id);
		em.remove(item);
	}

	public Set<String> findAllNames() {
		List<String> nameList = em.createQuery("SELECT DISTINCT name FROM MenuItem", String.class).getResultList();
	return new TreeSet<>(nameList);
	
	}
}

