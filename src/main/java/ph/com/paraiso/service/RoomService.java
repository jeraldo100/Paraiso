package ph.com.paraiso.service;

import java.util.List;

import ph.com.paraiso.model.Room;

public interface RoomService {

	//Showing
	public List<Room> getAllRooms();
	
	//Add
	public Room addRoom(Room room);
	
	//Edit
	public Room updateRoom(Room room);
	public Room getRoomById(Integer room_id);
	
	//Delete
	public void deleteRoomById(Integer room_id);
}
