package ph.com.paraiso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import ph.com.paraiso.model.User;
import ph.com.paraiso.service.UserService;

@Controller
@RequestMapping("/user")
public class UserProfileController {

	@Autowired 
	UserService userSvc;
	
	@GetMapping("/userProfile")
	public String userProfile(HttpServletRequest request, Model model) {
	    // Get the user_id from the session
	    Integer user_id = (Integer) request.getSession().getAttribute("user_id");
	    
	    if (user_id == null) {
	        // Handle case where user_id is not found in session
	        return "redirect:/login"; // Redirect to login page or show an error message
	    }

	    // Use the user_id to fetch user-specific data
	    User user = userSvc.getUserById(user_id);
	    if (user == null) {
	        // Handle case where user is not found
	        return "redirect:/login"; // Redirect to login page or show an error message
	    }

	    // Add the user data to the model
	    model.addAttribute("user", user);

	    return "dashboardUser/userProfile"; // Return the view for the user profile page
	}
	
	@GetMapping("/editProfile")
	public String editProfile() {
		return "dashboardUser/userEditProfile";
	}
	
	@GetMapping("/userDashboard")
	public String dashboardUser() {
		return "dashboardUser/userDashboard";
	}
	
}
