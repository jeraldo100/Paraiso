package ph.com.paraiso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/addRoom")
	public String addRoom(Model model) {
		Room room = new Room();
		
		model.addAttribute("room", room);
		
		return "dashboardAdmin/Modals/AddRoom";
	}
	
	@PostMapping("/addRoom/save")
	public String newRoom(
			@RequestParam("hotel_id") Integer hotel_id,
			@RequestParam("type_id") Integer type_id,
			@RequestParam("status") String status,
			Model model) {
		Room room = new Room();
		
		room.setHotel_id(hotel_id);
		room.setType_id(type_id);
		room.setStatus(status);
		
		roomService.addRoom(room);
		
		return "redirect:/AdminRooms";
	}

	@GetMapping("/editRoom/{room_id}")
	public String editRoom(@PathVariable("room_id") Integer room_id, Model model) {
		model.addAttribute("room", roomService.getRoomById(room_id));
		return "dashboardAdmin/Modals/EditRoom";
	}
	
	@PostMapping("/update/{room_id}")
	public String updateRoom(@PathVariable("room_id") Integer room_id, 
			@ModelAttribute("room") Room room,
			Model model) {
		
		//get room from database by ID
		
		Room existingRoom = roomService.getRoomById(room_id);
		existingRoom.setRoom_id(room_id);
		existingRoom.setHotel_id(room.getHotel_id());
		existingRoom.setType_id(room.getRoom_id());
		existingRoom.setStatus(room.getStatus());
		
		//save 
		
		roomService.updateRoom(existingRoom);
		return "redirect:/AdminRooms";
		
		
	}
	
	@GetMapping("/delete/{room_id}")
	public String deleteRoom(@PathVariable("room_id") Integer room_id) {
		roomService.deleteRoomById(room_id);
		return "redirect:/AdminRooms";
	}
	
}
