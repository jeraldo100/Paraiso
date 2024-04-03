package ph.com.paraiso.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ph.com.paraiso.service.BookingService;
import ph.com.paraiso.service.RoomService;

@Controller
public class BookingController {
	
	@Autowired
	private BookingService bookServ;
	
	@GetMapping("/booking")
	public String bookingPage(Model model) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		double diff = Math.abs( (sdf.parse(sdf.format(new Date())).getTime()) - (sdf.parse(sdf.format(new Date())).getTime()) );
		
		model.addAttribute("days", TimeUnit.DAYS.convert( (long) diff, TimeUnit.MILLISECONDS) );
		model.addAttribute("checkin_date" , sdf.format(new Date()));
		model.addAttribute("checkout_date" , sdf.format(new Date()));
		model.addAttribute("room_types",bookServ.listAllRoom_type(sdf.format(new Date()), sdf.format(new Date()) ) );
		return "booking/Booking";
	}
	
	@PostMapping("/checkAvailability")
	public String checkAvailability(@RequestParam String checkin_date, String checkout_date, Model model) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		double diff = Math.abs( (sdf.parse(checkin_date).getTime()) - (sdf.parse(checkout_date).getTime()) );
		
		model.addAttribute("days", TimeUnit.DAYS.convert( (long) diff, TimeUnit.MILLISECONDS) );
		model.addAttribute("checkin_date", checkin_date);
		model.addAttribute("checkout_date", checkout_date);
		model.addAttribute("room_types",bookServ.listAllRoom_type(checkin_date, checkout_date));
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
