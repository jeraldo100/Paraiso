package ph.com.paraiso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ph.com.paraiso.service.VoucherService;

@Controller
public class AdminVoucherController {

	private VoucherService voucherService;

	public AdminVoucherController(VoucherService voucherService) {
		super();
		this.voucherService = voucherService;
	}
	
	@GetMapping("/AdminDiscount")
	public String adminVoucher(Model model) {
		model.addAttribute("vouchers", voucherService.getAllVouchers());
		return "dashboardAdmin/Discount";
	}
}
