package ph.com.paraiso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ph.com.paraiso.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer>{
	
	
}
