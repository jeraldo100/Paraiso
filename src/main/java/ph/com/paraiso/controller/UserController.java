package ph.com.paraiso.controller;

import java.sql.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ph.com.paraiso.model.User;
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
	
	@GetMapping("/addUser")
	public String addUser(Model model) {
		
		return "dashboardAdmin/UsersCRUD/AddUsers";
	}
	
	@PostMapping("/addUser/save")
	public String saveUser(
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("account_type") String account_type,
			@RequestParam("first_name") String first_name,
			@RequestParam("last_name") String last_name,
			@RequestParam("date_of_birth") Date date_of_birth,
			@RequestParam("address") String address,
			@RequestParam("phone") Long phone,
			@RequestParam("email") String email,
			Model model) {
		
		User user = new User();
		
		user.setUsername(username);
		user.setPassword(password);
		user.setAccount_type(account_type);
		user.setFirst_name(first_name);
		user.setLast_name(last_name);
		user.setDate_of_birth(date_of_birth);
		user.setAddress(address);
		user.setPhone(phone);
		user.setEmail(email);
		
		userService.addUser(user);
		
		return "redirect:/AdminUsers";
		
	}
	
	@GetMapping("/editUser/{user_id}")
	public String editUser(@PathVariable("user_id") Integer user_id, Model model) {
		
		model.addAttribute("user", userService.getUserById(user_id));
		
		return "dashboardAdmin/UsersCRUD/EditUsers";
	}
	
	@PostMapping("/updateUser/{user_id}")
	public String updateUser(@PathVariable("user_id") Integer user_id,
			@ModelAttribute("user_id") User user,
			Model model) {
		
		User existingUser = userService.getUserById(user_id);
		existingUser.setUsername(user.getUsername());
		existingUser.setPassword(user.getPassword());
		existingUser.setAccount_type(user.getAccount_type());
		existingUser.setFirst_name(user.getFirst_name());
		existingUser.setLast_name(user.getLast_name());
		existingUser.setDate_of_birth(user.getDate_of_birth());
		existingUser.setAddress(user.getAddress());
		existingUser.setPhone(user.getPhone());
		existingUser.setEmail(user.getEmail());
		
		userService.updateUser(existingUser);
		
		return "redirect:/AdminUsers";

	}
	
	@GetMapping("/deleteUser/{user_id}")
	public String deleteUser(@PathVariable("user_id") Integer user_id) {
		userService.deleteUserById(user_id);
		return "redirect:/AdminUsers";
	}
	
}
