package ph.com.paraiso.controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpServletRequest;
import ph.com.paraiso.service.UserService;
import ph.com.paraiso.session.SessionManager;


@Controller
public class ParaisoPagesController {
	
	@Autowired
	UserService userSvc;
	
    public void setCommonAttributes(HttpServletRequest request, Model model) { 
        String userEmail = SessionManager.getEmailFromSession(request);
        if (userEmail != null) {
            String accountType = userSvc.getAccountTypeByEmail(userEmail);
            String username = userSvc.getUsernameByEmail(userEmail);
            Integer userId = userSvc.getUserIdByEmail(userEmail);
            System.out.println("Email of the user with current session: " + userEmail);
            System.out.println("AccountType of the user with current session: " + accountType);
            System.out.println("username of the user with current session: " + username);
            System.out.println("user id of the user with current session: " + userId);
            model.addAttribute("username", username);
            model.addAttribute("loggedIn", true);
        } else {
            System.out.println("No user associated with the current session.");
            model.addAttribute("loggedIn", false);
        }
    }

	@GetMapping("/home")
	public String homePage(HttpServletRequest request, Model model) {
		setCommonAttributes(request, model);
	    return "home";
	}
	
    @GetMapping("/contact")
    public String contactPage(HttpServletRequest request, Model model) {
        model.addAttribute("pageTitle", "Contact");
        model.addAttribute("pageLink", "/contact");
		setCommonAttributes(request, model);
        return "contact"; 
    }
    
    @GetMapping("/about")
    public String aboutPage(HttpServletRequest request, Model model) {
        model.addAttribute("pageTitle", "About");
        model.addAttribute("pageLink", "/about");
		setCommonAttributes(request, model);
        return "about"; 
    }
    
    @GetMapping("/services")
    public String servicesPage(HttpServletRequest request, Model model) {
        model.addAttribute("pageTitle", "Services");
        model.addAttribute("pageLink", "/services");
		setCommonAttributes(request, model);
        return "services"; 
    }
    
    @GetMapping("/roomdetail")
    public String roomdetailPage(HttpServletRequest request, Model model) {
        model.addAttribute("pageTitle", "Room Detail");
        model.addAttribute("pageLink", "/roomdetail");
		setCommonAttributes(request, model);
        return "roomdetail"; 
    }
    
    @GetMapping("/rooms")
    public String roomsPage(HttpServletRequest request, Model model) {
        model.addAttribute("pageTitle", "Rooms");
        model.addAttribute("pageLink", "/rooms");
		setCommonAttributes(request, model);
        return "rooms"; 
    }
	

}