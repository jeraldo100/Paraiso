package ph.com.paraiso.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import ph.com.paraiso.dao.AddOnsDao;
import ph.com.paraiso.model.AddOns;
import ph.com.paraiso.repository.AddOnsRepository;

public class AddOnsDaoImpl implements AddOnsDao {

	@Autowired
	AddOnsRepository addOnsRepository;
	
	@Override
	public AddOns addAddOns(AddOns addOns) {

		return addOnsRepository.save(addOns);
	}

	@Override
	public AddOns getVoucherById(Integer add_on_id) {

		return addOnsRepository.findById(add_on_id).get();
	}

	@Override
	public AddOns updateVoucher(AddOns addOns) {
		return addOnsRepository.save(addOns);
	}

}
