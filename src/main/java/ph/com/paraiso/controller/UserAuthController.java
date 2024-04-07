package ph.com.paraiso.controller;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ph.com.paraiso.config.SessionManager;
import ph.com.paraiso.model.User;
import ph.com.paraiso.service.UserService;
import ph.come.paraiso.dto.UserDto;

@Controller
public class UserAuthController {
	
	@Autowired
	UserService userSvc;
	
	
	@PostMapping("/registration")
	public String saveUser(@ModelAttribute("user") UserDto userDto, Model model) {
		userDto.setAccountType("USER");
		userSvc.save(userDto);
		model.addAttribute("message", "Registered Successfully");
		return "registration";
	}
	
	@PostMapping("/auth")
    public String authenticate(@RequestParam String email, String password, HttpServletRequest request, HttpServletResponse response, Model model) {
        String returnPg = "loginPage";

        User user = new User(email, password);
        String result = userSvc.authenticate(user);
        List<User> users = userSvc.getUsers();

        model.addAttribute("error", "Invalid Credentials");
        model.addAttribute("users", users);
        if (result.equals("success")) {

            String sessionId = UUID.randomUUID().toString();
            SessionManager.createSessionCookie(response, sessionId, email);
            String accountType = userSvc.getAccountTypeByEmail(email);
            model.addAttribute("loggedIn", true);
            if (accountType != null) {
                model.addAttribute("accountType", accountType);
                if (accountType.equals("ADMIN")) {
                    return "dashboardAdmin/Dashboard";
                }
                if (accountType.equals("USER")) {
                    return "mainPage";
                }
            }
            model.addAttribute("loggedIn", false);
            returnPg = "mainPage";
        }
        return returnPg;
    }

	@GetMapping("/UserDashboards")
	public String userDashboard(HttpServletRequest request) {
        String userEmail = SessionManager.getEmailFromSession(request);
        if (userEmail != null) {
            System.out.println("Email of the user with current session: " + userEmail);
        } else {
            System.out.println("No user associated with the current session.");
        }

		return "dashboardUser/userDashboard";
	}
	
	 @GetMapping("/")
	    public String getUsers(HttpServletRequest request, Model model) {
	        String userEmail = SessionManager.getEmailFromSession(request);
	        if (userEmail != null) {
	            System.out.println("Email of the user with current session: " + userEmail);
	        } else {
	            System.out.println("No user associated with the current session.");
	        }

	        List<User> users = userSvc.getUsers();
	        model.addAttribute("users", users);

	        return "mainPage";
	    }
}
