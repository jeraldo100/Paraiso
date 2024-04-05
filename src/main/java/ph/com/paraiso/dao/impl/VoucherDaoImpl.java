package ph.com.paraiso.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import ph.com.paraiso.dao.VoucherDao;
import ph.com.paraiso.model.Voucher;
import ph.com.paraiso.repository.VoucherRepository;

public class VoucherDaoImpl implements VoucherDao {

	@Autowired
	VoucherRepository voucherRepository;

	@Override
	public Voucher addVoucher(Voucher voucher) {

		return voucherRepository.save(voucher);
	}
	


	
	
}
