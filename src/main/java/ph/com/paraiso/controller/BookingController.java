package ph.com.paraiso.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class BookingController {
	
	private BookingService bookServ;
	
	public BookingController(BookingService bookingService) {
		super();
		this.bookServ = bookingService;
	}

	
	@GetMapping("/AdminBooking")
	public String adminBooking(Model model) {
		model.addAttribute("bookings", bookServ.getAllBookings());
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
		
		bookServ.addBooking(booking);
		
		return "redirect:/AdminBooking";
	}
	
	@GetMapping("/editBooking/{booking_id}")
	public String editBooking(@PathVariable("booking_id") Integer booking_id, Model model) {
		model.addAttribute("booking", bookServ.getBookingById(booking_id));
		return "dashboardAdmin/BookingCRUD/EditBooking";
	}
	
	@PostMapping("/updateBooking/{booking_id}")
	public String updateBooking(@PathVariable("booking_id") Integer booking_id,
			@ModelAttribute("booking") Booking booking,
			Model model) {
		
		Booking existingBooking = bookServ.getBookingById(booking_id);
		existingBooking.setBooking_id(booking_id);
		existingBooking.setUser_id(booking.getUser_id());
		existingBooking.setCheckin_date(booking.getCheckin_date());
		existingBooking.setCheckout_date(booking.getCheckout_date());
		existingBooking.setTotal_price(booking.getTotal_price());
		existingBooking.setArrival_time(booking.getArrival_time());
		existingBooking.setAdults(booking.getAdults());
		existingBooking.setChildren(booking.getChildren());
		existingBooking.setStatus(booking.getStatus());
		
		bookServ.updateBooking(existingBooking);
		return "redirect:/AdminBooking";
		
		
	}
	
	@GetMapping("/deleteBooking/{booking_id}")
	public String deleteBooking(@PathVariable("booking_id") Integer booking_id) {
		
		bookServ.deleteById(booking_id);
		return "redirect:/AdminBooking";
		
		
	}
	
	@GetMapping("/UserEditProfile")
	public String userEditProfile() {
		return "dashboardUser/userEditProfile";
	}
	
	@GetMapping("/UserProfile")
	public String userProfile() {
		return "dashboardUser/userProfile";
	}

	@PostMapping("/updateStatus/{bookingId}")
	public ResponseEntity<String> updateStatus(@PathVariable("bookingId") Integer bookingId, @RequestParam("status") String status) {
	    Booking booking = bookServ.getBookingById(bookingId);
	    if (booking != null) {
	        booking.setStatus(status);
	        bookServ.updateBooking(booking);
	        return new ResponseEntity<>("Status updated successfully", HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>("Booking not found", HttpStatus.NOT_FOUND);
	    }
	    
	    
	}
	
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
