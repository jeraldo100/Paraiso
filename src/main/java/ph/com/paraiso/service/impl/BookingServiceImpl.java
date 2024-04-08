package ph.com.paraiso.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.com.paraiso.dao.RoomDao;
import ph.com.paraiso.model.Booking;
import ph.com.paraiso.repository.BookingRepository;
import ph.com.paraiso.dao.BookingDao;
import ph.com.paraiso.model.Room_type;
import ph.com.paraiso.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {


	private BookingRepository bookingRepository;

	public BookingServiceImpl(BookingRepository bookingRepository) {
		super();
		this.bookingRepository = bookingRepository;
	}



	@Override
	public List<Booking> getAllBookings() {
		return bookingRepository.findAll();
	}



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



	@Override
	public void deleteById(Integer booking_id) {

		bookingRepository.deleteById(booking_id);
		
	}


	@Autowired
	private BookingDao bookDao;
	
	@Override
	public List<Room_type> listAllRoom_type(String checkin_date, String checkout_date){
		return bookDao.listAllRoom_type(checkin_date, checkout_date);
	}
}
