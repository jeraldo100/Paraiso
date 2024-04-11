package ph.com.paraiso.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ph.com.paraiso.model.Booking;

public interface AdminBookingRepository extends JpaRepository<Booking, Integer> {

	@Query("SELECT sum(b.total_price) from Booking b")
	Double totalPrice();

	@Query("SELECT count(b.booking_id) from Booking b")
	Integer totalBooking();
	

	
}
