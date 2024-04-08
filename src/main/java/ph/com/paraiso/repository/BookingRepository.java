package ph.com.paraiso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ph.com.paraiso.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer>{
	
	@Query("SELECT sum(b.total_price) from Booking b")
	Double totalPrice();

	@Query("SELECT count(b.checkin_date) from Booking b")
	Integer checkInTotal();
	
	@Query("SELECT count(b.checkout_date) from Booking b")
	Integer checkOutTotal();
}
