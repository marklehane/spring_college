package ie.cit.assignment1;



public class JdbcArtworkRepository {
	
	private Artwork artwork;
	
	public JdbcArtworkRepository(Artwork artwork){
		
		setArtwork(artwork);
	}

	public void save()
	{
	System.out.println("testing"+ artwork.getMovements() +
	artwork.getClassification());
		
	}

	public Artwork getArtwork() {
		return artwork;
	}

	public void setArtwork(Artwork artwork) {
		this.artwork = artwork;
	}
	
	

}
