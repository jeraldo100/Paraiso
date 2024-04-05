package ph.com.paraiso.controller;

import java.sql.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ph.com.paraiso.model.Booking;
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
	
	@GetMapping("/addBooking")
	public String addBooking(Model model) {
		
		Booking booking = new Booking();
		
		model.addAttribute("booking",booking);
		
		return "dashboardAdmin/BookingCRUD/AddBooking";
	}
	
	
	@PostMapping("/addBooking/save")
	public String newBooking(
			@RequestParam("user_id") Integer user_id,
			@RequestParam("checkin_date") Date checkin_date,
			@RequestParam("checkout_date") Date checkout_date,
			@RequestParam("total_price") Double total_price,
			@RequestParam("arrival_time") String arrival_time,
			@RequestParam("adults") Integer adults,
			@RequestParam("children") Integer children,
			@RequestParam("status") String status,
			Model model) {
	
		Booking booking = new Booking();
		
		booking.setUser_id(user_id);
		booking.setCheckin_date(checkin_date);
		booking.setCheckout_date(checkout_date);
		booking.setTotal_price(total_price);
		booking.setArrival_time(arrival_time);
		booking.setAdults(adults);
		booking.setChildren(children);
		booking.setStatus(status);
		
		bookingService.addBooking(booking);
		
		return "redirect:/AdminBooking";
	}
	
	@GetMapping("/editBooking/{booking_id}")
	public String editBooking(@PathVariable("booking_id") Integer booking_id, Model model) {
		model.addAttribute("booking", bookingService.getBookingById(booking_id));
		return "dashboardAdmin/BookingCRUD/EditBooking";
	}
	
	@PostMapping("/updateBooking/{booking_id}")
	public String updateBooking(@PathVariable("booking_id") Integer booking_id,
			@ModelAttribute("booking") Booking booking,
			Model model) {
		
		Booking existingBooking = bookingService.getBookingById(booking_id);
		existingBooking.setBooking_id(booking_id);
		existingBooking.setUser_id(booking.getUser_id());
		existingBooking.setCheckin_date(booking.getCheckin_date());
		existingBooking.setCheckout_date(booking.getCheckout_date());
		existingBooking.setTotal_price(booking.getTotal_price());
		existingBooking.setArrival_time(booking.getArrival_time());
		existingBooking.setAdults(booking.getAdults());
		existingBooking.setChildren(booking.getChildren());
		existingBooking.setStatus(booking.getStatus());
		
		bookingService.updateBooking(existingBooking);
		return "redirect:/AdminBooking";
		
		
	}
	
	@GetMapping("/deleteBooking/{booking_id}")
	public String deleteBooking(@PathVariable("booking_id") Integer booking_id) {
		
		bookingService.deleteById(booking_id);
		return "redirect:/AdminBooking";
		
		
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
