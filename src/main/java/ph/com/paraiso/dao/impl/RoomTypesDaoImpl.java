package ph.com.paraiso.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ph.com.paraiso.dao.RoomTypesDao;
import ph.com.paraiso.model.Room_type;
import ph.com.paraiso.repository.RoomTypesRepository;

@Component
public class RoomTypesDaoImpl implements RoomTypesDao {

	@Autowired
	RoomTypesRepository roomTypeRepository;
	
	@Override
	public Room_type addRoomTypes(Room_type room_type) {
		return roomTypeRepository.save(room_type);
		
	}
	
	
	
}
