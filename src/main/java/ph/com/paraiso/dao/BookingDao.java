package ph.com.paraiso.dao;

import java.util.List;

import ph.com.paraiso.model.Room_type;

public interface BookingDao {
	List<Room_type> listAllRoom_type(String checkin_date, String checkout_date);
}
