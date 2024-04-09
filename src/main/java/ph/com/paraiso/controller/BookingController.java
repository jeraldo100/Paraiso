package ph.com.paraiso.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import jakarta.servlet.http.HttpServletRequest;
import ph.com.paraiso.model.Booked_room;
import ph.com.paraiso.model.Booking;
import ph.com.paraiso.model.BookingInputs;
import ph.com.paraiso.model.Room;
import ph.com.paraiso.model.Room_joined;
import ph.com.paraiso.model.Room_type;
import ph.com.paraiso.service.BookingService;
import ph.com.paraiso.service.RoomService;
import ph.com.paraiso.service.UserService;
import ph.com.paraiso.session.SessionManager;

@Controller
public class BookingController {
	
	@Autowired
	private BookingService bookServ;
	
	@Autowired
	UserService userSvc;
	
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
	
	@ResponseBody
	@PostMapping(value = "/booking/getRooms", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Room_type> getRooms(@RequestBody JsonNode jsonNode) throws JsonMappingException, JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		BookingInputs bookingInputs = mapper.treeToValue(jsonNode, BookingInputs.class);
		
		String checkin_date = bookingInputs.getCheckout_date();
		String checkout_date = bookingInputs.getCheckout_date();
		
		List<Room_type> room_types = bookServ.listAllRoom_type(checkin_date, checkout_date);
		System.out.println(room_types);
		return room_types;
	}
	
