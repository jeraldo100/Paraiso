package ph.com.paraiso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ph.com.paraiso.model.Loyalty;

public interface LoyaltyRepository extends JpaRepository<Loyalty, Integer> {
	@Query(
			value="SELECT * FROM LOYALTY WHERE USER_ID = ?1",
			nativeQuery=true
	)
	Loyalty getLoyaltyByUserId(Integer user_id);
}
