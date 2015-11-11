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
import org.springframework.jdbc.datasource.DriverManagerDataSource;

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
		        		    }
	}
	

	

	@Override
	public Artwork get(String Id) {
		Artwork artwork = new Artwork();
		Artist artist = new Artist();
		List<Movement> artworkMovements = new ArrayList<Movement>();
		
		String insertSql;
		insertSql ="SELECT * "
				+ "FROM artworks "
				+ "where artwork_id = '" + Id + "'";
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(insertSql);
		for (Map row : rows) {
			//artist.setId((Integer)(row.get("id")));
			artwork.setAcno((String)(row.get("artwork_id")));
			artwork.setTitle((String)(row.get("name")));
		}
		
			String insertSql4;
			insertSql4 ="SELECT movements.*, artwork_movements.* "
					+ "FROM movements INNER JOIN artwork_movements "
					+ "on artwork_movements.movement_id = movements.id "
					+ "where artwork_movements.artwork_id = '" + Id + "'";
			
			
			List<Map<String, Object>> rows4 = jdbcTemplate.queryForList(insertSql4);
			for (Map row1 : rows4) 
			{
				Movement artworkMovement = new Movement();
				artworkMovement.setId((Integer)(row1.get("id")));
				artworkMovement.setName((String)(row1.get("name")));
				artworkMovements.add(artworkMovement);
			}
			
			String insertSql5;
			insertSql5 ="SELECT artists.*, artwork_artist.* "
					+ "FROM artists INNER JOIN artwork_artist "
					+ "on artwork_artist.artist_id = artists.id "
					+ "where artwork_artist.artwork_id = '" + Id + "'";
			
			List<Map<String, Object>> rows5 = jdbcTemplate.queryForList(insertSql5);
			for (Map row2 : rows5) 
			{
				artist.setFullName((String)(row2.get("fullname")));
			}
			
		artwork.setMovements(artworkMovements);
		artwork.setArtist(artist);
		return artwork;
	}

	@Override
	public List<Artwork> list() {
		String insertSql1 ;
		insertSql1 ="SELECT artworks.*, artwork_artist.artist_id FROM artworks left join Artwork_artist on artworks.artwork_id = artwork_artist.artwork_id limit 40"
;
		List<Artwork> artworks = new ArrayList<Artwork>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(insertSql1);
		for (Map row : rows) {
			Artwork artwork = new Artwork();
			artwork.setAcno((String)(row.get("artwork_id")));
			artwork.setTitle((String)(row.get("name")));
			artwork.setArtistName(getArtistName((Integer)(row.get("artist_id"))));
			artworks.add(artwork);
		}
		
		
			
		return artworks;
	}
	
	public String getArtistName(int artistID){
		String selectSql = "SELECT fullname FROM `artists` WHERE id = '" + artistID + "'";
		
		 List<String> name = jdbcTemplate.queryForList(selectSql, String.class); 
		    if (name.isEmpty()) {
		        return null;
		    } else {
		        return name.get(0);
		    }
		

	}
	
	
	@Override
    public void addMovement(List<Movement> movements, String artistId) {
        // implementation details goes here...
		if(movements != null){
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
	}
	
	@Override
    public void addArtists(List<Contributors> contributors, String artworkId) {
        // implementation details goes here...
		if (!contributors.isEmpty()){
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
	
	public static DriverManagerDataSource getDataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://localhost/assignment1");
	    dataSource.setUsername("root");
	    dataSource.setPassword("");
	    return dataSource;
	}
}