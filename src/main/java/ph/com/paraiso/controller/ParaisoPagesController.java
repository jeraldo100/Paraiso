package ph.com.paraiso.controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.servlet.http.HttpServletRequest;
import ph.com.paraiso.model.Room_type;
import ph.com.paraiso.repository.AddOnsRepository;
import ph.com.paraiso.repository.AdminBookingRepository;
import ph.com.paraiso.repository.RoomRepository;
import ph.com.paraiso.repository.RoomTypesRepository;
import ph.com.paraiso.repository.UserRepository;
import ph.com.paraiso.repository.VoucherRepository;
import ph.com.paraiso.service.AddOnsService;
import ph.com.paraiso.service.AdminBookingService;
import ph.com.paraiso.service.AdminUserService;
import ph.com.paraiso.service.RoomService;
import ph.com.paraiso.service.RoomTypesService;
import ph.com.paraiso.service.UserService;
import ph.com.paraiso.service.VoucherService;
import ph.com.paraiso.session.SessionManager;


@Controller
public class ParaisoPagesController {
	
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
            model.addAttribute("accountType", accountType);
            model.addAttribute("loggedIn", true);
        } else {
            System.out.println("No user associated with the current session.");
            model.addAttribute("loggedIn", false);
        }
    }

	@Autowired
	private RoomTypesService roomTypesService;

	@GetMapping("/home")
	public String homePage(HttpServletRequest request, Model model) {
		setCommonAttributes(request, model);
		model.addAttribute("room_types", roomTypesService.getAllRoomTypes());
	    return "home";
	}
	
    @GetMapping("/contact")
    public String contactPage(HttpServletRequest request, Model model) {
        model.addAttribute("pageTitle", "Contact");
        model.addAttribute("pageLink", "/contact");
		setCommonAttributes(request, model);
        return "contact"; 
    }
    
    @GetMapping("/about")
    public String aboutPage(HttpServletRequest request, Model model) {
        model.addAttribute("pageTitle", "About");
        model.addAttribute("pageLink", "/about");
		setCommonAttributes(request, model);
        return "about"; 
    }
    
    @GetMapping("/services")
    public String servicesPage(HttpServletRequest request, Model model) {
        model.addAttribute("pageTitle", "Services");
        model.addAttribute("pageLink", "/services");
		setCommonAttributes(request, model);
        return "services"; 
    }

    @GetMapping("/roomdetail/{type_id}")
    public String roomdetailPage(@PathVariable Integer type_id, HttpServletRequest request, Model model) {
        Room_type roomType = roomTypesService.getRoomTypesById(type_id);
        if (roomType != null) {
            model.addAttribute("room_type", roomType);
        } else {
            model.addAttribute("error", "Room type not found");
        }
        model.addAttribute("pageTitle", "Room Detail");
        model.addAttribute("pageLink", "/roomdetail");
        setCommonAttributes(request, model);
        return "roomdetail";
    }
    @GetMapping("/rooms")
    public String roomsPage(HttpServletRequest request, Model model) {
		model.addAttribute("room_types", roomTypesService.getAllRoomTypes());
        model.addAttribute("pageTitle", "Rooms");
        model.addAttribute("pageLink", "/rooms");
		setCommonAttributes(request, model);
        return "rooms"; 
    }
	

}