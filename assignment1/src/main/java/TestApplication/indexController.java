package TestApplication;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ie.cit.assignment1.Artist;
import ie.cit.assignment1.JdbcArtistRepository;
@Controller
public class indexController {
	
@RequestMapping("/")
String index(){
	//JdbcArtistRepository test = new JdbcArtistRepository(getDataSource()) ;
//List<Artist> artist = test.list();
	return "index";
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
