package co.easydanger.coffeeShop.dao;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.easydanger.coffeeShop.entity.MenuItem;

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
		try {
			return em.createQuery("FROM MenuItem WHERE name = :name", MenuItem.class).setParameter("name", name)
					.getSingleResult();
		} catch (NullPointerException ex) {
			MenuItem mi = new MenuItem();
			mi.setName("Nope");
			return mi;
		} catch (NoResultException ex) {
			MenuItem mi = new MenuItem();
			mi.setName("Nope");
			return null;
		}
	}


	public void update(MenuItem item) {
		em.merge(item);
	}

	public void create(MenuItem item) {
		em.persist(item);
	}

	public void delete(Long id) {
		MenuItem item = em.getReference(MenuItem.class, id);
		em.remove(item);
	}

	public Set<String> findAllNames() {
		List<String> nameList = em.createQuery("SELECT DISTINCT name FROM MenuItem", String.class).getResultList();
		return new TreeSet<>(nameList);

	}
}
