package ph.com.paraiso.service;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import ph.com.paraiso.model.AddOns;
import ph.com.paraiso.model.Booked_room;
import ph.com.paraiso.model.Booking;
import ph.com.paraiso.model.Room_joined;
import ph.com.paraiso.model.Room_typeBooking;

public interface BookingService {
	public List<Room_typeBooking> listAllRoom_type(String checkin_date, String checkout_date);
	
	public Room_joined getRoom_joined_first(Integer room_type, String checkin_date, String checkout_date);
	
	public Room_joined getRoom_joined(Integer room_type, String checkin_date, String checkout_date, List<Integer> room_ids);
	
	public List<Room_joined> getRoom_joinedList(List<Integer> room_ids);
	
	public Double getTotalPriceRooms(List<Integer> room_ids);
	
	public Booking addConfirmedBooking(Booking booking);
	
	public Double getPriceOfRoomByRoomId(Integer room_id);
	
	public void addBooked_room(Booked_room booked_room);
	
	public List<AddOns> getAllAddOnsBooking();
	
	public Double getAddOnAmountByIds(List<Integer> add_on_ids);
	
	public void exportJasperReportBooking(HttpServletResponse response) throws JRException, IOException;
}
