package ph.com.paraiso.controller;

import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;

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
import ph.com.paraiso.service.AddOnsService;
import ph.com.paraiso.service.AdminBookingService;
import ph.com.paraiso.service.AdminUserService;
import ph.com.paraiso.service.RoomService;
import ph.com.paraiso.service.RoomTypesService;
import ph.com.paraiso.service.UserService;
import ph.com.paraiso.service.VoucherService;
import ph.com.paraiso.session.SessionManager;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private final AdminBookingService adminBookingService;
    private final AdminUserService adminUserService;
    private final RoomService roomService;
    private final VoucherService voucherService;
    private final RoomTypesService roomTypesService;
    private final AddOnsService addOnsService;
	
	@Autowired
    public AdminController(AdminBookingService adminBookingService, AdminUserService adminUserService, RoomService roomService, VoucherService voucherService, RoomTypesService roomTypesService, AddOnsService addOnsService) {
        this.adminBookingService = adminBookingService;
        this.adminUserService = adminUserService;
        this.roomService = roomService;
        this.voucherService = voucherService;
        this.roomTypesService = roomTypesService;
		this.addOnsService = addOnsService;
    }

	
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
		
		return "redirect:/admin/AdminBooking";
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
		return "redirect:/admin/AdminBooking";
		
		
	}
	
	@GetMapping("/deleteBooking/{booking_id}")
	public String deleteBooking(@PathVariable("booking_id") Integer booking_id) {
		
		adminBookingService.deleteById(booking_id);
		return "redirect:/admin/AdminBooking";
		
		
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
		
		return "redirect:/admin/AdminUsers";
		
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
	public String updateUser(@PathVariable("userid") Integer userid,
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
		
		return "redirect:/admin/AdminUsers";

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
        		return "redirect:/admin/AdminUsers";
            }
        } 
        return "ErrorPages/AccessDeniedError";

	}
	
	@GetMapping("/payment")
	public String payment() {
		return "paymentModule";
	}
	
	//RoomController

	@GetMapping("/AdminRooms")
	public String adminRooms(Model model) {
		model.addAttribute("rooms", roomService.getAllRooms());
		return "dashboardAdmin/Rooms";
	}
	
	@GetMapping("/addRoom")
	public String addRoom(Model model) {
		Room room = new Room();
		
		model.addAttribute("room", room);
		
		return "dashboardAdmin/RoomCRUD/AddRoom";
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
		
		return "redirect:/admin/AdminRooms";
	}

	@GetMapping("/editRoom/{room_id}")
	public String editRoom(@PathVariable("room_id") Integer room_id, Model model) {
		model.addAttribute("room", roomService.getRoomById(room_id));
		return "dashboardAdmin/RoomCRUD/EditRoom";
	}
	
	@PostMapping("/update/{room_id}")
	public String updateRoom(@PathVariable("room_id") Integer room_id, 
			@ModelAttribute("room") Room room,
			Model model) {
		
		//get room from database by ID
		
		Room existingRoom = roomService.getRoomById(room_id);
		existingRoom.setRoom_id(room_id);
		existingRoom.setHotel_id(room.getHotel_id());
		existingRoom.setType_id(room.getType_id());
		existingRoom.setStatus(room.getStatus());
		
		//save 
		
		roomService.updateRoom(existingRoom);
		return "redirect:/admin/AdminRooms";
		
		
	}
	
	@GetMapping("/delete/{room_id}")
	public String deleteRoom(@PathVariable("room_id") Integer room_id) {
		roomService.deleteRoomById(room_id);
		return "redirect:/admin/AdminRooms";
	}
	
	//RoomTypesController
	
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
	    
	    return "redirect:/admin/AdminRoomTypes";
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
	    return "redirect:/admin/AdminRoomTypes";
	}

	
	@GetMapping("deleteType/{type_id}")
	public String deleteType(@PathVariable("type_id") Integer type_id) {
		roomTypesService.deleteById(type_id);
		
		return "redirect:/admin/AdminRoomTypes";
	}
	
	//VoucherController

	@GetMapping("/AdminDiscount")
	public String adminVoucher(Model model) {
		model.addAttribute("vouchers", voucherService.getAllVouchers());
		return "dashboardAdmin/Discount";
	}

	@GetMapping("/addVoucher")
	public String addVoucher(Model model) {

		Voucher voucher = new Voucher();

		model.addAttribute("voucher", voucher);

		return "dashboardAdmin/VoucherCRUD/AddVoucher";
	}

	@PostMapping("addVoucher/save")
	public String newVoucher(@RequestParam("voucher_code") String voucher_code,
			@RequestParam("description") String description, @RequestParam("amount") Double amount,
			@RequestParam("validation") Date validation, Model model) {

		Voucher voucher = new Voucher();

		voucher.setVoucher_code(voucher_code);
		voucher.setDescription(description);
		voucher.setAmount(amount);
		voucher.setValidation(validation);

		voucherService.addVoucher(voucher);

		return "redirect:/admin/AdminDiscount";
	}
	
	@GetMapping("/editVoucher/{voucher_id}")
	public String editVoucher(@PathVariable("voucher_id") Integer voucher_id, Model model) {
		model.addAttribute("voucher", voucherService.getVoucherById(voucher_id));
		return "dashboardAdmin/VoucherCRUD/EditVoucher";
	}
	
	@PostMapping("/updateVouchers/{voucher_id}")
	public String updateVoucher(@PathVariable("voucher_id") Integer voucher_id,
			@ModelAttribute("voucher") Voucher voucher,
			Model model) {
		
		Voucher existingVoucher = voucherService.getVoucherById(voucher_id);
		existingVoucher.setVoucher_id(voucher_id);
		existingVoucher.setVoucher_code(voucher.getVoucher_code());
		existingVoucher.setDescription(voucher.getDescription());
		existingVoucher.setAmount(voucher.getAmount());
		existingVoucher.setValidation(voucher.getValidation());
		
		voucherService.updateVoucher(existingVoucher);
		
		return "redirect:/admin/AdminDiscount";
		
	}
	
	@GetMapping("deleteVoucher/{voucher_id}")
	public String deleteVoucher(@PathVariable("voucher_id") Integer voucher_id) {
		voucherService.deleteVoucher(voucher_id);
		
		return "redirect:/admin/AdminDiscount";
	}
	
	//AddOnsController
	
	@GetMapping("/AdminAddOns")
	public String adminAddOns(Model model) {
		model.addAttribute("addOns", addOnsService.getAllAddOns());
		return "dashboardAdmin/AddOns";
	}

	@GetMapping("/addAddOns")
	public String addAddOns(Model model) {
		
		AddOns addOns = new AddOns();
		
		model.addAttribute("addOns", addOns);
		
		return "dashboardAdmin/AddOnsCRUD/AddAddOns";
	}
	
	@PostMapping("addAddOns/save")
	public String newAddOns(
			@RequestParam("add_on_name") String add_on_name,
			@RequestParam("description") String description,
			@RequestParam("amount") Integer amount,Model model) {
		
		AddOns addOns = new AddOns();
		
		addOns.setAdd_on_name(add_on_name);
		addOns.setDescription(description);
		addOns.setAmount(amount);
		
		addOnsService.addAddOns(addOns);
		
		return "redirect:/admin/AdminAddOns";
		
	}
	
	@GetMapping("/editAddOns/{add_on_id}")
	public String editAddOns(@PathVariable("add_on_id") Integer add_on_id, Model model) {
		model.addAttribute("addOns", addOnsService.getAddOnsById(add_on_id));
		return "dashboardAdmin/AddOnsCRUD/EditAddOns";
	}
	
	@PostMapping("/updateAddOns/{add_on_id}")
	public String updateAddOns(@PathVariable("add_on_id") Integer add_on_id,
			@ModelAttribute("addOns") AddOns addOns,
			Model model) {
		
		AddOns existingAddOns = addOnsService.getAddOnsById(add_on_id);
		existingAddOns.setAdd_on_id(add_on_id);
		existingAddOns.setAdd_on_name(addOns.getAdd_on_name());
		existingAddOns.setDescription(addOns.getDescription());
		existingAddOns.setAmount(addOns.getAmount());
		
		addOnsService.updateVoucher(existingAddOns);
		
		return "redirect:/admin/AdminAddOns";
		
	}
	
	@GetMapping("deleteAddOns/{add_on_id}")
	public String deleteAddOns(@PathVariable("add_on_id") Integer add_on_id) {
		addOnsService.deleteAddOns(add_on_id);
		
		return "redirect:/admin/AdminAddOns";
	}
	
}
