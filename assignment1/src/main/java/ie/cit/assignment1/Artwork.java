package ie.cit.assignment1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Artwork {

	private String classification;
	
	public String toString() {
			
		String artworkAsString = "Classification: " + classification ;
		
		return artworkAsString;
		
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

}
