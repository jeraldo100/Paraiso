package ph.com.paraiso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ph.com.paraiso.service.RoomService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/UserDashboard")
	public String userDashboard() {
		return "dashboardUser/userDashboard";
	}
	
	private RoomService roomService;
	@GetMapping("/AdminRooms")
	public String adminRooms(Model model) {
		model.addAttribute("rooms",roomService.getAllRooms());
		return "dashboardAdmin/Rooms";
	}
	
	@GetMapping("/UserEditProfile")
	public String userEditProfile() {
		return "dashboardUser/userEditProfile";
	}
	
	@GetMapping("/UserProfile")
	public String userProfile() {
		return "dashboardUser/userProfile";
	}
}
