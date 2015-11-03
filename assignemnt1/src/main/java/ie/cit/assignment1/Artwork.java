package ie.cit.assignment1;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@SpringBootApplication
public class Artwork {
	
	
	private String classification;
	List<Contributors> contributors ;
	List<Movement> movements ;
	@Override
	public String toString() {
			
		String artworkAsString = "Classification: " + classification +"\nMovements:"+ movements +"\n Contributors:"+ contributors;
		
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
	
	

}
