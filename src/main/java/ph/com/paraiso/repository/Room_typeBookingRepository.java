package ph.com.paraiso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ph.com.paraiso.model.Room_typeBooking;

public interface Room_typeBookingRepository extends JpaRepository<Room_typeBooking, Integer> {
	@Query(
			value =
			"SELECT A.TYPE_ID, A.NAME, A.DESCRIPTION, A.PRICE_PER_NIGHT, A.CAPACITY, A.BEDS, A.BATHROOMS, A.ROOM_IMAGE, \r\n"
			+ "(\r\n"
			+ "    (\r\n"
			+ "        SELECT COUNT(B.ROOM_ID) \r\n"
			+ "        FROM ROOMS B\r\n"
			+ "        WHERE A.TYPE_ID = B.TYPE_ID\r\n"
			+ "    ) - \r\n"
			+ "    (\r\n"
			+ "        SELECT COUNT(B.ROOM_ID) \r\n"
			+ "        FROM ROOMS B, BOOKED_ROOMS C\r\n"
			+ "        WHERE A.TYPE_ID = B.TYPE_ID AND B.ROOM_ID = C.ROOM_ID AND (\r\n"
			+ "            C.CHECKIN_DATE <= TO_DATE( ?2, 'DD/MM/YYYY') AND \r\n"
			+ "            C.CHECKOUT_DATE >= TO_DATE( ?1, 'DD/MM/YYYY') )\r\n"
			+ "    )\r\n"
			+ "    \r\n"
			+ ") AVAILABLE\r\n"
			+ "FROM ROOM_TYPES A",
			nativeQuery = true
	)
	List<Room_typeBooking> listAllRoom_type(String checkin_date, String checkout_date);
}
