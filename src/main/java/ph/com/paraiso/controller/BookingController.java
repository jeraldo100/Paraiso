package ph.com.paraiso.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import ph.com.paraiso.model.DateRanges;
import ph.com.paraiso.model.Room;
import ph.com.paraiso.model.Room_joined;
import ph.com.paraiso.model.Room_type;
import ph.com.paraiso.service.BookingService;
import ph.com.paraiso.service.RoomService;

@Controller
public class BookingController {
	
	@Autowired
	private BookingService bookServ;
	
	@ResponseBody
	@PostMapping(value = "/booking/getRooms", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Room_type> getRooms(@RequestBody JsonNode jsonNode) throws JsonMappingException, JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		DateRanges dateRanges = mapper.treeToValue(jsonNode, DateRanges.class);
		
		String checkin_date = dateRanges.getCheckout_date();
		String checkout_date = dateRanges.getCheckout_date();
		
		List<Room_type> room_types = bookServ.listAllRoom_type(checkin_date, checkout_date);
		return room_types;
	}
	
	@GetMapping("/booking")
	public String bookingPage(Model model) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		double diff = Math.abs( (sdf.parse(sdf.format(new Date())).getTime()) - (sdf.parse(sdf.format(new Date())).getTime()) );
		
		model.addAttribute("days", TimeUnit.DAYS.convert( (long) diff, TimeUnit.MILLISECONDS) );
		model.addAttribute("checkin_date" , sdf.format(new Date()));
		model.addAttribute("checkout_date" , sdf.format(new Date()));
		return "booking/Booking";
	}
	
	@PostMapping("/checkAvailability")
	public String checkAvailability(@RequestParam String checkin_date, String checkout_date, Model model) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		double diff = Math.abs( (sdf.parse(checkin_date).getTime()) - (sdf.parse(checkout_date).getTime()) );
		
		model.addAttribute("days", TimeUnit.DAYS.convert( (long) diff, TimeUnit.MILLISECONDS) );
		model.addAttribute("checkin_date", checkin_date);
		model.addAttribute("checkout_date", checkout_date);
		return "booking/Booking";
	}
	
	@ResponseBody
	@PostMapping(value = "addRoom/{type_id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Room_joined addRoom(@PathVariable Integer type_id, @RequestBody JsonNode jsonNode) throws JsonMappingException, JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		DateRanges dateRanges = mapper.treeToValue(jsonNode, DateRanges.class);
		
		String checkin_date = dateRanges.getCheckout_date();
		String checkout_date = dateRanges.getCheckout_date();
		
		Room_joined room = bookServ.getRoom_joined(type_id);
		return room;
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
