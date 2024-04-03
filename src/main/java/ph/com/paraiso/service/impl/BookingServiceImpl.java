package ph.com.paraiso.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ph.com.paraiso.dao.RoomDao;
import ph.com.paraiso.model.Booking;
import ph.com.paraiso.repository.BookingRepository;
import ph.com.paraiso.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	RoomDao roomDao;
	
	private BookingRepository bookingRepository;

	public BookingServiceImpl(BookingRepository bookingRepository) {
		super();
		this.bookingRepository = bookingRepository;
	}



	@Override
	public List<Booking> getAllBookings() {
		return bookingRepository.findAll();
	}
	

	
	
}
