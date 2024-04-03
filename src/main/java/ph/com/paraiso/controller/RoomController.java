package ph.com.paraiso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ph.com.paraiso.model.Room;
import ph.com.paraiso.service.RoomService;

@Controller
public class RoomController {
	
	@Autowired

	private RoomService roomService;

	public RoomController(RoomService roomService) {
		super();
		this.roomService = roomService;
	}

	@GetMapping("/AdminRooms")
	public String adminRooms(Model model) {
		model.addAttribute("rooms", roomService.getAllRooms());
		return "dashboardAdmin/Rooms";
	}
	
	

}
