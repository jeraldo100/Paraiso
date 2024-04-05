package ph.com.paraiso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

	@GetMapping("/AdminDashboard")
	public String adminDashboardPage() {
		return "dashboardAdmin/Dashboard";
	}
	
}
