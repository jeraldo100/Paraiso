package ph.com.paraiso.controller;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import ph.com.paraiso.dto.UserDto;
import ph.com.paraiso.model.Booking;
import ph.com.paraiso.model.User;
import ph.com.paraiso.repository.BookingRepository;
import ph.com.paraiso.service.BookingService;
import ph.com.paraiso.service.UserService;
import ph.com.paraiso.session.SessionManager;

@Controller
public class UserAuthController {
	
	@Autowired
	UserService userSvc;	
	@Autowired
	BookingRepository bookingRepository;	

	
	@PostMapping("/registration")
	public ResponseEntity<String> saveUser(@ModelAttribute("user") UserDto userDto, Model model) {
	    try {
	        userDto.setAccountType("USER");
	        boolean isEmailTaken = userSvc.isEmailTaken(userDto.getEmail()); 
	        boolean isUsernameTaken = userSvc.isUsernameTaken(userDto.getUsername()); 
	        if (isEmailTaken) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registration failed. Email is already in use.");
	        }
	        if (isUsernameTaken) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registration failed. Username is already in use.");
	        }
	        userSvc.save(userDto);
	        return ResponseEntity.status(HttpStatus.OK).body("Registered Successfully");
	    } catch (Exception e) {	    
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration failed. Please try again later.");
	    }
	}
				
	
		@PostMapping("/auth")
		@ResponseBody
		public ResponseEntity<Object> authenticate(@RequestParam String email, String password, HttpServletRequest request, 
			HttpServletResponse response, Model model) {
		    User user = new User(email, password);
		    String result = userSvc.authenticate(user);
		    List<User> users = userSvc.getUsers();
		    model.addAttribute("users", users);
		    if (result.equals("success")) {
		        String sessionId = UUID.randomUUID().toString();
		        SessionManager.createSessionCookie(response, sessionId, email);
		        Integer user_id = userSvc.getUserIdByEmail(email);
		        request.getSession().setAttribute("user_id", user_id);
		        
		        String accountType = userSvc.getAccountTypeByEmail(email);
		        if (accountType != null) {
		            model.addAttribute("accountType", accountType);
		            if (accountType.equals("ADMIN")) {
		                return ResponseEntity.ok().body(Collections.singletonMap("redirectUrl", "/admin/AdminDashboard"));
		            }
		            if (accountType.equals("USER")) {
		                return ResponseEntity.ok().body(Collections.singletonMap("redirectUrl", "/home"));
		            }
		        }
		    }
		    
		    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.singletonMap("error", "Invalid Credentials"));
		}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
	    String sessionId = SessionManager.getSessionId(request);
	    if (sessionId != null) {
	        SessionManager.deleteSessionCookie(response);
	        SessionManager.invalidateSession(sessionId); 
	    }
	    return "redirect:/home"; 
	}

	@RestController
	public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/jasperpdf/export")
    public void createPDF(HttpServletResponse response) throws IOException, JRException {
        response.setContentType("application/pdf");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=bookings.pdf";
        response.setHeader(headerKey, headerValue);
        bookingService.exportJasperReportRoom(response);
    }
}
	
}


