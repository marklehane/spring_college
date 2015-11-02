package ie.cit.assignment1;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcArtistRepository implements ArtistDao {
 
    private JdbcTemplate jdbcTemplate;
 
    public JdbcArtistRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
 
  
 
    @Override
    public void delete(int contactId) {
        // implementation details goes here...
    }
 

	@Override
	public void saveOrUpdate(Artist artist) {
		// insert
        String sql = "INSERT INTO artists (fullname, gender)  VALUES (?, ?)";
        jdbcTemplate.update(sql, artist.getFullName(), artist.getGender());
		
	}

	@Override
	public Artist get(int contactId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Artist> list() {
		// TODO Auto-generated method stub
		return null;
	}
 
}