package ph.com.paraiso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ph.com.paraiso.model.AddOns;
import ph.com.paraiso.model.Booking;
import ph.com.paraiso.model.Room;
import ph.com.paraiso.model.Room_type;
import ph.com.paraiso.model.User;
import ph.com.paraiso.model.Voucher;
import ph.com.paraiso.repository.AddOnsRepository;
import ph.com.paraiso.repository.AdminBookingRepository;
import ph.com.paraiso.repository.AdminUserRepository;
import ph.com.paraiso.repository.BookingRepository;
import ph.com.paraiso.repository.RoomRepository;
import ph.com.paraiso.repository.RoomTypesRepository;
import ph.com.paraiso.repository.UserRepository;
import ph.com.paraiso.repository.VoucherRepository;

@Controller
@RequestMapping("/admin")
public class DashboardController {
	

}
