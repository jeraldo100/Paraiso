package ph.com.paraiso.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import ph.com.paraiso.config.SessionManager;


@Controller
public class ParaisoPagesController {

	@GetMapping("/home")
	public String homePage(HttpServletRequest request, Model model) {
	    String userEmail = SessionManager.getEmailFromSession(request);
	    if (userEmail != null) {
	    	 System.out.println("Email of the user with current session: " + userEmail);
	        model.addAttribute("loggedIn", true);
	    } else {
	    	System.out.println("No user associated with the current session.");
	        model.addAttribute("loggedIn", false);
	    }
 
	    return "home";
	}
	
    @GetMapping("/contact")
    public String contactPage(Model model) {
        model.addAttribute("pageTitle", "Contact");
        model.addAttribute("pageLink", "/contact");
        return "contact"; 
    }
    
    @GetMapping("/about")
    public String aboutPage(Model model) {
        model.addAttribute("pageTitle", "About");
        model.addAttribute("pageLink", "/about");
        return "about"; 
    }
    
    @GetMapping("/services")
    public String servicesPage(Model model) {
        model.addAttribute("pageTitle", "Services");
        model.addAttribute("pageLink", "/services");
        return "services"; 
    }
    
    @GetMapping("/roomdetail")
    public String roomdetailPage(Model model) {
        model.addAttribute("pageTitle", "Room Detail");
        model.addAttribute("pageLink", "/roomdetail");
        return "roomdetail"; 
    }
    
    @GetMapping("/rooms")
    public String roomsPage(Model model) {
        model.addAttribute("pageTitle", "Rooms");
        model.addAttribute("pageLink", "/rooms");
        return "rooms"; 
    }
	

}