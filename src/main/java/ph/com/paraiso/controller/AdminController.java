package ph.com.paraiso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ph.com.paraiso.model.AddOns;
import ph.com.paraiso.model.Booking;
import ph.com.paraiso.model.Room;
import ph.com.paraiso.model.Room_type;
import ph.com.paraiso.model.User;
import ph.com.paraiso.model.Voucher;
import ph.com.paraiso.repository.AddOnsRepository;
import ph.com.paraiso.repository.AdminBookingRepository;
import ph.com.paraiso.repository.RoomRepository;
import ph.com.paraiso.repository.RoomTypesRepository;
import ph.com.paraiso.repository.UserRepository;
import ph.com.paraiso.repository.VoucherRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	//DashboardController

	@Autowired
	AdminBookingRepository adminBookingRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoomRepository roomRepository;
	@Autowired
	VoucherRepository voucherRepository;
	@Autowired
	RoomTypesRepository roomTypesRepository;
	@Autowired
	AddOnsRepository addOnsRepository;
	
	@GetMapping("/AdminDashboard")
	public String adminDashboardPage(Model model) {

		Double totalPrice = adminBookingRepository.totalPrice();
		model.addAttribute("totalPrice", totalPrice);

		Integer totalBooking = adminBookingRepository.totalBooking();
		model.addAttribute("totalBooking", totalBooking);

		Iterable<Booking> bookings = adminBookingRepository.findAll();
		model.addAttribute("bookings", bookings);

		Iterable<User> users = userRepository.findAll();
		model.addAttribute("users", users);
		
		Iterable<Room> room = roomRepository.findAll();
		model.addAttribute("rooms", room);
		
		Iterable<Room_type> roomTypes = roomTypesRepository.findAll();
		model.addAttribute("roomTypes", roomTypes);
		
		Iterable<Voucher> voucher = voucherRepository.findAll();
		model.addAttribute("voucher", voucher);
		
		Iterable<AddOns> addOns = addOnsRepository.findAll();
		model.addAttribute("addOns", addOns);
		
		return "dashboardAdmin/Dashboard"; 
	}
	
}
