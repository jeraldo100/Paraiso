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
import ph.com.paraiso.service.AdminUserService;
import ph.com.paraiso.service.UserService;

@Controller
public class AdminUserController {

	private AdminUserService adminUserService;

	public AdminUserController(AdminUserService adminUserService) {
		super();
		this.adminUserService = adminUserService;
	}
	
	@GetMapping("/AdminUsers")
	public String adminUsers(Model model) {
		model.addAttribute("users", adminUserService.getAllUsers());
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
		user.setAccountType(account_type);
		user.setFirstName(first_name);
		user.setLastName(last_name);
		user.setDateOfBirth(date_of_birth);
		user.setAddress(address);
		user.setPhone(phone);
		user.setEmail(email);
		
		adminUserService.addUser(user);
		
		return "redirect:/AdminUsers";
		
	}
	
	@GetMapping("/editUser/{user_id}")
	public String editUser(@PathVariable("user_id") Integer user_id, Model model) {
		
		model.addAttribute("user", adminUserService.getUserById(user_id));
		
		return "dashboardAdmin/UsersCRUD/EditUsers";
	}
	
	@PostMapping("/updateUser/{user_id}")
	public String updateUser(@PathVariable("user_id") Integer user_id,
			@ModelAttribute("user_id") User user,
			Model model) {
		
		User existingUser = adminUserService.getUserById(user_id);
		existingUser.setUsername(user.getUsername());
		existingUser.setPassword(user.getPassword());
		existingUser.setAccountType(user.getAccountType());
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setDateOfBirth(user.getDateOfBirth());
		existingUser.setAddress(user.getAddress());
		existingUser.setPhone(user.getPhone());
		existingUser.setEmail(user.getEmail());
		
		adminUserService.updateUser(existingUser);
		
		return "redirect:/AdminUsers";

	}
	
	@GetMapping("/deleteUser/{user_id}")
	public String deleteUser(@PathVariable("user_id") Integer user_id) {
		adminUserService.deleteUserById(user_id);
		return "redirect:/AdminUsers";
	}
	
}
