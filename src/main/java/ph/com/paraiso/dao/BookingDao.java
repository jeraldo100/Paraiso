package ph.com.paraiso.dao;

import java.util.List;

import ph.com.paraiso.model.AddOns;
import ph.com.paraiso.model.Booked_room;
import ph.com.paraiso.model.Booking;
import ph.com.paraiso.model.Room_joined;
import ph.com.paraiso.model.Room_typeBooking;
import ph.com.paraiso.model.User;

public interface BookingDao {
	public List<Room_typeBooking> listAllRoom_type(String checkin_date, String checkout_date);
	
	public Room_joined getRoom_joined_first(Integer room_type, String checkin_date, String checkout_date);
	
	public Room_joined getRoom_joined(Integer room_type, String checkin_date, String checkout_date, List<Integer> room_ids);
	
	public List<Room_joined> getRoom_joinedList(List<Integer> room_ids);
	
	public Double getTotalPriceRooms(List<Integer> room_ids);
	
	public Booking addConfirmedBooking(Booking booking);
	
	public Double getPriceOfRoomByRoomId(Integer room_id);
	
	public void addBooked_room(Booked_room booked_rooms);
	
	public List<AddOns> getAllAddOnsBooking();
	
	public Double getAddOnAmountByIds(List<Integer> add_on_ids);

}
