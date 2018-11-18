package co.easydanger.coffeeShop.dao;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.easydanger.coffeeShop.entity.User;

@Repository
@Transactional
public class UserDao {

	@PersistenceContext
	private EntityManager em;

	public List<User> findAll() {
		return em.createQuery("FROM User", User.class).getResultList();
	}

	public User findById(Long id) {
		return em.find(User.class, id);
	}

	public User findByName(String name) {
		try {
			return em.createQuery("FROM User WHERE name = :name", User.class).setParameter("name", name)
					.getSingleResult();
		} catch (NullPointerException ex) {
			User user = new User();
			return user;
		}
	}

	public void update(User item) {
		em.merge(item);
	}

	public void create(User item) {
		em.persist(item);
	}

	public void delete(Long id) {
		User user = em.getReference(User.class, id);
		em.remove(user);
	}

	public Set<String> findAllNames() {
		List<String> nameList = em.createQuery("SELECT DISTINCT name FROM User", String.class).getResultList();
		return new TreeSet<>(nameList);
	}

}
