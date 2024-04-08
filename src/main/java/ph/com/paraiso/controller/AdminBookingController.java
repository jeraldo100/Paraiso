package ph.com.paraiso.controller;

import java.sql.Date;

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
import ph.com.paraiso.service.AdminBookingService;
import ph.com.paraiso.service.BookingService;
import ph.com.paraiso.service.RoomService;
import ph.com.paraiso.service.UserService;

@Controller
public class AdminBookingController {


	private AdminBookingService adminBookingService;
		
		public AdminBookingController(AdminBookingService adminBookingService) {
			super();
			this.adminBookingService = adminBookingService;
		}

		
		@GetMapping("/AdminBooking")
		public String adminBooking(Model model) {
			model.addAttribute("bookings", adminBookingService.getAllBookings());
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
			
			adminBookingService.addBooking(booking);
			
			return "redirect:/AdminBooking";
		}
		
		@GetMapping("/editBooking/{booking_id}")
		public String editBooking(@PathVariable("booking_id") Integer booking_id, Model model) {
			model.addAttribute("booking", adminBookingService.getBookingById(booking_id));
			return "dashboardAdmin/BookingCRUD/EditBooking";
		}
		
		@PostMapping("/updateBooking/{booking_id}")
		public String updateBooking(@PathVariable("booking_id") Integer booking_id,
				@ModelAttribute("booking") Booking booking,
				Model model) {
			
			Booking existingBooking = adminBookingService.getBookingById(booking_id);
			existingBooking.setBooking_id(booking_id);
			existingBooking.setUser_id(booking.getUser_id());
			existingBooking.setCheckin_date(booking.getCheckin_date());
			existingBooking.setCheckout_date(booking.getCheckout_date());
			existingBooking.setTotal_price(booking.getTotal_price());
			existingBooking.setArrival_time(booking.getArrival_time());
			existingBooking.setAdults(booking.getAdults());
			existingBooking.setChildren(booking.getChildren());
			existingBooking.setStatus(booking.getStatus());
			
			adminBookingService.updateBooking(existingBooking);
			return "redirect:/AdminBooking";
			
			
		}
		
		@GetMapping("/deleteBooking/{booking_id}")
		public String deleteBooking(@PathVariable("booking_id") Integer booking_id) {
			
			adminBookingService.deleteById(booking_id);
			return "redirect:/AdminBooking";
			
			
		}
		

		@PostMapping("/updateStatus/{bookingId}")
		public ResponseEntity<String> updateStatus(@PathVariable("bookingId") Integer bookingId, @RequestParam("status") String status) {
		    Booking booking = adminBookingService.getBookingById(bookingId);
		    if (booking != null) {
		        booking.setStatus(status);
		        adminBookingService.updateBooking(booking);
		        return new ResponseEntity<>("Status updated successfully", HttpStatus.OK);
		    } else {
		        return new ResponseEntity<>("Booking not found", HttpStatus.NOT_FOUND);
		    }
		    
		    
		}
		
	}

