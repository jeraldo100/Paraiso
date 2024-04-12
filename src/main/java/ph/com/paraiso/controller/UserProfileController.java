package ph.com.paraiso.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
	public String editProfile(HttpServletRequest request, Model model) {
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
		return "dashboardUser/userEditProfile";
	}
	
	
	@PostMapping("/updateUser")
	public String updateUser(@ModelAttribute UserDto userDto, HttpServletRequest request) {
	    // Get the user_id from the session
	    Integer userId = (Integer) request.getSession().getAttribute("user_id");

	    if (userId == null) {
	        // Handle case where user_id is not found in session
	        return "redirect:/login"; // Redirect to login page or show an error message
	    }

	    // Use the user_id to fetch the user
	    User existingUser = userSvc.getUserById(userId);

	    if (existingUser == null) {
	        // Handle case where user is not found
	        return "redirect:/login"; // Redirect to login page or show an error message
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
