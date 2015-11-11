package ie.cit.assignment1;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	  
	// Login
		  @RequestMapping("/login")
		  public String login() {
		    return "login.html";
		  }
		 
		  // error
		  @RequestMapping("/error")
		  public String error(HttpServletRequest request, Model model) {
			    model.addAttribute("errorCode", request.getAttribute("javax.servlet.error.status_code"));
			    Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
			    String errorMessage = null;
			    if (throwable != null) {
			      errorMessage = throwable.getMessage();
			    }
			    model.addAttribute("errorMessage", errorMessage);
			    return "error.html";
			  }
		  

	 public static void main(String[] args) {
	        SpringApplication.run(Application.class, args);
	    
		
		String artistFile = args[0];
		String artworkFile = args[1];
		System.out.printf("Processing Artist file %s...\n", artistFile);
		System.out.printf("Processing Artwork file %s...\n", artworkFile);

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

