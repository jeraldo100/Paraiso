package ph.com.paraiso.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import ph.com.paraiso.model.Voucher;
import ph.com.paraiso.repository.VoucherRepository;
import ph.com.paraiso.service.VoucherService;

@Service
public class VoucherServiceImpl implements VoucherService {

	private VoucherRepository voucherRepository;

	
	
	public VoucherServiceImpl(VoucherRepository voucherRepository) {
		super();
		this.voucherRepository = voucherRepository;
	}



	@Override
	public List<Voucher> getAllVouchers() {

		return voucherRepository.findAll();
	}



	@Override
	public Voucher addVoucher(Voucher voucher) {
		return voucherRepository.save(voucher);
	}



	@Override
	public Voucher getVoucherById(Integer voucher_id) {

		return voucherRepository.findById(voucher_id).get();
	}



	@Override
	public Voucher updateVoucher(Voucher voucher) {

		return voucherRepository.save(voucher);
	}



	@Override
	public void deleteVoucher(Integer voucher_id) {

		voucherRepository.deleteById(voucher_id);
		
	}




	
	
}
