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


	@GetMapping("/login")
	public String loginPage() {
		return "loginPage";
	}
	
	
	@GetMapping("/registration")
	public String getRegistrationPage(){
		return "registration";
	}
	
	@PostMapping("/registration")
	public String saveUser(@ModelAttribute("user") UserDto userDto, Model model) {
		userSvc.save(userDto);
		model.addAttribute("message", "Registered Successfully");
		return "registration";
	}
	
	
	@PostMapping("/auth")
	public String authenticate(@RequestParam String username, String password, Model model) {
		String returnPg = "loginPage";
		
		User user = new User(username, password);
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
	
	@GetMapping("/adduser")
	public String addUser(Model model) {
		
		//dispatch
		User user = new User();
		model.addAttribute("user",user);
		
		return "addUser";
	}

	
	@PostMapping("/adduser/save")
	public String saveNewUser(
	    @RequestParam("username") String username,
	    @RequestParam("password") String password,
	    @RequestParam("account_type") String accountType,
	    @RequestParam("first_name") String firstName,
	    @RequestParam("last_name") String lastName,
	    @RequestParam("date_of_birth") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateOfBirth,
	    @RequestParam("address") String address,
	    @RequestParam("phone") BigInteger phone,
	    @RequestParam("email") String email,
	    Model model) {

	    User user = new User();
	   
	    user.setUsername(username);
	    user.setPassword(password);
	    user.setAccountType(accountType);
	    user.setFirstName(firstName);
	    user.setLastName(lastName);
	    user.setDateOfBirth(java.sql.Date.valueOf(dateOfBirth));
	    user.setAddress(address);
	    user.setPhone(phone);
	    user.setEmail(email);

	    userSvc.addUser(user);

	    return "/user/mainPage";
	}
	
//	@PostMapping("/adduser/save")
//	public String saveNewUser(
//	    @RequestParam("userid") Long userid,
//	    @RequestParam("username") String username,
//	    @RequestParam("password") String password,
//	    @RequestParam("account_type") String accountType,
//	    @RequestParam("first_name") String firstName,
//	    @RequestParam("last_name") String lastName,
//	    @RequestParam("date_of_birth") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateOfBirth,
//	    @RequestParam("address") String address,
//	    @RequestParam("phone") BigInteger phone,
//	    @RequestParam("email") String email,
//	    Model model) {
//
//	    User user = new User();
//	    user.setUserid(userid);
//	    user.setUsername(username);
//	    user.setPassword(password);
//	    user.setAccountType(accountType);
//	    user.setFirstName(firstName);
//	    user.setLastName(lastName);
//	    user.setDateOfBirth(java.sql.Date.valueOf(dateOfBirth)); 
//	    user.setAddress(address);
//	    user.setPhone(phone);
//	   	user.setEmail(email);
//
//	    userSvc.addUser(user);
//
//	    return "/user/mainPage";
//	}
//	
//	@PostMapping("/adduser/save")
//	public String saveNewUser(@RequestParam String username, String password, Model model) {
//		User user = new User();
//		user.setUsername(username);
//		user.setPassword(password);
//		
//		userSvc.addUser(user);
//		
//		return "/user/mainPage";
//	}
//	
	


	
	
	@GetMapping("/edit/{userid}")
	public String editUser(@PathVariable Long userid, Model model) {
		
		model.addAttribute("user",userSvc.getUserById(userid));
		return "updateForm";
	}
	
	@PostMapping("/edit/update/{userid}")
	public String updateUser(@PathVariable Long userid, @RequestParam String username, String password, Model model) {
		model.addAttribute("user",userSvc.getUserById(userid));
		
		User getUser  = userSvc.getUserById(userid);
		getUser.setUsername(username);
		getUser.setPassword(password);
		
		userSvc.updateUser(getUser);
		return "/user/mainPage";
		
	}
	
	@GetMapping("delete/{userid}")
	public String deleteUser(@PathVariable Long userid) {
		
		userSvc.deleteById(userid);
		return "/user/mainPage";
	}

}
