package ph.com.paraiso.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ph.com.paraiso.model.Booked_room;
import ph.com.paraiso.model.Booking;
import ph.com.paraiso.model.Room_type;
import ph.com.paraiso.repository.Booked_roomRepository;
import ph.com.paraiso.repository.BookingRepository;
import ph.com.paraiso.repository.Room_TypeRepository;
import ph.com.paraiso.service.UserService;
import ph.com.paraiso.session.SessionManager;


@Controller
public class UserDashboardController {
	
	@Autowired
	BookingRepository bookRepo;
	
	@Autowired
	Booked_roomRepository brRepo;
	
	@Autowired
	UserService userSvc;
	
	@Autowired
	Room_TypeRepository rtRepo;
	
	public void setCommonAttributes(HttpServletRequest request, Model model) { 
        String userEmail = SessionManager.getEmailFromSession(request);
        if (userEmail != null) {
            String accountType = userSvc.getAccountTypeByEmail(userEmail);
            String username = userSvc.getUsernameByEmail(userEmail);
            Integer userId = userSvc.getUserIdByEmail(userEmail);
            System.out.println("Email of the user with current session: " + userEmail);
            System.out.println("AccountType of the user with current session: " + accountType);
            System.out.println("username of the user with current session: " + username);
            System.out.println("user id of the user with current session: " + userId);
            model.addAttribute("username", username);
            model.addAttribute("loggedIn", true);
        } else {
            System.out.println("No user associated with the current session.");
            model.addAttribute("loggedIn", false);
        }
    }
	
	@GetMapping("/userDashboard")
	public String userDashboard(HttpServletRequest request, Model model){
		setCommonAttributes(request, model);
		
		String userEmail = SessionManager.getEmailFromSession(request);
		Integer user_id = userSvc.getUserIdByEmail(userEmail);
		
		List<Map<String, Object>> bookingsAndRooms = new ArrayList();
		List<Booking> bookings = bookRepo.getBookingsByUserId(user_id);
		
		for(Booking booking: bookings) {
			Map bAndRs = new HashMap();
			bAndRs.put("booking", booking);
			Integer booking_id = booking.getBooking_id();
			List<Integer> room_ids = brRepo.getAllRoomIdByBookingId(booking_id);
			List<Room_type> room_types = rtRepo.getAllRoomNamesByRoomIds(room_ids);
			for(Room_type e: room_types) { 
				e.setRoomImageEncoded(Base64.getEncoder().encodeToString( e.getRoomImage() ) ); 
			}
			bAndRs.put("room_names", room_types);
			bookingsAndRooms.add(bAndRs);
		}
		
		model.addAttribute("bookingsAndRooms", bookingsAndRooms);
		return "dashboardUser/userDashboard";
	}
	
	
	
	@PostMapping("userDashboard/cancel/{booking_id}") 
	public ModelAndView cancelBooking(@PathVariable Integer booking_id, HttpServletRequest request, HttpServletResponse response) throws IOException{ 
		System.out.println(booking_id);
		Booking booking = bookRepo.findById(booking_id).get();
		
		booking.setStatus("Cancelled");
		bookRepo.save(booking);
		
		return new ModelAndView("redirect:/userDashboard");
	}
	 

}
	