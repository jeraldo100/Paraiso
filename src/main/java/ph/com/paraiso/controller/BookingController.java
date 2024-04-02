package ph.com.paraiso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ph.com.paraiso.service.RoomService;

@Controller
public class BookingController {
	@GetMapping("/booking")
	public String bookingPage() {
		
		return "booking/Booking";
	}
	
	@GetMapping("/AdminDashboard")
	public String adminDashboardPage() {
		return "dashboardAdmin/Dashboard";
	}
	
	@GetMapping("/AdminBooking")
	public String adminBooking() {
		return "dashboardAdmin/Booking";
	}
	
	@GetMapping("/AdminDiscount")
	public String adminDiscount() {
		return "dashboardAdmin/Discount";
	}
	
	
	
	@GetMapping("/AdminUsers")
	public String adminUsers() {
		return "dashboardAdmin/Users";
	}
	
	@GetMapping("/UserDashboard")
	public String userDashboard() {
		return "dashboardUser/userDashboard";
	}
	
	@GetMapping("/UserEditProfile")
	public String userEditProfile() {
		return "dashboardUser/userEditProfile";
	}
	
	@GetMapping("/UserProfile")
	public String userProfile() {
		return "dashboardUser/userProfile";
	}
	
	private RoomService roomService;

	public BookingController(RoomService roomService) {
		super();
		this.roomService = roomService;
	}
	
	@GetMapping("/AdminRooms")
	public String adminRooms(Model model) {
		model.addAttribute("rooms",roomService.getAllRooms());
		return "dashboardAdmin/Rooms";
	}
	
}
