package ph.com.paraiso.controller;

import java.sql.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ph.com.paraiso.model.Voucher;
import ph.com.paraiso.service.VoucherService;

@Controller
@RequestMapping("/admin")
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
	public String newVoucher(@RequestParam("voucher_code") String voucher_code,
			@RequestParam("description") String description, @RequestParam("amount") Double amount,
			@RequestParam("validation") Date validation, Model model) {

		Voucher voucher = new Voucher();

		voucher.setVoucher_code(voucher_code);
		voucher.setDescription(description);
		voucher.setAmount(amount);
		voucher.setValidation(validation);

		voucherService.addVoucher(voucher);

		return "redirect:/AdminDiscount";
	}
	
	@GetMapping("/editVoucher/{voucher_id}")
	public String editVoucher(@PathVariable("voucher_id") Integer voucher_id, Model model) {
		model.addAttribute("voucher", voucherService.getVoucherById(voucher_id));
		return "dashboardAdmin/VoucherCRUD/EditVoucher";
	}
	
	@PostMapping("/updateVouchers/{voucher_id}")
	public String updateVoucher(@PathVariable("voucher_id") Integer voucher_id,
			@ModelAttribute("voucher") Voucher voucher,
			Model model) {
		
		Voucher existingVoucher = voucherService.getVoucherById(voucher_id);
		existingVoucher.setVoucher_id(voucher_id);
		existingVoucher.setVoucher_code(voucher.getVoucher_code());
		existingVoucher.setDescription(voucher.getDescription());
		existingVoucher.setAmount(voucher.getAmount());
		existingVoucher.setValidation(voucher.getValidation());
		
		voucherService.updateVoucher(existingVoucher);
		
		return "redirect:/AdminDiscount";
		
	}
	
	@GetMapping("deleteVoucher/{voucher_id}")
	public String deleteVoucher(@PathVariable("voucher_id") Integer voucher_id) {
		voucherService.deleteVoucher(voucher_id);
		
		return "redirect:/AdminDiscount";
	}

}
