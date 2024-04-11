package ph.com.paraiso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ph.com.paraiso.model.Voucher;

public interface VoucherRepository extends JpaRepository<Voucher, Integer>{

	@Query(
			value="SELECT * FROM VOUCHERS WHERE VOUCHER_CODE = ?1",
			nativeQuery = true
		)
	Voucher getVoucherByCode(String voucher_code);
	
}
