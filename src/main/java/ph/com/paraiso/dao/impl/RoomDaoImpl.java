package ph.com.paraiso.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import ph.com.paraiso.dao.RoomDao;
import ph.com.paraiso.model.Room;
import ph.com.paraiso.repository.RoomRepository;

@Component
public class RoomDaoImpl implements RoomDao{

	@Autowired
	RoomRepository roomRepository;
	
	@Override
	public Room addRoom(Room room) {
		// TODO Auto-generated method stub
		return roomRepository.save(room);
	}

	@Override
	public Room getRoomById(Integer room_id) {
		return roomRepository.findById(room_id).get();
	}

	@Override
	public Room updateRoom(Room room) {
		return roomRepository.save(room);
	}


}
