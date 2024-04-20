package ph.com.paraiso.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ph.com.paraiso.model.Booking;

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
	
	@Query("SELECT SUM(b.total_price) FROM Booking b")
    Double sumTotalPrice();
	
	@Query(
		      value = "SELECT rt.name " +
		              "FROM bookings b " +
		              "JOIN users u ON b.user_id = u.user_id " +
		              "JOIN booked_rooms br ON b.booking_id = br.booking_id " +
		              "JOIN rooms r ON br.room_id = r.room_id " +
		              "JOIN room_types rt ON r.type_id = rt.type_id " +
		              "WHERE b.booking_id = :booking_id",
		      nativeQuery = true)
		  List<String> findRoomTypeNamesByBookingId(@Param("booking_id") Integer booking_id);
		
}
