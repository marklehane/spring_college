package ie.cit.assignment1;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcArtistRepository  implements CommandLineRunner {
	
private Artist artist;

@Autowired
JdbcTemplate jdbcTemplate;

public void setDataSource(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
}


@Override
public void run(String... arg0) throws Exception {
	// TODO Auto-generated method stub
	save();
}
	
	public JdbcArtistRepository(Artist artist){
		
		setArtist(artist);
	}

	public void save()
	{
		
		// Query for a list of maps with key-value pairs
		// The hard way!!!
			
		System.out.println("\nQuery 1 (List all artists using resultset Map)\n----------------");
			
		String sql = "SELECT * FROM artists";
//		List<Map<String, Object>> resultSet = jdbcTemplate.queryForList(sql);
//			
//		for (Map<String, Object> row : resultSet) {
//			System.out.println("Name: " + row.get("fullName"));
//			System.out.println("ID: " + row.get("id"));
//			System.out.println("Gender: " + row.get("gender") + "\n");
//		}
//
//
	System.out.println("testing"+ artist.getMovements() +
			artist.getFullName() );
		
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	


}

