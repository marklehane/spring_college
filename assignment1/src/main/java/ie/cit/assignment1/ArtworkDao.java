package ie.cit.assignment1;

import java.util.List;
 
public interface ArtworkDao {
     
    public void saveOrUpdate(Artwork artwork);
     
    public void delete(int Id);
     
    public Artwork get(int Id);
     
    public List<Artwork> list();

	void addMovement(List<Movement> movements, String artworkId);


	void addArtists(List<Contributors> contributors, String artworkId);
}