	@GetMapping("/booking")
	public String bookingPage(HttpServletRequest request, Model model) throws ParseException {
		setCommonAttributes(request, model);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date today = new Date();
		Date tommorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));
		double diff = Math.abs( (today.getTime()) - (tommorrow.getTime()) );
		
		
		model.addAttribute("pageTitle", "Booking");
        model.addAttribute("pageLink", "/booking");
		model.addAttribute( "adults" , 1 );
		model.addAttribute( "children" , 0 );
		model.addAttribute("days", TimeUnit.DAYS.convert( (long) diff, TimeUnit.MILLISECONDS) );
		model.addAttribute( "checkin_date" , sdf.format(today) );
		model.addAttribute( "checkout_date" , sdf.format(tommorrow) );
		return "booking/Booking";
	}
	
	@GetMapping("/bookings")
	public String bookingPages(Model model) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date today = new Date();
		Date tommorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));
		double diff = Math.abs( (today.getTime()) - (tommorrow.getTime()) );
		
		model.addAttribute("days", TimeUnit.DAYS.convert( (long) diff, TimeUnit.MILLISECONDS) );
		model.addAttribute( "checkin_date" , sdf.format(today) );
		model.addAttribute( "checkout_date" , sdf.format(tommorrow) );
		return "Booking";
	}
	
	@PostMapping("/checkAvailability")
	public String checkAvailability(HttpServletRequest request, @RequestParam String checkin_date, String checkout_date, Integer adults, Integer children, Model model) throws ParseException {
		setCommonAttributes(request, model);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		double diff = Math.abs( (sdf.parse(checkin_date).getTime()) - (sdf.parse(checkout_date).getTime()) );
		
		model.addAttribute("pageTitle", "Booking");
        model.addAttribute("pageLink", "/booking");
		model.addAttribute("adults", adults);
		model.addAttribute("children", children);
		model.addAttribute("days", TimeUnit.DAYS.convert( (long) diff, TimeUnit.MILLISECONDS) );
		model.addAttribute("checkin_date", checkin_date);
		model.addAttribute("checkout_date", checkout_date);
		return "booking/Booking";
	}
	
	@ResponseBody
	@PostMapping(value = "addRoom/{type_id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Room_joined addRoom(@PathVariable Integer type_id, @RequestBody JsonNode jsonNode) throws JsonMappingException, JsonProcessingException{
		Room_joined room = new Room_joined();
		
		ObjectMapper mapper = new ObjectMapper();
		BookingInputs bookingInputs = mapper.treeToValue(jsonNode, BookingInputs.class);
		
		String checkin_date = bookingInputs.getCheckout_date();
		String checkout_date = bookingInputs.getCheckout_date();
		String room_ids = bookingInputs.getRoom_ids();
		
		List<Integer> room_ids_list = new ArrayList<Integer>();
		if( !(room_ids.equals("")) ) {
			String [] room_ids_array = room_ids.trim().split(" ");
			
			for(Integer i = 0; i<room_ids_array.length; i++) {
				room_ids_list.add( Integer.parseInt(room_ids_array[i]) );
			}
		}
		
		if(room_ids.equals("")){
			room = bookServ.getRoom_joined_first(type_id, checkin_date, checkout_date);
		} else {
			room = bookServ.getRoom_joined(type_id, checkin_date, checkout_date, room_ids_list);
		}
		
		return room;
	}
	
	@ResponseBody
	@PostMapping(value = "removeRoom/{room_id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Room_joined> removeRoom(@PathVariable Integer room_id, @RequestBody Map<String, List<Integer>> room_ids_request) throws JsonMappingException, JsonProcessingException{
		
		List<Integer> room_ids = room_ids_request.get("room_ids");
		
		room_ids.remove(Integer.valueOf(room_id));
		
		List<Room_joined> newRoomsAdded = bookServ.getRoom_joinedList(room_ids);

		return newRoomsAdded;
	}
	
	@PostMapping(value = "confirmBooking/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String confirmBooking(HttpServletRequest request, @RequestBody JsonNode jsonNode) throws JsonProcessingException, IllegalArgumentException, ParseException {
		Booking booking = new Booking();
		
		String userEmail = SessionManager.getEmailFromSession(request);
		Integer user_id = userSvc.getUserIdByEmail(userEmail);
		
		System.out.println("confirmBooking: ");
		ObjectMapper mapper = new ObjectMapper();
		BookingInputs bookingInputs = mapper.treeToValue(jsonNode, BookingInputs.class);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date checkin_date = sdf.parse(bookingInputs.getCheckin_date());
		Date checkout_date = sdf.parse(bookingInputs.getCheckout_date());
		String room_ids = bookingInputs.getRoom_ids();
		Integer adults = bookingInputs.getAdults();
		Integer children = bookingInputs.getChildren();
		
		
		List<Integer> room_ids_list = new ArrayList<Integer>();
		String [] room_ids_array = room_ids.trim().split(" ");
		for(Integer i = 0; i<room_ids_array.length; i++) {
			room_ids_list.add( Integer.parseInt(room_ids_array[i]) );
		}
		
		Double total_price = bookServ.getTotalPriceRooms(room_ids_list);
		double diff = Math.abs( (checkin_date.getTime()) - (checkout_date.getTime()) );
		Long nights = TimeUnit.DAYS.convert( (long) diff, TimeUnit.MILLISECONDS);
		total_price = total_price*nights;
		
		booking.setUser_id(user_id);
		booking.setCheckin_date(checkin_date);
		booking.setCheckout_date(checkout_date);
		booking.setTotal_price(total_price);
		booking.setArrival_time("01:00 - 02:00");
		booking.setAdults(adults);
		booking.setChildren(children);
		booking.setStatus("PENDING");
		
		System.out.println(booking.toString());
		
		Booking addedBooking = bookServ.addConfirmedBooking(booking);
		System.out.println(addedBooking.getBooking_id());
		
		for(Integer room_id: room_ids_list) {
			Double price = bookServ.getPriceOfRoomByRoomId(room_id);
			Booked_room booked_room = new Booked_room(addedBooking.getBooking_id(), room_id, checkin_date, checkout_date, price);
			System.out.println(booked_room.toString());
			bookServ.addBooked_room(booked_room);
		}
		

		
		return "redirect:/home";
	}
	
}