package ph.com.paraiso.service;

import java.util.List;
import ph.com.paraiso.model.Room_type;
import ph.com.paraiso.model.Booking;
import ph.com.paraiso.model.Room_type;

public interface BookingService {

	//List
	List<Booking> getAllBookings();
	
	//Add
	public Booking addBooking(Booking booking);
	
	//Update
	public Booking updateBooking(Booking booking);
	public Booking getBookingById(Integer booking_id);
	
	//Delete
	
	public void deleteById(Integer booking_id);

	public List<Room_type> listAllRoom_type(String checkin_date, String checkout_date);
}
