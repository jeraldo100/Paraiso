package ph.com.paraiso.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import ph.com.paraiso.model.AddOns;
import ph.com.paraiso.model.Booking;
import ph.com.paraiso.model.Room;
import ph.com.paraiso.model.Room_type;
import ph.com.paraiso.model.User;
import ph.com.paraiso.model.Voucher;
import ph.com.paraiso.repository.AddOnsRepository;
import ph.com.paraiso.repository.AdminBookingRepository;
import ph.com.paraiso.repository.RoomRepository;
import ph.com.paraiso.repository.RoomTypesRepository;
import ph.com.paraiso.repository.UserRepository;
import ph.com.paraiso.repository.VoucherRepository;
import ph.com.paraiso.service.AdminBookingService;
import ph.com.paraiso.service.AdminUserService;
import ph.com.paraiso.service.UserService;
import ph.com.paraiso.session.SessionManager;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	//DashboardController

	@Autowired
	AdminBookingRepository adminBookingRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoomRepository roomRepository;
	@Autowired
	VoucherRepository voucherRepository;
	@Autowired
	RoomTypesRepository roomTypesRepository;
	@Autowired
	AddOnsRepository addOnsRepository;
	
	@GetMapping("/AdminDashboard")
	public String adminDashboardPage(Model model) {

		Double totalPrice = adminBookingRepository.totalPrice();
		model.addAttribute("totalPrice", totalPrice);

		Integer totalBooking = adminBookingRepository.totalBooking();
		model.addAttribute("totalBooking", totalBooking);

		Iterable<Booking> bookings = adminBookingRepository.findAll();
		model.addAttribute("bookings", bookings);

		Iterable<User> users = userRepository.findAll();
		model.addAttribute("users", users);
		
		Iterable<Room> room = roomRepository.findAll();
		model.addAttribute("rooms", room);
		
		Iterable<Room_type> roomTypes = roomTypesRepository.findAll();
		model.addAttribute("roomTypes", roomTypes);
		
		Iterable<Voucher> voucher = voucherRepository.findAll();
		model.addAttribute("voucher", voucher);
		
		Iterable<AddOns> addOns = addOnsRepository.findAll();
		model.addAttribute("addOns", addOns);
		
		return "dashboardAdmin/Dashboard"; 
	}
	
	//BookingController
	
	private AdminBookingService adminBookingService;
	
	public AdminController(AdminBookingService adminBookingService) {
		super();
		this.adminBookingService = adminBookingService;
	}

	
	@GetMapping("/AdminBooking")
	public String adminBooking(Model model) {
		model.addAttribute("bookings", adminBookingService.getAllBookings());
		return "dashboardAdmin/Booking";
	}
	
	@GetMapping("/addBooking")
	public String addBooking(Model model) {
		
		Booking booking = new Booking();
		
		model.addAttribute("booking",booking);
		
		return "dashboardAdmin/BookingCRUD/AddBooking";
	}
	
	
	@PostMapping("/addBooking/save")
	public String newBooking(
			@RequestParam("user_id") Integer user_id,
			@RequestParam("checkin_date") Date checkin_date,
			@RequestParam("checkout_date") Date checkout_date,
			@RequestParam("total_price") Double total_price,
			@RequestParam("arrival_time") String arrival_time,
			@RequestParam("adults") Integer adults,
			@RequestParam("children") Integer children,
			@RequestParam("status") String status,
			Model model) {
	
		Booking booking = new Booking();
		
		booking.setUser_id(user_id);
		booking.setCheckin_date(checkin_date);
		booking.setCheckout_date(checkout_date);
		booking.setTotal_price(total_price);
		booking.setArrival_time(arrival_time);
		booking.setAdults(adults);
		booking.setChildren(children);
		booking.setStatus(status);
		
		adminBookingService.addBooking(booking);
		
		return "redirect:/AdminBooking";
	}
	
	@GetMapping("/editBooking/{booking_id}")
	public String editBooking(@PathVariable("booking_id") Integer booking_id, Model model) {
		model.addAttribute("booking", adminBookingService.getBookingById(booking_id));
		return "dashboardAdmin/BookingCRUD/EditBooking";
	}
	
	@PostMapping("/updateBooking/{booking_id}")
	public String updateBooking(@PathVariable("booking_id") Integer booking_id,
			@ModelAttribute("booking") Booking booking,
			Model model) {
		
		Booking existingBooking = adminBookingService.getBookingById(booking_id);
		existingBooking.setBooking_id(booking_id);
		existingBooking.setUser_id(booking.getUser_id());
		existingBooking.setCheckin_date(booking.getCheckin_date());
		existingBooking.setCheckout_date(booking.getCheckout_date());
		existingBooking.setTotal_price(booking.getTotal_price());
		existingBooking.setArrival_time(booking.getArrival_time());
		existingBooking.setAdults(booking.getAdults());
		existingBooking.setChildren(booking.getChildren());
		existingBooking.setStatus(booking.getStatus());
		
		adminBookingService.updateBooking(existingBooking);
		return "redirect:/AdminBooking";
		
		
	}
	
	@GetMapping("/deleteBooking/{booking_id}")
	public String deleteBooking(@PathVariable("booking_id") Integer booking_id) {
		
		adminBookingService.deleteById(booking_id);
		return "redirect:/AdminBooking";
		
		
	}
	

	@PostMapping("/updateStatus/{bookingId}")
	public ResponseEntity<String> updateStatus(@PathVariable("bookingId") Integer bookingId, @RequestParam("status") String status) {
	    Booking booking = adminBookingService.getBookingById(bookingId);
	    if (booking != null) {
	        booking.setStatus(status);
	        adminBookingService.updateBooking(booking);
	        return new ResponseEntity<>("Status updated successfully", HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>("Booking not found", HttpStatus.NOT_FOUND);
	    }
	    
	    
	}
	
	//UserController
	
	@Autowired
	UserService userSvc;
	private AdminUserService adminUserService;

	public AdminController(AdminUserService adminUserService) {
		super();
		this.adminUserService = adminUserService;
	}
	
	@GetMapping("/AdminUsers")
	public String adminUsers(HttpServletRequest request, Model model) {
		
        String userEmail = SessionManager.getEmailFromSession(request);
        if (userEmail != null) {
            String accountType = userSvc.getAccountTypeByEmail(userEmail);
            String username = userSvc.getUsernameByEmail(userEmail);
            model.addAttribute("username", username);
            if(accountType.equals("ADMIN")) {
        		model.addAttribute("users", adminUserService.getAllUsers());
        		return "dashboardAdmin/Users";
            }
        } 
        return "ErrorPages/AccessDeniedError";
	}
	
	@GetMapping("/addUser")
	public String addUser(HttpServletRequest request, Model model) {
	     String userEmail = SessionManager.getEmailFromSession(request);
	        if (userEmail != null) {
	            String accountType = userSvc.getAccountTypeByEmail(userEmail);
	            String username = userSvc.getUsernameByEmail(userEmail);
	            model.addAttribute("username", username);
	            if(accountType.equals("ADMIN")) {
	            	return "dashboardAdmin/UsersCRUD/AddUsers";
	            }
	        } 
	        return "ErrorPages/AccessDeniedError";	
	}
	
	@PostMapping("/addUser/save")
	public String saveUser(
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("account_type") String account_type,
			@RequestParam("first_name") String first_name,
			@RequestParam("last_name") String last_name,
			@RequestParam("date_of_birth") Date date_of_birth,
			@RequestParam("address") String address,
			@RequestParam("phone") String phone,
			@RequestParam("email") String email,
			Model model) {
		
		User user = new User();
		
		user.setUsername(username);
		user.setPassword(password);
		user.setAccountType(account_type);
		user.setFirstName(first_name);
		user.setLastName(last_name);
		user.setDateOfBirth(date_of_birth);
		user.setAddress(address);
		user.setPhone(phone);
		user.setEmail(email);
		
		adminUserService.addUser(user);
		
		return "redirect:/AdminUsers";
		
	}
	
	@GetMapping("/editUser/{userid}")
	public String editUser(HttpServletRequest request, @PathVariable("userid") Integer userid, Model model) {
		 String userEmail = SessionManager.getEmailFromSession(request);
	        if (userEmail != null) {
	            String accountType = userSvc.getAccountTypeByEmail(userEmail);
	            String username = userSvc.getUsernameByEmail(userEmail);
	            model.addAttribute("username", username);
	            if(accountType.equals("ADMIN")) {
	        		model.addAttribute("user", adminUserService.getUserById(userid));        		
	        		return "dashboardAdmin/UsersCRUD/EditUsers";
	            }
	        } 
	        return "ErrorPages/AccessDeniedError";		
	}
	
	@PostMapping("/updateUser/{userid}")
	public String updateUser(@PathVariable("user_id") Integer userid,
			@ModelAttribute("user_id") User user,
			Model model) {
		
		User existingUser = adminUserService.getUserById(userid);
		existingUser.setUsername(user.getUsername());
		existingUser.setPassword(user.getPassword());
		existingUser.setAccountType(user.getAccountType());
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setDateOfBirth(user.getDateOfBirth());
		existingUser.setAddress(user.getAddress());
		existingUser.setPhone(user.getPhone());
		existingUser.setEmail(user.getEmail());
		
		adminUserService.updateUser(existingUser);
		
		return "redirect:/AdminUsers";

	}
	
	@GetMapping("/deleteUser/{userid}")
	public String deleteUser(HttpServletRequest request, @PathVariable("userid") Integer userid, Model model) {
        String userEmail = SessionManager.getEmailFromSession(request);
        if (userEmail != null) {
            String accountType = userSvc.getAccountTypeByEmail(userEmail);
            String username = userSvc.getUsernameByEmail(userEmail);
            model.addAttribute("username", username);
            if(accountType.equals("ADMIN")) {
        		adminUserService.deleteUserById(userid);
        		return "redirect:/AdminUsers";
            }
        } 
        return "ErrorPages/AccessDeniedError";

	}
	
	@GetMapping("/payment")
	public String payment() {
		return "paymentModule";
	}
	
}
