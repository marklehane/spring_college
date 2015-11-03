package ie.cit.assignment1;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@SpringBootApplication
public class Birth {
	
	private Place place;

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}
	@Override
    public String toString() {
		
        return  place.toString() ;
		
    }

	 

}
