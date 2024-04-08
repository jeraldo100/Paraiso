package ph.com.paraiso.service;

import java.util.List;

import ph.com.paraiso.model.Voucher;

public interface VoucherService {

	//List
	List<Voucher> getAllVouchers();
	
	//Add
	public Voucher addVoucher(Voucher voucher);
	
	//Update
	public Voucher getVoucherById(Integer voucher_id);
	public Voucher updateVoucher(Voucher voucher);	
	
	//Delete
	
	public void deleteVoucher(Integer voucher_id);
}
