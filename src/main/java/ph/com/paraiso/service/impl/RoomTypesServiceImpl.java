package ph.com.paraiso.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import ph.com.paraiso.model.Room_type;
import ph.com.paraiso.repository.RoomTypesRepository;
import ph.com.paraiso.service.RoomTypesService;

@Service
public class RoomTypesServiceImpl implements RoomTypesService {

	private RoomTypesRepository roomTypesRepository;
	
	public RoomTypesServiceImpl(RoomTypesRepository roomTypesRepository) {
		super();
		this.roomTypesRepository = roomTypesRepository;
	}

	@Override
	public List<Room_type> getAllRoomTypes() {

		return roomTypesRepository.findAll();
	}

	@Override
	public Room_type addRoomTypes(Room_type room_types) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
