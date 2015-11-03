package ie.cit.assignment1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class JdbcArtistRepository implements ArtistDao {
 
    private SimpleJdbcInsert jdbcTemplate;


    public JdbcArtistRepository(DataSource dataSource) {
    	this.jdbcTemplate = new SimpleJdbcInsert(dataSource);
    }
 
  
 
    @Override
    public void delete(int contactId) {
        // implementation details goes here...
    }
 

	@Override
	public void saveOrUpdate(Artist artist) {
		// insert
		jdbcTemplate.withTableName("artists");

		List insertList = new ArrayList();
		insertList.add("id");
		insertList.add("fullname");
		insertList.add("gender");
		jdbcTemplate.setColumnNames(insertList);
		
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("id", artist.getId()); 
		parameters.put("fullname", artist.getFullName());
		parameters.put("gender", artist.getGender());
		Number key = jdbcTemplate.execute(new MapSqlParameterSource(parameters));
		
	

		
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