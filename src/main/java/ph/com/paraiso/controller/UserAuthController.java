package ph.com.paraiso.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	

}
