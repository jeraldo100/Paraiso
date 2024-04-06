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
import ph.com.config.SessionManager;
import ph.com.paraiso.model.User;
import ph.com.paraiso.service.UserService;
import ph.come.paraiso.dto.UserDto;

@Controller
public class UserAuthController {
	
	@Autowired
	UserService userSvc;
	
	@GetMapping("/registration")
	public String getRegistrationPage(){
		return "registration";
	}
	
	@PostMapping("/registration")
	public String saveUser(@ModelAttribute("user") UserDto userDto, Model model) {
		userDto.setAccountType("ADMIN");
		userSvc.save(userDto);
		model.addAttribute("message", "Registered Successfully");
		return "registration";
	}
	
	@GetMapping("/login")
	public String loginsignupPage() {
		return "loginPage";
	}
	
	@PostMapping("/auth")
	public String authenticate(@RequestParam String email, String password, HttpServletRequest request, HttpServletResponse response, Model model) {
		String returnPg = "loginPage";
		
		User user = new User(email, password);
		String result = userSvc.authenticate(user);
		List<User> users = userSvc.getUsers();
		
		model.addAttribute("error", "Invalid Credentials");
		model.addAttribute("users", users);
		if(result.equals("success")) {

	        String sessionId = UUID.randomUUID().toString();
	        SessionManager.createSessionCookie(response, sessionId);
	        String accountType = userSvc.getAccountTypeByEmail(email);
            if (accountType != null) {
                model.addAttribute("accountType", accountType);
                System.out.println("Account Type: " + accountType);
            }
			returnPg = "mainPage";
		}
		return returnPg;
	}
	
	@GetMapping("/")
	public String getUsers(Model model) {
		
		List<User> users = userSvc.getUsers();
		model.addAttribute("users",users);
		
		return "mainPage";
	}

}
