package ph.com.paraiso.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ph.com.paraiso.dao.RoomDao;
import ph.com.paraiso.model.Room;
import ph.com.paraiso.repository.RoomRepository;
import ph.com.paraiso.service.RoomService;

@Service 
public class RoomServiceImpl implements RoomService {

	@Autowired
	RoomDao roomDao;
	
	@Autowired
	private RoomRepository roomRepository;
	
	
	
	public RoomServiceImpl(RoomRepository roomRepository) {
		super();
		this.roomRepository = roomRepository;
	}



	@Override
	public List<Room> getAllRooms() {
		return roomRepository.findAll();
	}



	@Override
	public Room addRoom(Room room) {
		// TODO Auto-generated method stub
		return roomDao.addRoom(room);
	}



	@Override
	public Room editRoom(Room room) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Room getRoomById(Integer room_id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void deleteRoomById(Integer room_id) {

		roomRepository.deleteById(room_id);
		
	}







	
	
}
