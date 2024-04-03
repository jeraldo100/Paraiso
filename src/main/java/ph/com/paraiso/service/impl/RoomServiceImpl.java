package ph.com.paraiso.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ph.com.paraiso.model.Room;
import ph.com.paraiso.repository.RoomRepository;
import ph.com.paraiso.service.RoomService;

@Service 
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	private RoomRepository roomRepository;
	
	public RoomServiceImpl(RoomRepository roomRepository) {
		super();
		this.roomRepository = roomRepository;
	}

	@Override
	public List<Room> getAllRooms() {
		return roomRepository.findAll();
	};
	
}
