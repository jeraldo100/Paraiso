package ph.com.paraiso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import ph.com.paraiso.dto.UserDto;
import ph.com.paraiso.model.User;
import ph.com.paraiso.service.UserService;

@Controller
@RequestMapping("/user")
public class UserProfileController {

	@Autowired 
	UserService userSvc;
	
	@GetMapping("/userProfile")
	public String userProfile(HttpServletRequest request, Model model) {
	    Integer user_id = (Integer) request.getSession().getAttribute("user_id");
	    
	    if (user_id == null) {
	        return "redirect:/login";
	    }

	    User user = userSvc.getUserById(user_id);
	    if (user == null) {
	        return "redirect:/login";
	    }

	    
	    model.addAttribute("user", user);

	    return "dashboardUser/userProfile"; 
	}
	
	@GetMapping("/editProfile")
	public String editProfile(HttpServletRequest request, Model model) {
	    Integer user_id = (Integer) request.getSession().getAttribute("user_id");
	    
	    if (user_id == null) {
	        return "redirect:/login"; 
	    }

	    
	    User user = userSvc.getUserById(user_id);
	    if (user == null) {
	        return "redirect:/login"; 
	    }

	    
	    model.addAttribute("user", user);
		return "dashboardUser/userEditProfile";
	}
	
	
	@PostMapping("/updateUser")
	public String updateUser(@ModelAttribute UserDto userDto, HttpServletRequest request) {
	    Integer userId = (Integer) request.getSession().getAttribute("user_id");

	    if (userId == null) {
	        return "redirect:/login"; 
	    }

	    
	    User existingUser = userSvc.getUserById(userId);

	    if (existingUser == null) {
	        return "redirect:/login";
	    }

	    // Update the user's details
	    existingUser.setUsername(userDto.getUsername());
	    existingUser.setFirstName(userDto.getFirstName());
	    existingUser.setLastName(userDto.getLastName());
	    existingUser.setEmail(userDto.getEmail());
	    existingUser.setAddress(userDto.getAddress());
	    existingUser.setPhone(userDto.getPhone());
	    existingUser.setDateOfBirth(userDto.getDateOfBirth());

	    // Encrypt the password
	    BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
	    String encryptedPwd = bcrypt.encode(userDto.getPassword());
	    existingUser.setPassword(encryptedPwd);

	    // Save the updated user
	    userSvc.updateUser(existingUser);

	    return "redirect:/user/userProfile"; // Redirect to the user profile page
	}
	
}
