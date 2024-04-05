package ph.com.paraiso.service;

import java.util.List;

import ph.com.paraiso.model.Booking;

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
	
}
