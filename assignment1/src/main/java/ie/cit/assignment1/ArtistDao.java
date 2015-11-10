package ie.cit.assignment1;

import java.util.List;
 
public interface ArtistDao {
     
    public void saveOrUpdate(Artist artist);
     
    public void delete(int Id);
     
    public Artist get(int Id);
     
    public List<Artist> list();

	void addMovement(List<Movement> movements, long artistId);
}
