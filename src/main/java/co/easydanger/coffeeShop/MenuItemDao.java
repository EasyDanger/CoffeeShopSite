package co.easydanger.coffeeShop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MenuItemDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<MenuItem> findAll() {
	
		return jdbcTemplate.query("SELECT * FROM menuitem", new BeanPropertyRowMapper<>(MenuItem.class));

	}
	public MenuItem findById(Long id) {
		// The last parameters of .query let us specify values for the (?) parameters in our SQL statement.
		// While .query returns a list, .queryForObject assumes only one result. 
		MenuItem match = jdbcTemplate.queryForObject("SELECT * FROM menu_item WHERE id = ?", new BeanPropertyRowMapper<>(MenuItem.class), id);
		// If nothing matched, match will be null.
		return match;
	}
	
	public void update(MenuItem item) {
		String sql = "UPDATE menu_item SET name = ?, capacity = ?, available = ? WHERE id = ?";
		// Use .update for SQL INSERT, UPDATE, and DELETE
		// All the parameters after the first specify values to fill in the ?s in the SQL.
		jdbcTemplate.update(sql, item.getName(), item.getDescription(), item.getPrice(), item.getId());
	}
	
	public void create(MenuItem item) {
		String sql = "INSERT INTO menu_item (name, capacity, available) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, item.getName(), item.getDescription(), item.getPrice());
	}
	
	public void delete(Long id) {
		String sql = "DELETE menu_item Room WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}
}

