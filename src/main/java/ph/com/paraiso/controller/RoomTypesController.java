package ph.com.paraiso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ph.com.paraiso.service.RoomTypesService;

@Controller
public class RoomTypesController {

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
	
	
}
