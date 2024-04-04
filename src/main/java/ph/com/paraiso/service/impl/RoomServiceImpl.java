	package ph.com.paraiso.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import ph.com.paraiso.model.Room;
import ph.com.paraiso.repository.RoomRepository;
import ph.com.paraiso.service.RoomService;

@Service 
public class RoomServiceImpl implements RoomService {

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
		return null;
	}



	@Override
	public Room updateRoom(Room room) {
		return roomRepository.save(room);
	}



	@Override
	public Room getRoomById(Integer room_id) {
		return roomRepository.findById(room_id).get();
	}



	@Override
	public void deleteRoomById(Integer room_id) {

		roomRepository.deleteById(room_id);
		
	};
	
}
