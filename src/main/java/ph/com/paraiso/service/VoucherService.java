package ph.com.paraiso.service;

import java.util.List;

import ph.com.paraiso.model.Voucher;

public interface VoucherService {

	List<Voucher> getAllVouchers();
	
	public Voucher addVoucher(Voucher voucher);
	
}
