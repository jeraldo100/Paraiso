package ph.com.paraiso.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ph.com.paraiso.dao.BookingDao;
import ph.com.paraiso.model.Booking;
import ph.com.paraiso.repository.BookingRepository;

import ph.com.paraiso.model.Room_type;
import ph.com.paraiso.repository.Room_TypeRepository;

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

	
	@Autowired
	public Room_TypeRepository rtRepo;
	
	@Override
	public List<Room_type> listAllRoom_type(String checkin_date, String checkout_date){
		return rtRepo.listAllRoom_type(checkin_date, checkout_date);	
	}
}
