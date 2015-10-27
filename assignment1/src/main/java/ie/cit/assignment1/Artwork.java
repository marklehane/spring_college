package ie.cit.assignment1;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Artwork {

	private String classification;
	List<Movement> movements ;
	@Override
	public String toString() {
			
		String artworkAsString = "Classification: " + classification +"\nMovements:"+ movements;
		
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

}
