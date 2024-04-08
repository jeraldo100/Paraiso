package ph.com.paraiso.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import ph.com.paraiso.model.Booking;
import ph.com.paraiso.repository.AdminBookingRepository;
import ph.com.paraiso.repository.BookingRepository;
import ph.com.paraiso.service.AdminBookingService;

@Service
public class AdminBookingServiceImpl implements AdminBookingService {

	private AdminBookingRepository adminBookingRepository;
	
	public AdminBookingServiceImpl(AdminBookingRepository adminBookingRepository) {
		super();
		this.adminBookingRepository = adminBookingRepository;
	}
	
	@Override
	public List<Booking> getAllBookings() {

		return adminBookingRepository.findAll();
	}

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

	@Override
	public void deleteById(Integer booking_id) {

		adminBookingRepository.deleteById(booking_id);
		
	}

}
