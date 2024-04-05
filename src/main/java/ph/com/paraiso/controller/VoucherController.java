package ph.com.paraiso.controller;


import java.sql.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ph.com.paraiso.model.Voucher;
import ph.com.paraiso.service.VoucherService;

@Controller
public class VoucherController {

	private VoucherService voucherService;

	public VoucherController(VoucherService voucherService) {
		super();
		this.voucherService = voucherService;
	}
	
	@GetMapping("/AdminDiscount")
	public String adminVoucher(Model model) {
		model.addAttribute("vouchers", voucherService.getAllVouchers());
		return "dashboardAdmin/Discount";
	}
	
	@GetMapping("/addVoucher")
	public String addVoucher(Model model) {
		
		Voucher voucher = new Voucher();
		
		model.addAttribute("voucher", voucher);
		
		return "dashboardAdmin/VoucherCRUD/AddVoucher";
	}
	
		@PostMapping("addVoucher/save")
		public String newVoucher(
				@RequestParam("voucher_code") String voucher_code,
				@RequestParam("description") String description,
				@RequestParam("amount") Double amount,
				@RequestParam("validation") Date validation,
				Model mode) {
			
			Voucher voucher = new Voucher();
			
			voucher.setVoucher_code(voucher_code);
			voucher.setDescription(description);
			voucher.setAmount(amount);
			voucher.setValidation(validation);
			
			voucherService.addVoucher(voucher);
			
			return "redirect:/AdminDiscount";
		}
}
