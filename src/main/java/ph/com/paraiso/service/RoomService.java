package ph.com.paraiso.service;

import java.util.List;

import ph.com.paraiso.model.Room;

public interface RoomService {

	//Showing
	public List<Room> getAllRooms();
	
	//Add
	public void save(Room room);
}
