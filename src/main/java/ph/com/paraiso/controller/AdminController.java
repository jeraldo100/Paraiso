package ph.com.paraiso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
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
	
}
