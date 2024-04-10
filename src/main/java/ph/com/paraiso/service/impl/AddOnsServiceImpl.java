package ph.com.paraiso.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import ph.com.paraiso.model.AddOns;
import ph.com.paraiso.repository.AddOnsRepository;
import ph.com.paraiso.service.AddOnsService;

@Service
public class AddOnsServiceImpl implements AddOnsService {

	private AddOnsRepository addOnsRepository;
	
	
	public AddOnsServiceImpl(AddOnsRepository addOnsRepository) {
		super();
		this.addOnsRepository = addOnsRepository;
	}

	@Override
	public List<AddOns> getAllAddOns() {

		return addOnsRepository.findAll();
	}

	@Override
	public AddOns addAddOns(AddOns addOns) {

		return addOnsRepository.save(addOns);
	}

	@Override
	public AddOns getAddOnsById(Integer add_on_id) {

		return addOnsRepository.findById(add_on_id).get();
	}

	@Override
	public AddOns updateVoucher(AddOns addOns) {

		return addOnsRepository.save(addOns);
	}

	@Override
	public void deleteAddOns(Integer add_on_id) {
		addOnsRepository.deleteById(add_on_id);
		
	}

}
