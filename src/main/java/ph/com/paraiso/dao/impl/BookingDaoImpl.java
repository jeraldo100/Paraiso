package ph.com.paraiso.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;

import ph.com.paraiso.dao.BookingDao;
import ph.com.paraiso.model.AddOns;
import ph.com.paraiso.model.Booked_room;
import ph.com.paraiso.model.Booking;
import ph.com.paraiso.model.Room_joined;
import ph.com.paraiso.model.Room_type;
import ph.com.paraiso.model.Room_typeBooking;
import ph.com.paraiso.model.User;
import ph.com.paraiso.repository.AddOnsRepository;
import ph.com.paraiso.repository.Booked_roomRepository;
import ph.com.paraiso.repository.BookingRepository;
import ph.com.paraiso.repository.Room_TypeRepository;
import ph.com.paraiso.repository.Room_joinedRepository;
import ph.com.paraiso.repository.Room_typeBookingRepository;

@Component
public class BookingDaoImpl implements BookingDao {
	
	@Autowired
	public Room_TypeRepository rtRepo;
	
	@Autowired
	public Room_typeBookingRepository rtbRepo;
	
	@Autowired
	public Room_joinedRepository rjRepo;
	
	@Autowired
	public BookingRepository bookRepo;
	
	@Autowired
	public Booked_roomRepository BrRepo;
	
	@Autowired
	public AddOnsRepository AddOnsRepo;
	
	@Override
	public List<Room_typeBooking> listAllRoom_type(String checkin_date, String checkout_date){
		return rtbRepo.listAllRoom_type(checkin_date, checkout_date);	
	}
	
	@Override
	public Room_joined getRoom_joined_first(Integer room_type, String checkin_date, String checkout_date){
		return rjRepo.getRoom_joined_first(room_type, checkin_date, checkout_date);	
	}
	
	@Override
	public Room_joined getRoom_joined(Integer room_type, String checkin_date, String checkout_date, List<Integer> room_ids){
		return rjRepo.getRoom_joined(room_type, checkin_date, checkout_date, room_ids);	
	}
	
	@Override
	public List<Room_joined> getRoom_joinedList(List<Integer> room_ids){
		return rjRepo.getRoom_joinedList(room_ids);	
	}
	
	@Override
	public Double getTotalPriceRooms(List<Integer> room_ids){
		return bookRepo.getTotalPriceRooms(room_ids);	
	}
	
	@Override
	public Booking addConfirmedBooking(Booking booking) {
		return bookRepo.save(booking);
	}
	
	@Override
	public Double getPriceOfRoomByRoomId(Integer room_id) {
		return bookRepo.getPriceOfRoomByRoomId(room_id);
	}
	
	@Override
	public void addBooked_room(Booked_room booked_room) {
		BrRepo.save(booked_room);
	}
	
	@Override
	public List<AddOns> getAllAddOnsBooking(){
		return AddOnsRepo.findAll();
	}
	
	@Override
	public Double getAddOnAmountByIds(List<Integer> add_on_ids) {
		return bookRepo.getAddOnAmountByIds(add_on_ids);
	}

}
