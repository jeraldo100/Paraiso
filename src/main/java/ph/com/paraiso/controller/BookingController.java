package ph.com.paraiso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookingController {
	@GetMapping("/login")
	public String loginPage() {
		
		return "loginPage";
	}
	@GetMapping("/home")
	public String home() {
		
		return "home";
	}
}
