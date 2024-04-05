package ph.com.paraiso.controller;
import java.time.LocalDate;
import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ph.com.paraiso.model.User;
import ph.com.paraiso.service.UserService;
import ph.come.paraiso.dto.UserDto;

@Controller
@RequestMapping("/user")
public class UserAuthController {
	
	@Autowired
	UserService userSvc;

	
	@GetMapping("/registration")
	public String getRegistrationPage(){
		return "registration";
	}
	
	@PostMapping("/registration")
	public String saveUser(@ModelAttribute("user") UserDto userDto, Model model) {
		userSvc.save(userDto);
		model.addAttribute("message", "Registered Successfully");
		return "home";
	}
	
	@GetMapping("/login")
	public String loginsignupPage() {
		return "loginPage";
	}
	
	
	@PostMapping("/auth")
	public String authenticate(@RequestParam String email, String password, Model model) {
		String returnPg = "loginPage";
		
		User user = new User(email, password);
		String result = userSvc.authenticate(user);
		List<User> users = userSvc.getUsers();
		
		model.addAttribute("error", "Invalid Credentials");
		model.addAttribute("users", users);
		if(result.equals("success")) {
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
