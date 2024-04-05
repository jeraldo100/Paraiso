package ph.com.paraiso.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ph.com.paraiso.dao.BookingDao;
import ph.com.paraiso.model.Booking;
import ph.com.paraiso.repository.BookingRepository;

@Component
public class BookingDaoImpl implements BookingDao {

	@Autowired
	BookingRepository bookingRepository;
	
	@Override
	public Booking addBooking(Booking booking) {

		return bookingRepository.save(booking);
	}

	@Override
	public Booking updateBooking(Booking booking) {

		return bookingRepository.save(booking);
	}

	@Override
	public Booking getBookingById(Integer booking_id) {
		return bookingRepository.findById(booking_id).get();
	}



}
