package ie.cit.assignment1;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jca.cci.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class JdbcArtworkRepository implements ArtworkDao {
 
    private JdbcTemplate jdbcTemplate;


    public JdbcArtworkRepository(DataSource dataSource) {
    	this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
 
    @Override
    public void delete(int contactId) {
        // implementation details goes here...
    }
 
	@Override
	public void saveOrUpdate(Artwork artwork) {
		
		String insertSql1 ;
		insertSql1 ="insert into artists values(?)";
		try {
        jdbcTemplate.update(insertSql1,new Object[]{artwork.getContributors()});
		}
		catch(Exception e)
		    {
		        System.out.println(e);
		    }
	}

	@Override
	public Artwork get(int Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Artwork> list() {
		// TODO Auto-generated method stub
		return null;
	}
 
}