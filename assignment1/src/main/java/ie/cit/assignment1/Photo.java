package ie.cit.assignment1;

public class Photo {

	private String id;
    private String owner;
    private String secret;
    private String server;
    private Integer farm;
    private String title;

    public String getId() {
    	
        return id;
        
    }

    public void setId(String id) {
    	
        this.id = id;
        
    }

    public String getOwner() {
    	
        return owner;
        
    }

    public void setOwner(String owner) {
    	
        this.owner = owner;
        
    }

    public String getSecret() {
    	
        return secret;
        
    }
    
    public void setSecret(String secret) {
    	
        this.secret = secret;
        
    }

    public String getServer() {
    	
        return server;
        
    }

    public void setServer(String server) {
    	
        this.server = server;
        
    }

    public Integer getFarm() {
    	
        return farm;
        
    }

    public void setFarm(Integer farm) {
    	
        this.farm = farm;
        
    }

    public String getTitle() {
    	
        return title;
        
    }

    public void setTitle(String title) {
    	
        this.title = title;
        
    }

    
    @Override
    public String toString(){
    	
		return "" + id + secret + server + farm;
    	
    }
    
}
