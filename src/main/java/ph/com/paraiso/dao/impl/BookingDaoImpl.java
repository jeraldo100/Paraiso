package ph.com.paraiso.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ph.com.paraiso.dao.BookingDao;
import ph.com.paraiso.model.Room_type;
import ph.com.paraiso.repository.Room_TypeRepository;

@Component
public class BookingDaoImpl implements BookingDao {
	
	@Autowired
	public Room_TypeRepository rtRepo;
	
	@Override
	public List<Room_type> listAllRoom_type(String checkin_date, String checkout_date){
		return rtRepo.listAllRoom_type(checkin_date, checkout_date);	
	}
}
