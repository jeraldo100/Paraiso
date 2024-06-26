package ph.com.paraiso.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ph.com.paraiso.model.Booking;
import ph.com.paraiso.model.User;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
	@Query(
			value="SELECT SUM(B.PRICE_PER_NIGHT)\r\n"
					+ "FROM ROOMS A, ROOM_TYPES B\r\n"
					+ "WHERE A.TYPE_ID = B.TYPE_ID AND A.ROOM_ID IN (?1)",
			nativeQuery=true
	)
	Double getTotalPriceRooms(List <Integer> room_ids);
	
	@Query(
			value="SELECT B.PRICE_PER_NIGHT\r\n"
					+ "FROM ROOMS A, ROOM_TYPES B\r\n"
					+ "WHERE A.TYPE_ID = B.TYPE_ID AND A.ROOM_ID = ?1",
			nativeQuery=true
	)
	Double getPriceOfRoomByRoomId(Integer room_id);
	
	@Query(
			value="SELECT SUM(AMOUNT)\r\n"
					+ "FROM ADD_ONS\r\n"
					+ "WHERE ADD_ON_ID IN( ?1 )",
			nativeQuery=true
	)
	Double getAddOnAmountByIds(List<Integer> add_on_ids);
	
	@Query(
			value="SELECT * FROM BOOKINGS WHERE USER_ID = ?1",
			nativeQuery=true
	)
	List<Booking> getBookingsByUserId(Integer user_id);
	
	

}
