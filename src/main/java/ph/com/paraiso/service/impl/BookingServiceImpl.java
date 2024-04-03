package ph.com.paraiso.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ph.com.paraiso.dao.BookingDao;
import ph.com.paraiso.model.Room_type;
import ph.com.paraiso.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private BookingDao bookDao;
	
	@Override
	public List<Room_type> listAllRoom_type(String checkin_date, String checkout_date){
		return bookDao.listAllRoom_type(checkin_date, checkout_date);
	}
}
