package ie.cit.assignment1;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.*;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@SpringBootApplication
public class Application {
	
	  public static DriverManagerDataSource getDataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	        dataSource.setUrl("jdbc:mysql://localhost/assignment1");
	        dataSource.setUsername("root");
	        dataSource.setPassword("");
	        return dataSource;
	    }

	 public static void main(String[] args) {
	        SpringApplication.run(Application.class, args);
	    
		String artistFile = args[0];
		String artworkFile = args[1];
		System.out.printf("Processing Artist file %s...\n", artistFile);
		System.out.printf("Processing Artwork file %s...\n", artworkFile);

		try {
			
			RestTemplate template = new RestTemplate();
			String query = "https://api.flickr.com/services/rest/?method=flickr.groups.pools.getPhotos&api_key=372d1b4fe24e5e974ef89ff1d9b002ad&group_id=33133376%40N00&per_page=15&page=1&format=json&nojsoncallback=1&auth_token=72157659930630484-1640caac63063a3b&api_sig=0b192f176fc0b04f893494301ae76539";
			
			String encodedQuery = URLDecoder.decode(query, "UTF-8");
			
			System.out.println(encodedQuery);
			
			Response response = template.getForObject(encodedQuery, Response.class);
			
			System.out.println("Response: " + response.toString());
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {

			Artist artist = new ObjectMapper().readValue(new File(artistFile), Artist.class);
			JdbcArtistRepository artistworksaver = new JdbcArtistRepository(getDataSource()) ;
			artistworksaver.saveOrUpdate(artist);
			
			artistworksaver.addMovement(artist.movements, artist.getId());
			
			Artwork artwork = new ObjectMapper().readValue(new File(artworkFile), Artwork.class);
			JdbcArtworkRepository artworksaver = new JdbcArtworkRepository(getDataSource());
			artworksaver.saveOrUpdate(artwork);
			if (artwork.getMovementCount() !=0)
			{
				artworksaver.addMovement(artwork.movements, artwork.getAcno());
			}
			artworksaver.addArtists(artwork.getContributors(), artwork.getAcno());

			System.out.println("\n---------------------------\nArtist");
			System.out.println(  artist.toString());
			System.out.println("\n---------------------------\nArtwork");
			System.out.println("\n" + artwork.toString());
			System.out.println("\n---------------------------");
			

			
		} catch (JsonParseException e) {
			
			System.out.println("Error parsing the file.");
			
		} catch (JsonMappingException e) {
			
			System.out.println("Error mapping to Java object.");
			
		} catch (IOException e) {
			
			System.out.println("Unknown I/O error.");
		}
		
	}

}

