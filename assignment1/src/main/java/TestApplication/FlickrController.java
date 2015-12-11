package TestApplication;

import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ie.cit.assignment1.GetResponse;
import ie.cit.assignment1.Response;

@Controller
public class FlickrController {

	@RequestMapping("/flickr")
	public String main(Model model) throws UnsupportedEncodingException{
		
		GetResponse test = new GetResponse();
		Response response = test.get();
		model.addAttribute("response", response);
		
		return "flickr";

	}

}
