package ph.com.paraiso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ph.com.paraiso.repository.BookingRepository;

@Controller
public class DashboardController {

	@Autowired
	BookingRepository bookingRepository;
	
	@GetMapping("/AdminDashboard")
	public String adminDashboardPage(Model model) {
		
		Double totalPrice = bookingRepository.totalPrice();
		model.addAttribute("totalPrice",totalPrice);
		
		Integer checkInTotal = bookingRepository.checkInTotal();
		model.addAttribute("checkInTotal", checkInTotal);
		
		Integer checkOutTotal = bookingRepository.checkOutTotal();
		model.addAttribute("checkOutTotal", checkOutTotal);
		
		return "dashboardAdmin/Dashboard";
	}
	
	
}
