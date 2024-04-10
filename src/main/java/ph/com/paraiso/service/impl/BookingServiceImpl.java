package ph.com.paraiso.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ph.com.paraiso.dao.BookingDao;
import ph.com.paraiso.model.Booked_room;
import ph.com.paraiso.model.Booking;
import ph.com.paraiso.model.Room_joined;
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
	
	@Override
	public Room_joined getRoom_joined_first(Integer room_type, String checkin_date, String checkout_date){
		return bookDao.getRoom_joined_first(room_type, checkin_date, checkout_date);
	}
	
	@Override
	public Room_joined getRoom_joined(Integer room_type, String checkin_date, String checkout_date, List<Integer> room_ids){
		return bookDao.getRoom_joined(room_type, checkin_date, checkout_date, room_ids);	
	}
	
	@Override
	public List<Room_joined> getRoom_joinedList(List<Integer> room_ids){
		return bookDao.getRoom_joinedList(room_ids);	
	}
	
	@Override
	public Double getTotalPriceRooms(List<Integer> room_ids){
		return bookDao.getTotalPriceRooms(room_ids);	
	}
	
	@Override
	public Booking addConfirmedBooking(Booking booking) {
		return bookDao.addConfirmedBooking(booking);
	}
	
	@Override
	public Double getPriceOfRoomByRoomId(Integer room_id) {
		return bookDao.getPriceOfRoomByRoomId(room_id);
	}
	
	@Override
	public void addBooked_room(Booked_room booked_room){
		bookDao.addBooked_room(booked_room);
	}
	
}
