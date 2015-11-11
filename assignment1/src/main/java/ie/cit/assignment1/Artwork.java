package ie.cit.assignment1;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@SpringBootApplication
public class Artwork {
	private String title;
	private String acno;
	private String classification;
	private int movementCount;
	private Artist artist;
	private String artistName;
	List<Contributors> contributors ;
	List<Movement> movements ;
	@Override
	public String toString() {
			
		String artworkAsString = "Id: " + acno +"\nTitle: " + title +"\nClassification: " + classification +"\nMovements:"+ movements +"\nContributors ID's:"+ contributors;
		
		return artworkAsString;
		
	}
	
	public List<Movement> getMovements() {
		return movements;
	}

	public void setMovements(List<Movement> movements) {
		this.movements = movements;
	}
	
	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public List<Contributors> getContributors() {
		return contributors;
	}

	public void setContributors(List<Contributors> contributors) {
		this.contributors = contributors;
	}

	public String getAcno() {
		return acno;
	}

	public void setAcno(String acno) {
		this.acno = acno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	

	public void setMovementCount(int movementCount) {
		this.movementCount = movementCount;
	}

	public int getMovementCount() {
		return movementCount;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	


}
