package ph.com.paraiso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ph.com.paraiso.model.Room_type;

public interface Room_TypeRepository extends JpaRepository<Room_type, Integer> {
	@Query(
			value="SELECT A.TYPE_ID, A.NAME, A.PRICE_PER_NIGHT, A.CAPACITY, A.ROOM_IMAGE, A.BATHROOMS, A.BEDS, A.DESCRIPTION FROM ROOM_TYPES A, ROOMS B WHERE A.TYPE_ID = B.TYPE_ID AND B.ROOM_ID IN ( ?1 )",
			nativeQuery=true
	)
	List<Room_type> getAllRoomNamesByRoomIds(List<Integer> room_ids);
}
