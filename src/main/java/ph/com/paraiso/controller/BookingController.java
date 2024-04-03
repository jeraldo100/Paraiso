package ph.com.paraiso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ph.com.paraiso.service.BookingService;
import ph.com.paraiso.service.RoomService;
import ph.com.paraiso.service.UserService;

@Controller
public class BookingController {
	
	private BookingService bookingService;
	
	public BookingController(BookingService bookingService) {
		super();
		this.bookingService = bookingService;
	}

	
	@GetMapping("/AdminBooking")
	public String adminBooking(Model model) {
		model.addAttribute("bookings", bookingService.getAllBookings());
		return "dashboardAdmin/Booking";
	}
	
	@GetMapping("/booking")
	public String bookingPage() {
		
		return "booking/Booking";
	}
	
	@GetMapping("/AdminDashboard")
	public String adminDashboardPage() {
		return "dashboardAdmin/Dashboard";
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
