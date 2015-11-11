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
	public Artist get(int artistId) {
		String insertSql;
		insertSql ="SELECT artists.*, birth.* "
				+ "FROM artists LEFT JOIN birth "
				+ "on artists.id = birth.artist_id "
				+ "where artists.id = '" + artistId + "'";
		Artist artist = new Artist();
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(insertSql);
		for (Map row : rows) {
			artist.setId((Integer)(row.get("id")));
			artist.setFullName((String)(row.get("fullname")));
		
			artist.setGender((String)(row.get("gender")));
	if (row.get("place") == null ){
		artist.setPlaceName((String)("No Data Availiable "));
			}else{
				artist.setPlaceName((String)(row.get("place")));
			}
	
	if (row.get("date") == null ){
		artist.setBirthYear((Integer)(0000));
			}else{
				artist.setBirthYear((Integer)(row.get("date")));
			}
			
		}
		
		String insertSql2;
		insertSql2 ="SELECT movements.*, artist_movements.* "
				+ "FROM artist_movements INNER JOIN movements "
				+ "on artist_movements.movement_Id = movements.id "
				+ "where artist_movements.artist_id = '" + artistId + "'";
		
		List<Movement> movements = new ArrayList<Movement>();
		
		List<Map<String, Object>> rows2 = jdbcTemplate.queryForList(insertSql2);
		for (Map row : rows2) {
			Movement movement = new Movement();
			movement.setId((Integer)(row.get("id")));
			movement.setName((String)(row.get("name")));
			movements.add(movement);
		}
		
		String insertSql3;
		insertSql3 ="SELECT artworks.*, artwork_artist.* "
				+ "FROM artworks INNER JOIN artwork_artist "
				+ "on artwork_artist.artwork_id = artworks.artwork_id "
				+ "where artwork_artist.artist_id = '" + artistId + "'";
		
		List<Artwork> artworks = new ArrayList<Artwork>();
		
		List<Map<String, Object>> rows3 = jdbcTemplate.queryForList(insertSql3);
		for (Map row : rows3) 
		{
			Artwork artwork = new Artwork();
			List<Movement> artworkMovements = new ArrayList<Movement>();
			artwork.setAcno((String)(row.get("artwork_id")));
			artwork.setTitle((String)(row.get("name")));
			
				String insertSql4;
				insertSql4 ="SELECT movements.*, artwork_movements.* "
						+ "FROM movements INNER JOIN artwork_movements "
						+ "on artwork_movements.movement_id = movements.id "
						+ "where artwork_movements.artwork_id = '" + row.get("artwork_id") + "'";
				
				
				List<Map<String, Object>> rows4 = jdbcTemplate.queryForList(insertSql4);
				for (Map row1 : rows4) 
				{
					Movement artworkMovement = new Movement();
					artworkMovement.setId((Integer)(row1.get("id")));
					artworkMovement.setName((String)(row1.get("name")));
					artworkMovements.add(artworkMovement);
				}
			artwork.setMovements(artworkMovements);
			artworks.add(artwork);
		}
		
		artist.setMovements(movements);
		artist.setArtworks(artworks);
		return artist;
	}


	@Override
	public List<Artist> list() {
		String insertSql2 ;
		insertSql2 ="SELECT * FROM `artists` LIMIT 40";
		List<Artist> artists = new ArrayList<Artist>();
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(insertSql2);
		for (Map row : rows) {
			Artist artist = new Artist();
			artist.setId((Integer)(row.get("id")));
			artist.setFullName((String)(row.get("fullname")));
			artist.setGender((String)(row.get("gender")));
			artists.add(artist);
		}
			
		return artists;
		
		
		
		
	}
	
	@Override
    public void addMovement(List<Movement> movements, long artistId) {
        // implementation details goes here...
		
		for (int i = 0; i < movements.size(); i++) {
		    Movement m = movements.get(i);
		    
		    //count number of rows in movements table with movements id to see if it is already in table
		    int rowCount = this.jdbcTemplate.queryForObject("select count(*) from movements where id = " + m.getId(), Integer.class);
		    
		    //if movement count is 0 then movement doesn't exist already so add it
		    if (rowCount == 0)
		    {
			    String insertSql1 ;
				insertSql1 ="insert into movements values(?,?)";
				try {
		        jdbcTemplate.update(insertSql1,new Object[]{m.getId(),m.getName()});
				}
				catch(Exception e)
				    {
				       // System.out.println(e);
				    }
		    }
		    
			String insertSql2 ;
			insertSql2 ="insert into artist_movements values(?,?)";
			try {
	        jdbcTemplate.update(insertSql2,new Object[]{artistId, m.getId()});
			}
			catch(Exception e)
			    {
			       // System.out.println(e);
			    }
		}
	}
	
	
}
 
