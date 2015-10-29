package ie.cit.assignment1;



public class JdbcArtistRepository  {
	
private Artist artist;
	
	public JdbcArtistRepository(Artist artist){
		
		setArtist(artist);
	}

	public void save()
	{
	System.out.println("testing"+ artist.getMovements() +
			artist.getFullName());
		
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	


}

