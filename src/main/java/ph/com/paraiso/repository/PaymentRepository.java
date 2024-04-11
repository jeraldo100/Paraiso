package ph.com.paraiso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ph.com.paraiso.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{
	
}
