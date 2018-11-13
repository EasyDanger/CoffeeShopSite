package co.easydanger.coffeeShop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<User> findAll() {
	
		return jdbcTemplate.query("SELECT * FROM users", new BeanPropertyRowMapper<>(User.class));

	}
	public User findById(Long id) {
		// The last parameters of .query let us specify values for the (?) parameters in our SQL statement.
		// While .query returns a list, .queryForObject assumes only one result. 
		User match = jdbcTemplate.queryForObject("SELECT * FROM users WHERE id = ?", new BeanPropertyRowMapper<>(User.class), id);
		// If nothing matched, match will be null.
		return match;
	}
	
	public void update(User item) {
		String sql = "UPDATE users SET name = ?, fname = ?, lname = ?, email = ?, phone = ?, pword = ? WHERE id = ?";
		// Use .update for SQL INSERT, UPDATE, and DELETE
		// All the parameters after the first specify values to fill in the ?s in the SQL.
		jdbcTemplate.update(sql, item.getName(), item.getFname(), item.getLname(), item.getEmail(), item.getPhone(), item.getPword(), item.getId());
	}
	
	public void create(User item) {
		String sql = "INSERT INTO users (name, fname, lname, email, phone, pword) VALUES (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, item.getName(), item.getFname(), item.getLname(), item.getEmail(), item.getPhone(), item.getPword());
	}
	
	public void delete(Long id) {
		String sql = "DELETE FROM users WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}
}

