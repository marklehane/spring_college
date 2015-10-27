package ie.cit.assignment1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class JdbcArtworkRepository implements CommandLineRunner{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void run(String... arg0) throws Exception {

	}
	
	public void save()
	{
		
	}

}
