
package ie.cit.assignment1;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Photos {

    private Integer page;
    private String pages;
    private Integer perpage;
    private String total;
    private List<Photo> photo = new ArrayList<Photo>();

    public Integer getPage() {
    	
        return page;
        
    }

    public void setPage(Integer page) {
    	
        this.page = page;
        
    }

    public String getPages() {
    	
        return pages;
        
    }

    public void setPages(String pages) {
    	
        this.pages = pages;
        
    }

    public Integer getPerpage() {
    	
        return perpage;
        
    }

    public void setPerpage(Integer perpage) {
    	
        this.perpage = perpage;
        
    }

    public String getTotal() {
    	
        return total;
        
    }

    public void setTotal(String total) {
    	
        this.total = total;
        
    }

    public List<Photo> getPhoto() {
    	
        return photo;
        
    }

    public void setPhoto(List<Photo> photo) {
    	
        this.photo = photo;
        
    }

}
