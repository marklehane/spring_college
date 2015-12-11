package ie.cit.assignment1;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.web.client.RestTemplate;

public class GetResponse {

	public Response get() throws UnsupportedEncodingException{

			RestTemplate template = new RestTemplate();
			String query = "https://api.flickr.com/services/rest/?method=flickr.groups.pools.getPhotos&api_key=372d1b4fe24e5e974ef89ff1d9b002ad&group_id=33133376%40N00&per_page=15&page=1&format=json&nojsoncallback=1&auth_token=72157659930630484-1640caac63063a3b&api_sig=0b192f176fc0b04f893494301ae76539";
			
			String encodedQuery = URLDecoder.decode(query, "UTF-8");
			
			System.out.println(encodedQuery);
			
			Response response = template.getForObject(encodedQuery, Response.class);
			
			return response;
		
	}
	
}
