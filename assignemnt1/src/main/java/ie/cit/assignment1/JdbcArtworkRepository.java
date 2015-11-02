package ie.cit.assignment1;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
@SpringBootApplication
public class JdbcArtworkRepository implements CommandLineRunner {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void run(String... arg0) throws Exception {
		query01();
	}
	
	public void query01() {
		// Query for a list of maps with key-value pairs
		// The hard way!!!
			
		System.out.println("\nQuery 1 (List all artists using resultset Map)\n----------------");
			
		String sql = "SELECT * FROM artworks";
		List<Map<String, Object>> resultSet = jdbcTemplate.queryForList(sql);
			
		for (Map<String, Object> row : resultSet) {
			System.out.println("ID: " + row.get("artwork_id"));
			System.out.println("Name: " + row.get("name"));
			System.out.println("Artist: " + row.get("artist") + "\n");
		}
	}
}
