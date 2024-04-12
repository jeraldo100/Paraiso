package ph.com.paraiso.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ph.com.paraiso.model.Booked_room;
import ph.com.paraiso.model.Booking;
import ph.com.paraiso.model.Loyalty;
import ph.com.paraiso.model.Payment;
import ph.com.paraiso.model.Room_type;
import ph.com.paraiso.model.Voucher;
import ph.com.paraiso.repository.Booked_roomRepository;
import ph.com.paraiso.repository.BookingRepository;
import ph.com.paraiso.repository.LoyaltyRepository;
import ph.com.paraiso.repository.PaymentRepository;
import ph.com.paraiso.repository.Room_TypeRepository;
import ph.com.paraiso.repository.VoucherRepository;
import ph.com.paraiso.service.UserService;
import ph.com.paraiso.session.SessionManager;


@Controller
public class UserDashboardController {
	
	@Autowired
	BookingRepository bookRepo;
	
	@Autowired
	Booked_roomRepository brRepo;
	
	@Autowired
	UserService userSvc;
	
	@Autowired
	Room_TypeRepository rtRepo;
	
	@Autowired
	VoucherRepository vRepo;
	
	@Autowired
	PaymentRepository payRepo;
	
	@Autowired
	LoyaltyRepository loyalRepo;
	
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
            model.addAttribute("loggedIn", true);
        } else {
            System.out.println("No user associated with the current session.");
            model.addAttribute("loggedIn", false);
        }
    }
	
	@GetMapping("/userDashboard")
	public String userDashboard(HttpServletRequest request, Model model){
		setCommonAttributes(request, model);
		
		String userEmail = SessionManager.getEmailFromSession(request);
		Integer user_id = userSvc.getUserIdByEmail(userEmail);
		
		List<Map<String, Object>> bookingsAndRooms = new ArrayList();
		List<Booking> bookings = bookRepo.getBookingsByUserId(user_id);
		
		Loyalty loyalty = loyalRepo.getLoyaltyByUserId(user_id);
		Double loyalty_points;
		if (loyalty == null) {
			loyalty_points = (double) 0;
		}else {
			loyalty_points = loyalty.getAvailable_points();	
		}
		
		for(Booking booking: bookings) {
			Map bAndRs = new HashMap();
			bAndRs.put("booking", booking);
			Integer booking_id = booking.getBooking_id();
			List<Integer> room_ids = brRepo.getAllRoomIdByBookingId(booking_id);
			List<Room_type> room_types = rtRepo.getAllRoomNamesByRoomIds(room_ids);
			for(Room_type e: room_types) { 
				e.setRoomImageEncoded(Base64.getEncoder().encodeToString( e.getRoomImage() ) ); 
			}
			bAndRs.put("room_names", room_types);
			bookingsAndRooms.add(bAndRs);
		}
		
		model.addAttribute("loyaltyPoints", loyalty_points);
		model.addAttribute("bookingsAndRooms", bookingsAndRooms);
		return "dashboardUser/userDashboard";
	}
	
	public Double doubleToPerc(Double amount) {
		String amountStr;
		if(amount < 10) {
			amountStr = "0.0"+(amount+"").replace(".", "");
		}else {
			amountStr = "0."+(amount+"").replace(".", "");
		}
		return Double.parseDouble(amountStr);
	}
	
	@ResponseBody
	@PostMapping(value="userDashboard/checkVoucher/{voucherInput}/{oldPrice}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Double checkVoucher(@PathVariable("voucherInput") String voucherInput, @PathVariable("oldPrice") Double oldPrice) {
		Voucher voucher = vRepo.getVoucherByCode(voucherInput);
		if(voucher == null) {
			return oldPrice;
		}
		Double amount = voucher.getAmount();
		
		Double amountToPerc = doubleToPerc(amount);
		
		Double discount = oldPrice - (oldPrice * amountToPerc);
		Double newPrice = discount;
		return newPrice;
	}
	
	@ResponseBody
	@PostMapping(value="userDashboard/confirmPayment/{booking_id}/{paymentMethod}/{voucherInput}/{loyalty_payment}")
	public String confirmPayment(HttpServletRequest request, @PathVariable("booking_id") Integer booking_id, @PathVariable("paymentMethod") String paymentMethod, @PathVariable("voucherInput") String voucherInput, @PathVariable("loyalty_payment") Double loyalty_payment) {
		Booking booking = bookRepo.findById(booking_id).get();
		
		String userEmail = SessionManager.getEmailFromSession(request);
		Integer user_id = userSvc.getUserIdByEmail(userEmail);
		
		Loyalty loyalty = loyalRepo.getLoyaltyByUserId(user_id);
		
		Double loyalty_points;
		if (loyalty == null) {
			loyalty_points = (double) 0;
			loyalty = loyalRepo.save(new Loyalty(user_id, loyalty_points, loyalty_points, loyalty_points));
		}else {
			loyalty_points = loyalty.getAvailable_points();	
		}
		
		Double newPrice;
		Double oldPrice = booking.getTotal_price();
		Voucher voucher = new Voucher();
		Payment payment = new Payment();
		
		
		if(!(voucherInput.equals("none") ) ) {
			voucher = vRepo.getVoucherByCode(voucherInput);
			Double amountToPerc = doubleToPerc(voucher.getAmount());
			newPrice = oldPrice - (oldPrice * amountToPerc);
			
		}else {
			newPrice = oldPrice;
		}
		
		if(loyalty_payment != 0) {
			if(loyalty_payment < loyalty_points) {
				newPrice = newPrice - loyalty_payment;
				loyalty.setRedeemed_points(loyalty_payment + loyalty.getRedeemed_points());
				loyalty.setAvailable_points(loyalty.getAvailable_points() - loyalty_payment);
			}
		}
		Double loyaltyAddedPoints = newPrice * 0.04;
		loyalty.setAvailable_points(loyaltyAddedPoints + loyalty.getAvailable_points());
		loyalty.setTotal_points(loyaltyAddedPoints + loyalty.getTotal_points());
		
		payment.setBooking_id(booking_id);
		payment.setAmount(newPrice);
		payment.setPayment_date(new Date());
		payment.setPayment_method(paymentMethod);
		
		booking.setStatus("Paid");
		booking.setTotal_price(newPrice);
		
		payRepo.save(payment);
		bookRepo.save(booking);
		loyalRepo.save(loyalty);
		
		return "Success";
	}
	
	@ResponseBody
	@PostMapping("userDashboard/cancel/{booking_id}") 
	public String cancelBooking(@PathVariable Integer booking_id){ 

		Booking booking = bookRepo.findById(booking_id).get();
		
		booking.setStatus("Cancelled");
		bookRepo.save(booking);
		
		return "Success";
	}
	 

}
	