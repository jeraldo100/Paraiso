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
		Date today = new Date();
		Date tommorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));
		double diff = Math.abs( (today.getTime()) - (tommorrow.getTime()) );
		
		model.addAttribute("days", TimeUnit.DAYS.convert( (long) diff, TimeUnit.MILLISECONDS) );
		model.addAttribute( "checkin_date" , sdf.format(today) );
		model.addAttribute( "checkout_date" , sdf.format(tommorrow) );
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
		Room_joined room = new Room_joined();
		
		ObjectMapper mapper = new ObjectMapper();
		DateRanges dateRanges = mapper.treeToValue(jsonNode, DateRanges.class);
		
		String checkin_date = dateRanges.getCheckout_date();
		String checkout_date = dateRanges.getCheckout_date();
		String room_ids = dateRanges.getRoom_ids();
		
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
	
	
	
	private RoomService roomService;

	public BookingController(RoomService roomService) {
		super();
		this.roomService = roomService;
	}
	
	
}