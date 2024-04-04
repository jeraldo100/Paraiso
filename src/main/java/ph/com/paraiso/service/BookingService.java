package ph.com.paraiso.service;

import java.util.List;

import ph.com.paraiso.model.Room_joined;
import ph.com.paraiso.model.Room_type;

public interface BookingService {
	public List<Room_type> listAllRoom_type(String checkin_date, String checkout_date);
	
	public Room_joined getRoom_joined(Integer room_type);
}
