package ie.cit.assignment1;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcArtworkRepository implements CommandLineRunner {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
	    this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	private Artwork artwork;
	
	public JdbcArtworkRepository(Artwork artwork){
		
		setArtwork(artwork);
	}

	public void save()
	{
	
		// Query for a list of maps with key-value pairs
				
					
				System.out.println("\nQuery 1 (List all artists using resultset Map)\n----------------");
					
				String sql = "SELECT * FROM artwork";
				List<Map<String, Object>> resultSet = jdbcTemplate.queryForList(sql);
					
				for (Map<String, Object> row : resultSet) {
					System.out.println("Name: " + row.get("name"));
					System.out.println("ID: " + row.get("artwork_id"));
					System.out.println("artist: " + row.get("artist") + "\n");
				}


			
		
	System.out.println("testing"+ artwork.getMovements() +
	artwork.getClassification());
		
	}

	public Artwork getArtwork() {
		return artwork;
	}

	public void setArtwork(Artwork artwork) {
		this.artwork = artwork;
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		save();
		
	}
	
	

}
