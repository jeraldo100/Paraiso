package ph.com.paraiso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ph.com.paraiso.service.UserService;

@Controller
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/AdminUsers")
	public String adminUsers(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		return "dashboardAdmin/Users";
	}
	
}
