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
		insertSql1 ="insert into artworks values(?,?)";
		try {
        jdbcTemplate.update(insertSql1,new Object[]{artwork.getAcno(),artwork.getTitle()});
		}
		catch(Exception e)
		    {
		       // System.out.println(e);
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
	
	
	@Override
    public void addMovement(List<Movement> movements, String artistId) {
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
			insertSql2 ="insert into artwork_movements values(?,?)";
			try {
	        jdbcTemplate.update(insertSql2,new Object[]{artistId,m.getId()});
			}
			catch(Exception e)
			    {
			        //System.out.println(e);
			    }
		}
	}
	
	@Override
    public void addArtists(List<Contributors> contributors, String artworkId) {
        // implementation details goes here...
		
		for (int i = 0; i < contributors.size(); i++) {
		    Contributors m = contributors.get(i);
		    
		    String insertSql1 ;
			insertSql1 ="insert into artwork_artist values(?,?)";
			try {
	        jdbcTemplate.update(insertSql1,new Object[]{artworkId,m.getId()});
			}
			catch(Exception e)
			    {
			        //System.out.println(e);
			    }
		    
			
	}
}
}