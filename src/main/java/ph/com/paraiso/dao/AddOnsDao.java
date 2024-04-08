package ph.com.paraiso.dao;

import ph.com.paraiso.model.AddOns;
import ph.com.paraiso.model.Voucher;

public interface AddOnsDao {

	public AddOns addAddOns(AddOns addOns);
	
	public AddOns getVoucherById(Integer add_on_id);
	public AddOns updateVoucher(AddOns addOns);
	
}
