package ph.com.paraiso.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JRException;
import ph.com.paraiso.repository.BookingRepository;
import ph.com.paraiso.repository.RoomRepository;
import ph.com.paraiso.repository.UserRepository;
import ph.com.paraiso.service.BookingService;
import ph.com.paraiso.service.JasperReportsService;
import ph.com.paraiso.service.UserService;
import ph.com.paraiso.session.SessionManager;

@Controller
public class JasperController {

	@Autowired
	UserService userSvc;

	@Autowired
	BookingService bookingService;

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	RoomRepository roomRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	JasperReportsService jasperReportsService;

	public void setCommonAttributes(HttpServletRequest request, Model model) {
		String userEmail = SessionManager.getEmailFromSession(request);
		if (userEmail != null) {
			userSvc.getAccountTypeByEmail(userEmail);
			String username = userSvc.getUsernameByEmail(userEmail);
			userSvc.getUserIdByEmail(userEmail);
			model.addAttribute("username", username);
			model.addAttribute("loggedIn", true);
		} else {
			model.addAttribute("loggedIn", false);
		}
	}

	@GetMapping("/jasperReportItinerary/{booking_id}")
	public void printUserItinerary(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			@PathVariable Integer booking_id, Model model) throws JRException, IOException {
		setCommonAttributes(request, model);
		response.setContentType("application/pdf");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=itinerary.pdf";
		response.setHeader(headerKey, headerValue);

		jasperReportsService.exportReportItinerary(session, request, response, booking_id, model);
	}

	@GetMapping("/jasperReportRooms/{type_id}")
	public void printUReportRooms(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			@PathVariable Integer type_id, Model model) throws JRException, IOException {
		setCommonAttributes(request, model);
		response.setContentType("application/pdf");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=rooms_history.pdf";
		response.setHeader(headerKey, headerValue);

		jasperReportsService.exportReportRoom(session, request, response, type_id, model);
	}

	@GetMapping("/jasperReportBooking")
	public void printReportBooking(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			Model model) throws JRException, IOException {

		response.setContentType("application/pdf");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=BookingsHistory.pdf";
		response.setHeader(headerKey, headerValue);
		jasperReportsService.exportReportBooking(session, request, response, model);

	}

	@GetMapping("/jasperReportBookingRev")
	public void printReportRevenue(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			Model model) throws JRException, IOException {
		response.setContentType("application/pdf");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=BookingsRevenue.pdf";
		response.setHeader(headerKey, headerValue);
		jasperReportsService.exportReportRevenue(session, request, response, model);

	}
}
