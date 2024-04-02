package ph.com.paraiso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ParaisoPagesController {
	@GetMapping("/home")
	public String homePage() {
		return "home";
	}
	
	@GetMapping("/about")
	public String aboutPage() {
		return "about";
	}
	
	@GetMapping("/contact")
	public String contactPage() {
		return "contact";
	}
	
	@GetMapping("/services")
	public String servicesPage() {
		return "services";
	}
	
	@GetMapping("/roomdetail")
	public String roomdetailPage() {
		return "roomdetail";
	}

}
