package ph.com.paraiso.dao;

import ph.com.paraiso.model.Voucher;

public interface VoucherDao {

	public Voucher addVoucher(Voucher voucher);
	
	public Voucher getVoucherById(Integer voucher_id);
	public Voucher updateVoucher(Voucher voucher);
	
}
