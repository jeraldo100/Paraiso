package ph.com.paraiso.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ph.com.paraiso.dao.AdminBookingDao;
import ph.com.paraiso.model.Booking;
import ph.com.paraiso.repository.AdminBookingRepository;

@Component
public class AdminBookingDaoImpl implements AdminBookingDao {

	@Autowired
	AdminBookingRepository adminBookingRepository;
	
	@Override
	public Booking addBooking(Booking booking) {

		return adminBookingRepository.save(booking);
	}

	@Override
	public Booking updateBooking(Booking booking) {

		return adminBookingRepository.save(booking);
	}

	@Override
	public Booking getBookingById(Integer booking_id) {

		return adminBookingRepository.findById(booking_id).get();
	}

}
