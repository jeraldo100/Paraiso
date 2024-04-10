package ph.com.paraiso.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ph.com.paraiso.model.Booked_room;
import org.springframework.data.jpa.repository.Query;

public interface Booked_roomRepository extends JpaRepository<Booked_room, Integer>{
	@Query(
			value="SELECT ROOM_ID FROM BOOKED_ROOMS WHERE BOOKING_ID = ?1",
			nativeQuery = true
		)
	List<Integer> getAllRoomIdByBookingId(Integer booking_id);
}
