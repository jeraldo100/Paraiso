package ph.com.paraiso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	
	
}
