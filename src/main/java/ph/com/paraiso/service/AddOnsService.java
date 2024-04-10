package ph.com.paraiso.service;

import java.util.List;

import ph.com.paraiso.model.AddOns;

public interface AddOnsService {

	List<AddOns> getAllAddOns();
	
	public AddOns addAddOns(AddOns addOns);
	
	public AddOns getAddOnsById(Integer add_on_id);
	public AddOns updateVoucher(AddOns addOns);
	
	public void deleteAddOns(Integer add_on_id);
	
}
