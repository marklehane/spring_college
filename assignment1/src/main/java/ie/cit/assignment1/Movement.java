package ie.cit.assignment1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Movement {
	private String name ;

	
	 @Override
	    public String toString() {
	        return  name ;
	    }


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}




	


}
