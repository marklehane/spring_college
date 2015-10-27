package ie.cit.assignment1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Movement {
	
	private int era_id ;
	private String era_name;
	
	public String toString() {
		
		String movementAsString = "Era ID: " + era_id + "Era Name: " + era_name ;
		
		return movementAsString;
		
	}

	public int getEra_id() {
		return era_id;
	}

	public void setEra_id(int era_id) {
		this.era_id = era_id;
	}

	public String getEra_name() {
		return era_name;
	}

	public void setEra_name(String era_name) {
		this.era_name = era_name;
	}


}
