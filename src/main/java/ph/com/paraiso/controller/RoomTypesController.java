package ph.com.paraiso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ph.com.paraiso.model.Room_type;
import ph.com.paraiso.service.RoomTypesService;

@Controller
public class RoomTypesController {

	@Autowired
	
	private RoomTypesService roomTypesService;
	
	public RoomTypesController(RoomTypesService roomTypesService) {
		super();
		this.roomTypesService = roomTypesService;
	}



	@GetMapping("/AdminRoomTypes")
	public String adminRoomTypes(Model model) {
		model.addAttribute("room_types", roomTypesService.getAllRoomTypes());
		return "dashboardAdmin/RoomTypes";
	}
	
	@GetMapping("/addRoomTypes")
	public String addRoomTypes(Model model) {
		Room_type room_type = new Room_type();
		
		model.addAttribute("room_type", room_type);
		
		return "dashboardAdmin/RoomTypeCRUD/AddRoom";
	}
	
	@PostMapping("/addRoomTypes/save")
	public String newRoomType(
			@RequestParam("name") String name,
			@RequestParam("description") String description,
			@RequestParam("price_per_night") Double price_per_night,
			@RequestParam("capacity") Integer capacity,
			@RequestParam("beds") Integer beds,
			@RequestParam("bathrooms") Integer bathrooms,
			Model model) {
		
		Room_type room_type = new Room_type();
		
		room_type.setName(name);
		room_type.setDescription(description);
		room_type.setPrice_per_night(price_per_night);
		room_type.setCapacity(capacity);
		room_type.setBeds(beds);
		room_type.setBathrooms(bathrooms);
		
		roomTypesService.addRoomTypes(room_type);
		
		return "redirect:/AdminRoomTypes";
		
	}
	
	@GetMapping("/editRoomTypes/{type_id}")
	public String editRoomTypes(@PathVariable("type_id") Integer type_id, Model model) {
		model.addAttribute("room_types", roomTypesService.getRoomTypesById(type_id));
		return "dashboardAdmin/RoomTypeCRUD/EditRoom";
	}
	
	
	
}
