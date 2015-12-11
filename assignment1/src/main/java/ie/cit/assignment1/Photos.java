package ie.cit.assignment1;

import java.util.ArrayList;
import java.util.List;


public class Photos {

    public List<Photo> photo = new ArrayList<Photo>();

    public void setPhoto(List<Photo> photo) {
    	
        this.photo = photo;
        
    }
    
    public String toString(){
    	
    	return ""+photo;
    	
    }

}
