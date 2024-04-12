package ph.com.paraiso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ph.com.paraiso.model.Room;

public interface JasperRepository extends JpaRepository<Room, Integer>{

	@Query(value = "SELECT rt.name, r.room_id, br.checkin_date, br.checkout_date, ((br.checkout_date - br.checkin_date) + 1) * rt.price_per_night AS total " +
            "FROM rooms r " +
            "JOIN room_types rt ON r.type_id = rt.type_id " +
            "JOIN booked_rooms br ON r.room_id = br.room_id " +
            "WHERE r.type_id = :typeId",
      nativeQuery = true)
	List<Object[]> findRoomsHistoryByTypeId(Integer typeId);
	
	
    @Query(value = "SELECT u.username, r.room_id, br.checkin_date, br.checkout_date, br.price AS total_price, b.status " +
            "FROM bookings b " +
            "JOIN users u ON b.user_id = u.user_id " +
            "JOIN booked_rooms br ON b.booking_id = br.booking_id " +
            "JOIN rooms r ON br.room_id = r.room_id " +
            "JOIN room_types rt ON r.type_id = rt.type_id",
    nativeQuery = true)
    List<Object[]> findAllBookingsDetails();
}
