package ph.com.paraiso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ph.com.paraiso.model.Booking;

public interface DashboardRepository extends JpaRepository<Booking, Integer> {

	
}
