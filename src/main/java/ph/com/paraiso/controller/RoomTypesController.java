package ph.com.paraiso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoomTypesController {

	@GetMapping("/AdminRoomTypes")
	public String adminRoomTypes() {
		return "dashboardAdmin/RoomTypes";
	}
	
}
