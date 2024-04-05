package ph.com.paraiso.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ph.com.paraiso.model.Room_type;
import ph.com.paraiso.repository.RoomTypesRepository;
import ph.com.paraiso.service.RoomTypesService;

@Service
public class RoomTypesServiceImpl implements RoomTypesService {

	@Autowired
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
		return roomTypesRepository.save(room_types);
	}

	@Override
	public Room_type updateRoomTypes(Room_type room_types) {

		return roomTypesRepository.save(room_types);
	}

	@Override
	public Room_type getRoomTypesById(Integer type_id) {

		return roomTypesRepository.findById(type_id).get();
	}

	@Override
	public void deleteById(Integer type_id) {

		roomTypesRepository.deleteById(type_id);
		
	}






	
}
