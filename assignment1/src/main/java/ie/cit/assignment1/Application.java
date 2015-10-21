package ie.cit.assignment1;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Application {

	public static void main(String[] args) {
		
		String artistFile = args[0];
		String artworkFile = args[0];
		System.out.printf("Processing Artist file %s...\n", artistFile);
		System.out.printf("Processing Artwork file %s...\n", artworkFile);

		try {
			Artist artist = new ObjectMapper().readValue(new File(artistFile), Artist.class);
			Artwork artwork = new ObjectMapper().readValue(new File(artistFile), Artwork.class);
			
			System.out.println("\n" + artist.toString());
			System.out.println("\n" + artwork.toString());
			
		} catch (JsonParseException e) {
			
			System.out.println("Error parsing the file.");
			
		} catch (JsonMappingException e) {
			
			System.out.println("Error mapping to Java object.");
			
		} catch (IOException e) {
			
			System.out.println("Unknown I/O error.");
		}
		
	}

}
