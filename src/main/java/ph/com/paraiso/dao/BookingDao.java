package ph.com.paraiso.dao;

import java.util.List;

import ph.com.paraiso.model.Room_joined;
import ph.com.paraiso.model.Room_type;

public interface BookingDao {
	List<Room_type> listAllRoom_type(String checkin_date, String checkout_date);
	
	Room_joined getRoom_joined(Integer room_type);
}
