package TestApplication;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ie.cit.assignment1.Artist;
import ie.cit.assignment1.Artwork;
import ie.cit.assignment1.JdbcArtistRepository;
import ie.cit.assignment1.JdbcArtworkRepository;
@Controller
public class indexController {
	
@RequestMapping("/artist")
String index(){

	return "art";
}




@RequestMapping("/")
String main(){

	return "index";
}


@RequestMapping("/artist/{id}")
String artist(Locale locale, Model model, @PathVariable("id") int id){
	 
//JdbcArtistRepository test = new JdbcArtistRepository(getDataSource()) ;
//List<Artist> artist = test.list();
	JdbcArtistRepository test = new JdbcArtistRepository(getDataSource());
	Artist artist = test.get(id);
	model.addAttribute("singleArtist", artist);
	
	return "artist";
}


@RequestMapping("/artwork/{id}")
String singleArtwork(Locale locale, Model model, @PathVariable("id") String id){
	 
//JdbcArtistRepository test = new JdbcArtistRepository(getDataSource()) ;
//List<Artist> artist = test.list();
	JdbcArtworkRepository test = new JdbcArtworkRepository(getDataSource());
	Artwork artwork = test.get(id);
	model.addAttribute("singleArtwork", artwork);
	
	return "singleArtwork";
}

@RequestMapping("/artwork")
String artwork(){

	return "artwork";
}

@ModelAttribute("artwork")
public String artworks(Locale locale, Model model){
	JdbcArtworkRepository test = new JdbcArtworkRepository(getDataSource()) ;
	List<Artwork> artwork = test.list();
	 model.addAttribute("artwork", artwork);
return "artwork";
	
}


@ModelAttribute("artist")
public String artists(Locale locale, Model model){
	JdbcArtistRepository test = new JdbcArtistRepository(getDataSource()) ;
	List<Artist> artist = test.list();
	 model.addAttribute("artist", artist);
return "artist";
	
}

public static DriverManagerDataSource getDataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost/assignment1");
    dataSource.setUsername("root");
    dataSource.setPassword("");
    return dataSource;
}

}
