package ph.com.paraiso.controller;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ph.com.paraiso.dto.UserDto;
import ph.com.paraiso.model.User;
import ph.com.paraiso.service.UserService;
import ph.com.paraiso.session.SessionManager;

@Controller
public class UserAuthController {
	
	@Autowired
	UserService userSvc;	

	
    @PostMapping("/registration")
    public ResponseEntity<String> saveUser(@ModelAttribute("user") UserDto userDto, Model model) {
        userDto.setAccountType("USER");
        userSvc.save(userDto);
        
        return ResponseEntity.status(HttpStatus.OK).body("Registered Successfully");
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
            if (accountType != null) {
                model.addAttribute("accountType", accountType);
                if (accountType.equals("ADMIN")) {
                    return "redirect:/AdminDashboard";
                }
                if (accountType.equals("USER")) {
                	return "redirect:/home";
                }
            }
        }
        
        return returnPg;
    }
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
	    String sessionId = SessionManager.getSessionId(request);
	    if (sessionId != null) {
	
	        SessionManager.deleteSessionCookie(response);
	        SessionManager.invalidateSession(sessionId); 
	    }
	    return "redirect:/home"; 
	}

}
