package ph.com.paraiso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ph.com.paraiso.model.Room_joined;

public interface Room_joinedRepository extends JpaRepository<Room_joined, Integer> {
	
	@Query(
		value="SELECT A.ROOM_ID, B.NAME, B.PRICE_PER_NIGHT\r\n"
				+ "FROM ROOMS A, ROOM_TYPES B\r\n"
				+ "WHERE A.TYPE_ID = B.TYPE_ID AND A.TYPE_ID = ?1 AND A.ROOM_ID NOT IN\r\n"
				+ "(\r\n"
				+ "    SELECT C.ROOM_ID FROM BOOKED_ROOMS C\r\n"
				+ "    WHERE C.CHECKOUT_DATE < TO_DATE('03/04/2024', 'DD/MM/YYYY')\r\n"
				+ "    or C.CHECKOUT_DATE > TO_DATE('09/04/2024', 'DD/MM/YYYY')\r\n"
				+ ")\r\n"
				+ "ORDER BY A.ROOM_ID\r\n"
				+ "FETCH FIRST 1 ROWS ONLY",
		nativeQuery=true
	)
	Room_joined getRoom_joined(Integer room_type);
}
