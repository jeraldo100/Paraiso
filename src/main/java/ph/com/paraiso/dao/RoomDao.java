package ph.com.paraiso.dao;

import ph.com.paraiso.model.Room;

public interface RoomDao {

	public Room addRoom(Room room);
	
	public Room getRoomById(Integer room_id);
	public Room updateRoom(Room room);
	
}
