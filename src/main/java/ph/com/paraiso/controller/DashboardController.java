package ph.com.paraiso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ph.com.paraiso.model.Booking;
import ph.com.paraiso.model.Room;
import ph.com.paraiso.model.User;
import ph.com.paraiso.repository.BookingRepository;
import ph.com.paraiso.repository.RoomRepository;
import ph.com.paraiso.repository.UserRepository;

@Controller
public class DashboardController {

	@Autowired
	BookingRepository bookingRepository;
	
	@GetMapping("/AdminDashboard")
	public String adminDashboardPage(Model model) {
		
		Double totalPrice = bookingRepository.totalPrice();
		model.addAttribute("totalPrice",totalPrice);
		
		Integer totalBooking = bookingRepository.totalBooking();
		model.addAttribute("totalBooking", totalBooking);
		
		Iterable<Booking> bookings = bookingRepository.findAll();
		model.addAttribute("bookings", bookings);
		
		
		return "dashboardAdmin/Dashboard";
	}
	
	
}
