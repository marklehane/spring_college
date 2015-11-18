package TestApplication;

import java.util.List;
import java.util.Locale;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ie.cit.assignment1.Artwork;
import ie.cit.assignment1.Comment;
import ie.cit.assignment1.JdbcArtworkRepository;

@Controller
public class artworkController {

@RequestMapping(value="/artwork/{id}", method=RequestMethod.GET)
String singleArtwork(Locale locale, Model model, @PathVariable("id") String id){
	 
//JdbcArtistRepository test = new JdbcArtistRepository(getDataSource()) ;
//List<Artist> artist = test.list();
	JdbcArtworkRepository test = new JdbcArtworkRepository(getDataSource());
	Artwork artwork = test.get(id);
	Comment comment = new Comment();
	
	model.addAttribute("singleArtwork", artwork);
	model.addAttribute("comment", comment);
	
	return "singleArtwork";
}

@RequestMapping(value="/artwork/{id}", method=RequestMethod.POST)
public String commentSubmit(@ModelAttribute Comment comment, Model model, @PathVariable("id") String id) {
	JdbcArtworkRepository test = new JdbcArtworkRepository(getDataSource());
	test.addComment(id, comment.getComment());
	
	Artwork artwork = test.get(id);
	model.addAttribute("singleArtwork", artwork);
	model.addAttribute("comment", comment);
	
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

public static DriverManagerDataSource getDataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost/assignment1");
    dataSource.setUsername("root");
    dataSource.setPassword("");
    return dataSource;
}
}
