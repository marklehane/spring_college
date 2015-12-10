package ie.cit.assignment1;
import org.springframework.web.client.RestTemplate;

public class GetResponse {

	public Response get(){
		
		RestTemplate template = new RestTemplate();
		String query = "https://api.flickr.com/services/rest/?method=flickr.groups.pools.getPhotos&api_key=947aafd66ee678cea429a52fe4f874a8&group_id=33133376%40N00&per_page=15&page=1&format=json&nojsoncallback=1";
		
		Response response = template.getForObject(query, Response.class);
		
		return response;

	}
	
}
