package ph.com.paraiso.service;

import java.util.List;

import ph.com.paraiso.model.Room_type;

public interface RoomTypesService {

	//Showing
	public List<Room_type> getAllRoomTypes();
	
	//Add
	
	public Room_type addRoomTypes(Room_type room_types);
}
