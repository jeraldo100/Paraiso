package ph.com.paraiso.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.ServletContextResource;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import ph.com.paraiso.model.Booking;
import ph.com.paraiso.service.BookingService;
import ph.com.paraiso.service.UserService;
import ph.com.paraiso.session.SessionManager;

@Controller
public class JasperController {

	@Autowired
	UserService userSvc;

	@Autowired
	BookingService bookingService;
	
	public void setCommonAttributes(HttpServletRequest request, Model model) { 
        String userEmail = SessionManager.getEmailFromSession(request);
        if (userEmail != null) {
            String accountType = userSvc.getAccountTypeByEmail(userEmail);
            String username = userSvc.getUsernameByEmail(userEmail);
            Integer userId = userSvc.getUserIdByEmail(userEmail);
            System.out.println("Email of the user with current session: " + userEmail);
            System.out.println("AccountType of the user with current session: " + accountType);
            System.out.println("username of the user with current session: " + username);
            System.out.println("user id of the user with current session: " + userId);
            model.addAttribute("username", username);
            model.addAttribute("loggedIn", true);
        } else {
            System.out.println("No user associated with the current session.");
            model.addAttribute("loggedIn", false);
        }
    }
		
	    @GetMapping("/jasperpdfrooms/export")
	    public void createRoomsPDF(HttpServletResponse response) throws IOException, JRException {
	        response.setContentType("application/pdf");
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=rooms.pdf";
	        response.setHeader(headerKey, headerValue);
	        bookingService.exportJasperReportRooms(response);
	    }
	    

		@GetMapping("/jasperpdf/export")
		public void createPDF(HttpServletResponse response) throws IOException, JRException {
			response.setContentType("application/pdf");
			String headerKey = "Content-Disposition";
			String headerValue = "attachment; filename=bookings.pdf";
			response.setHeader(headerKey, headerValue);
			bookingService.exportJasperReportBooking(response);
		}

	

    private ServletContext servletContext;
    
    @GetMapping("/jasperReportItinerary")
    public void printUserDashboard(HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model) {
    	setCommonAttributes(request, model);
        try {
            ServletContext servletContext = request.getServletContext();
            String userEmail = SessionManager.getEmailFromSession(request);
    		Integer user_id = userSvc.getUserIdByEmail(userEmail);
            // Load the JasperReport template
            ServletContextResource resource = new ServletContextResource(servletContext, "/WEB-INF/reports/Itinerary1.jrxml");
            InputStream inputStream = resource.getInputStream();
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);

            // Set parameters
            Map<String, Object> parameters = new HashMap<>();
            System.out.println(user_id);
            parameters.put("P_USER_ID", user_id);

            // Fetch data for your dashboard (optional)
            // Implement this method to fetch data needed for your report
            // List<YourDataClass> data = fetchDataForDashboard();

            // Convert the data to a JRBeanCollectionDataSource
            List<Booking> bookingList = (List<Booking>) session.getAttribute("userBookings");
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(bookingList);

            // Fill the report with datas
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

            // Export the report to PDF and send it to the response
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "inline; filename=userDashboard.pdf");
            JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());

            System.out.println("User dashboard printed successfully.");
        } catch (JRException | IOException e) {
            e.printStackTrace();
        }
    }
}
