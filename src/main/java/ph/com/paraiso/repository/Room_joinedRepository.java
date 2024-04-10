package ph.com.paraiso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ph.com.paraiso.model.Room_joined;

public interface Room_joinedRepository extends JpaRepository<Room_joined, Integer> {
	
	@Query(
		value="SELECT A.ROOM_ID, B.NAME, B.PRICE_PER_NIGHT, B.CAPACITY\r\n"
				+ "FROM ROOMS A, ROOM_TYPES B\r\n"
				+ "WHERE A.TYPE_ID = B.TYPE_ID AND A.TYPE_ID = ?1 AND A.ROOM_ID NOT IN\r\n"
				+ "(\r\n"
				+ "    SELECT C.ROOM_ID FROM BOOKED_ROOMS C\r\n"
				+ "    WHERE C.CHECKIN_DATE <= TO_DATE( ?3, 'DD/MM/YYYY')\r\n"
				+ "    AND C.CHECKOUT_DATE >= TO_DATE( ?2, 'DD/MM/YYYY')\r\n"
				+ ")\r\n"
				+ "ORDER BY A.ROOM_ID\r\n"
				+ "FETCH FIRST 1 ROWS ONLY",
		nativeQuery=true
	)
	Room_joined getRoom_joined_first(Integer room_type, String checkin_date, String checkout_date);
	
	@Query(
		value="SELECT A.ROOM_ID, B.NAME, B.PRICE_PER_NIGHT, B.CAPACITY\r\n"
				+ "FROM ROOMS A, ROOM_TYPES B\r\n"
				+ "WHERE A.TYPE_ID = B.TYPE_ID AND A.TYPE_ID = ?1 AND A.ROOM_ID NOT IN\r\n"
				+ "(\r\n"
				+ "    SELECT C.ROOM_ID FROM BOOKED_ROOMS C\r\n"
				+ "    WHERE C.CHECKIN_DATE <= TO_DATE( ?3, 'DD/MM/YYYY')\r\n"
				+ "    AND C.CHECKOUT_DATE >= TO_DATE( ?2, 'DD/MM/YYYY')\r\n"
				+ ")\r\n"
				+ "AND A.ROOM_ID NOT IN( ?4 )"
				+ "ORDER BY A.ROOM_ID\r\n"
				+ "FETCH FIRST 1 ROWS ONLY",
		nativeQuery=true
	)
	Room_joined getRoom_joined(Integer room_type, String checkin_date, String checkout_date, List<Integer> room_ids);
	
	@Query(
			value="SELECT A.ROOM_ID, B.NAME, B.PRICE_PER_NIGHT, B.CAPACITY\r\n"
					+ "FROM ROOMS A, ROOM_TYPES B\r\n"
					+ "WHERE A.TYPE_ID = B.TYPE_ID AND A.ROOM_ID IN ( ?1 )",
			nativeQuery=true
		)
	List<Room_joined> getRoom_joinedList(List<Integer> room_ids);
}
