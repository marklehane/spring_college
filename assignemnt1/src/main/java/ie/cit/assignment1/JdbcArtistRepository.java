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

public class JdbcArtistRepository implements ArtistDao {
 
    private JdbcTemplate jdbcTemplate;


    public JdbcArtistRepository(DataSource dataSource) {
    	this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
 
  
 
    @Override
    public void delete(int contactId) {
        // implementation details goes here...
    }
 

	@Override
	public void saveOrUpdate(Artist artist) {

		
		 String insertSql1 ;
		insertSql1 ="insert into artists values(?,?,?)";
		try {
        jdbcTemplate.update(insertSql1,new Object[]{artist.getId(),artist.getFullName(), artist.getGender()});
		}
		catch(Exception e)
		    {
		        //System.out.println(e);
		    }
		
		 String insertSql2 ;
			insertSql2 ="insert into birth values(?,?,?,?)";
			try {
	        jdbcTemplate.update(insertSql2,new Object[]{artist.getId(),artist.getBirthYear(),artist.getBirth().getPlace().getPlaceName(), artist.getId()});
			}
			catch(Exception e)
			    {
			        //System.out.println(e);
			    }
		
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
	
	@Override
    public void addMovement(List<Movement> movements, long artistId) {
        // implementation details goes here...
		
		for (int i = 0; i < movements.size(); i++) {
		    Movement m = movements.get(i);
		    
		    String insertSql1 ;
			insertSql1 ="insert into movements values(?,?)";
			try {
	        jdbcTemplate.update(insertSql1,new Object[]{m.getId(),m.getName()});
			}
			catch(Exception e)
			    {
			       // System.out.println(e);
			    }
		    
			String insertSql2 ;
			insertSql2 ="insert into artist_movements values(?,?)";
			try {
	        jdbcTemplate.update(insertSql2,new Object[]{m.getId(),artistId});
			}
			catch(Exception e)
			    {
			       // System.out.println(e);
			    }
		}
	}
	
	
}
 
