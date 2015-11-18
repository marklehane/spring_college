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
import org.springframework.web.bind.annotation.RequestMethod;

import ie.cit.assignment1.Artist;
import ie.cit.assignment1.Artwork;
import ie.cit.assignment1.Comment;
import ie.cit.assignment1.JdbcArtistRepository;
import ie.cit.assignment1.JdbcArtworkRepository;
@Controller
public class indexController {
	





@RequestMapping("/")
String main(){

	return "index";
}

@RequestMapping("/login")
String login(){

	return "login";
}




}
