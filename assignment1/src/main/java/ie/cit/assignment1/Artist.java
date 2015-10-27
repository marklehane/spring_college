package ie.cit.assignment1;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Artist {
	List<Movement> movements ;

	private int birthYear;
	private int totalWorks;
	
	@JsonProperty("fc")
	private String fullName;

	private String gender;
	
	
	@Override
	public String toString() {
		
		return  "Name: " + fullName + "\nBorn: " + birthYear + "\nGender: " + gender + "\nTotal Works: " + totalWorks +"\nMovements:"+ movements ;
		
		
		
	}





	public List<Movement> getMovements() {
		return movements;
	}





	public void setMovements(List<Movement> movements) {
		this.movements = movements;
	}





	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getTotalWorks() {
		return totalWorks;
	}

	public void setTotalWorks(int totalWorks) {
		this.totalWorks = totalWorks;
	}
	
	
	
}
