package ph.com.paraiso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ph.com.paraiso.model.AddOns;
import ph.com.paraiso.service.AddOnsService;

@Controller
public class AddOnsController {
	
	@Autowired
	private AddOnsService addOnsService;

	
	@GetMapping("/AdminAddOns")
	public String adminAddOns(Model model) {
		model.addAttribute("addOns", addOnsService.getAllAddOns());
		return "dashboardAdmin/AddOns";
	}

	@GetMapping("/addAddOns")
	public String addAddOns(Model model) {
		
		AddOns addOns = new AddOns();
		
		model.addAttribute("addOns", addOns);
		
		return "dashboardAdmin/AddOnsCRUD/AddAddOns";
	}
	
	@PostMapping("addAddOns/save")
	public String newAddOns(
			@RequestParam("add_on_name") String add_on_name,
			@RequestParam("description") String description,
			@RequestParam("amount") Integer amount,Model model) {
		
		AddOns addOns = new AddOns();
		
		addOns.setAdd_on_name(add_on_name);
		addOns.setDescription(description);
		addOns.setAmount(amount);
		
		addOnsService.addAddOns(addOns);
		
		return "redirect:/AdminAddOns";
		
	}
	
	@GetMapping("/editAddOns/{add_on_id}")
	public String editAddOns(@PathVariable("add_on_id") Integer add_on_id, Model model) {
		model.addAttribute("addOns", addOnsService.getAddOnsById(add_on_id));
		return "dashboardAdmin/AddOnsCRUD/EditAddOns";
	}
	
	@PostMapping("/updateAddOns/{add_on_id}")
	public String updateAddOns(@PathVariable("add_on_id") Integer add_on_id,
			@ModelAttribute("addOns") AddOns addOns,
			Model model) {
		
		AddOns existingAddOns = addOnsService.getAddOnsById(add_on_id);
		existingAddOns.setAdd_on_id(add_on_id);
		existingAddOns.setAdd_on_name(addOns.getAdd_on_name());
		existingAddOns.setDescription(addOns.getDescription());
		existingAddOns.setAmount(addOns.getAmount());
		
		addOnsService.updateVoucher(existingAddOns);
		
		return "redirect:/AdminAddOns";
		
	}
	
	@GetMapping("deleteAddOns/{add_on_id}")
	public String deleteAddOns(@PathVariable("add_on_id") Integer add_on_id) {
		addOnsService.deleteAddOns(add_on_id);
		
		return "redirect:/AdminAddOns";
	}
}
