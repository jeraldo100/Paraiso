package ph.com.paraiso.service;

import java.util.List;

import ph.com.paraiso.model.Booking;
import ph.com.paraiso.model.Room;
import ph.com.paraiso.model.Room_type;
import ph.com.paraiso.model.User;
import ph.com.paraiso.model.Voucher;

public interface DashboardService {

	List<Booking> getAllBookings();
	List<Room> getAllRooms();
	List<Room_type> getAllRoomTypes();
	List<User> getAllUsers();
	List<Voucher> getAllVouchers();
	
}
