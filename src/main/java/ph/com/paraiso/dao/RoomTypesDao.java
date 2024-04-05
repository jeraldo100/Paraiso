package ph.com.paraiso.dao;

import ph.com.paraiso.model.Room_type;

public interface RoomTypesDao {

	public Room_type addRoomTypes(Room_type room_types);
	
	public Room_type getRoomTypesById(Integer type_id);
	public Room_type updateRoomTypes(Room_type room_types);
	
}
