package ph.com.paraiso.controller;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import jakarta.servlet.http.HttpServletRequest;
import ph.com.paraiso.config.SessionManager;
import ph.com.paraiso.service.UserService;


@Controller
public class ParaisoPagesController {
	
	@Autowired
	UserService userSvc;

	@GetMapping("/home")
	public String homePage(HttpServletRequest request, Model model) {
	    String userEmail = SessionManager.getEmailFromSession(request);
	    if (userEmail != null) {
	    	String accountType = userSvc.getAccountTypeByEmail(userEmail);
	    	String username = userSvc.getUsernameByEmail(userEmail);
	    	 System.out.println("Email of the user with current session: " + userEmail);
	    	 System.out.println("AccountType of the user with current session: " + accountType);
	    	 System.out.println("username of the user with current session: " + username);
	    	 model.addAttribute("username", username);
	        model.addAttribute("loggedIn", true);
	    } else {
	    	System.out.println("No user associated with the current session.");
	        model.addAttribute("loggedIn", false);
	    }
 
	    return "home";
	}
	
    @GetMapping("/contact")
    public String contactPage(HttpServletRequest request, Model model) {
        model.addAttribute("pageTitle", "Contact");
        model.addAttribute("pageLink", "/contact");
        
        String userEmail = SessionManager.getEmailFromSession(request);
	    if (userEmail != null) {
	    	String accountType = userSvc.getAccountTypeByEmail(userEmail);
	    	String username = userSvc.getUsernameByEmail(userEmail);
	    	 model.addAttribute("username", username);
	        model.addAttribute("loggedIn", true);
	    } else {
	        model.addAttribute("loggedIn", false);
	    }
        return "contact"; 
    }
    
    @GetMapping("/about")
    public String aboutPage(HttpServletRequest request, Model model) {
        model.addAttribute("pageTitle", "About");
        model.addAttribute("pageLink", "/about");
        
        String userEmail = SessionManager.getEmailFromSession(request);
   	    if (userEmail != null) {
   	    	String accountType = userSvc.getAccountTypeByEmail(userEmail);
   	    	String username = userSvc.getUsernameByEmail(userEmail);
   	    	 model.addAttribute("username", username);
   	        model.addAttribute("loggedIn", true);
   	    } else {
   	        model.addAttribute("loggedIn", false);
   	    }
   	    
        return "about"; 
    }
    
    @GetMapping("/services")
    public String servicesPage(HttpServletRequest request, Model model) {
        model.addAttribute("pageTitle", "Services");
        model.addAttribute("pageLink", "/services");
        String userEmail = SessionManager.getEmailFromSession(request);
   	    if (userEmail != null) {
   	    	String accountType = userSvc.getAccountTypeByEmail(userEmail);
   	    	String username = userSvc.getUsernameByEmail(userEmail);
   	    	 model.addAttribute("username", username);
   	        model.addAttribute("loggedIn", true);
   	    } else {
   	        model.addAttribute("loggedIn", false);
   	    }
        return "services"; 
    }
    
    @GetMapping("/roomdetail")
    public String roomdetailPage(HttpServletRequest request, Model model) {
        model.addAttribute("pageTitle", "Room Detail");
        model.addAttribute("pageLink", "/roomdetail");
        String userEmail = SessionManager.getEmailFromSession(request);
   	    if (userEmail != null) {
   	    	String accountType = userSvc.getAccountTypeByEmail(userEmail);
   	    	String username = userSvc.getUsernameByEmail(userEmail);
   	    	 model.addAttribute("username", username);
   	        model.addAttribute("loggedIn", true);
   	    } else {
   	        model.addAttribute("loggedIn", false);
   	    }
        return "roomdetail"; 
    }
    
    @GetMapping("/rooms")
    public String roomsPage(HttpServletRequest request, Model model) {
        model.addAttribute("pageTitle", "Rooms");
        model.addAttribute("pageLink", "/rooms");
        String userEmail = SessionManager.getEmailFromSession(request);
   	    if (userEmail != null) {
   	    	String accountType = userSvc.getAccountTypeByEmail(userEmail);
   	    	String username = userSvc.getUsernameByEmail(userEmail);
   	    	 model.addAttribute("username", username);
   	        model.addAttribute("loggedIn", true);
   	    } else {
   	        model.addAttribute("loggedIn", false);
   	    }
        return "rooms"; 
    }
	

}