package ph.com.paraiso.dao;

import ph.com.paraiso.model.Booking;

public interface AdminBookingDao {

	public Booking addBooking(Booking booking);

	public Booking updateBooking(Booking booking);

	public Booking getBookingById(Integer booking_id);

}
