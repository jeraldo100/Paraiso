package ph.com.paraiso.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.util.Base64;

import ph.com.paraiso.model.Room_type;
import ph.com.paraiso.service.RoomTypesService;

@Controller
@RequestMapping("/admin")
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
		
		return "dashboardAdmin/RoomTypeCRUD/AddRoomType";
	}
	
	

	@PostMapping("/addRoomTypes/save")
	public String newRoomType(
	    @RequestParam("name") String name,
	    @RequestParam("description") String description,
	    @RequestParam("price_per_night") Double price_per_night,
	    @RequestParam("capacity") Integer capacity,
	    @RequestParam("beds") Integer beds,
	    @RequestParam("bathrooms") Integer bathrooms,
	    @RequestParam("roomImage") MultipartFile roomImage,
	    Model model) {
	    
	    Room_type room_type = new Room_type();
	    
	    room_type.setName(name);
	    room_type.setDescription(description);
	    room_type.setPrice_per_night(price_per_night);
	    room_type.setCapacity(capacity);
	    room_type.setBeds(beds);
	    room_type.setBathrooms(bathrooms);    
	    try {
	        byte[] imageData = roomImage.getBytes();
	        room_type.setRoomImage(imageData); 
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	    roomTypesService.addRoomTypes(room_type);
	    
	    return "redirect:/AdminRoomTypes";
	}

	
	@GetMapping("/editRoomTypes/{type_id}")
	public String editRoomTypes(@PathVariable("type_id") Integer type_id, Model model) {
		model.addAttribute("room_types", roomTypesService.getRoomTypesById(type_id));
		return "dashboardAdmin/RoomTypeCRUD/EditRoomType";
	}
	
	@PostMapping("/updates/{type_id}")
	public String updateRoomTypes(@PathVariable("type_id") Integer type_id,
	    @RequestParam("name") String name,
	    @RequestParam("description") String description,
	    @RequestParam("price_per_night") Double price_per_night,
	    @RequestParam("capacity") Integer capacity,
	    @RequestParam("beds") Integer beds,
	    @RequestParam("bathrooms") Integer bathrooms,
	    @RequestParam("roomImage") MultipartFile roomImage,
	    Model model) {

	    Room_type existingRoom_type = roomTypesService.getRoomTypesById(type_id);
	    existingRoom_type.setType_id(type_id);
	    existingRoom_type.setName(name);
	    existingRoom_type.setDescription(description);
	    existingRoom_type.setPrice_per_night(price_per_night);
	    existingRoom_type.setCapacity(capacity);
	    existingRoom_type.setBeds(beds);
	    existingRoom_type.setBathrooms(bathrooms);

	    try {
	        byte[] imageData = roomImage.getBytes();
	        existingRoom_type.setRoomImage(imageData);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    roomTypesService.updateRoomTypes(existingRoom_type);
	    return "redirect:/AdminRoomTypes";
	}

	
	@GetMapping("deleteType/{type_id}")
	public String deleteType(@PathVariable("type_id") Integer type_id) {
		roomTypesService.deleteById(type_id);
		
		return "redirect:/AdminRoomTypes";
	}
	
	
}
