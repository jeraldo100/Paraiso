package ph.com.paraiso.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
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
import ph.com.paraiso.model.Itenerary;
import ph.com.paraiso.model.Room;
import ph.com.paraiso.model.User;
import ph.com.paraiso.repository.RoomRepository;
import ph.com.paraiso.repository.UserRepository;
import ph.com.paraiso.service.BookingService;
import ph.com.paraiso.service.UserService;
import ph.com.paraiso.session.SessionManager;

@Controller
public class JasperController {

	@Autowired
	UserService userSvc;

	@Autowired
	BookingService bookingService;
	
	@Autowired
	RoomRepository roomRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public void setCommonAttributes(HttpServletRequest request, Model model) { 
        String userEmail = SessionManager.getEmailFromSession(request);
        if (userEmail != null) {
            String accountType = userSvc.getAccountTypeByEmail(userEmail);
            String username = userSvc.getUsernameByEmail(userEmail);
            Integer userId = userSvc.getUserIdByEmail(userEmail);
            model.addAttribute("username", username);
            model.addAttribute("loggedIn", true);
        } else {
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
	    
	    @GetMapping("/jasperpdfrevenue/export")
	    public void createRevenuePDF(HttpServletResponse response) throws IOException, JRException {
	        response.setContentType("application/pdf");
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=revenue.pdf";
	        response.setHeader(headerKey, headerValue);
	        bookingService.exportJasperReportRevenue(response);
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
    	File logo = null;
        try {
            ServletContext servletContext = request.getServletContext();
            String userEmail = SessionManager.getEmailFromSession(request);
    		Integer user_id = userSvc.getUserIdByEmail(userEmail);
    		logo = ResourceUtils.getFile("/WEB-INF/reports/logo.png");
            ServletContextResource resource = new ServletContextResource(servletContext, "/WEB-INF/reports/Itinerary.jrxml");
            InputStream inputStream = resource.getInputStream();
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("P_USER_ID", user_id);
            parameters.put("P_LOGO", logo.getAbsolutePath());
            List<Booking> bookingList = (List<Booking>) session.getAttribute("userBookings");
            List<Itenerary> Itenerarys = new ArrayList<>();
            User user = userRepository.findByuserid(user_id);
     

            	
            	 Itenerary Itenerary = new Itenerary();
            	  Itenerary.setFirstName(user.getFirstName());
//           	  Itenerary.setLastName(user.getLastName());
           	  System.out.println(Itenerary.getFirstName());
            
            for (Booking booking : bookingList) {
 
              Itenerary.setBooking_id(booking.getBooking_id());
              Itenerary.setCheckin_date(booking.getCheckin_date()); 
              Itenerary.setCheckout_date(booking.getCheckout_date()); 
              Itenerary.setTotal_price(booking.getTotal_price());
              Itenerary.setArrival_time(booking.getArrival_time());
              Itenerary.setAdults(booking.getAdults());
              Itenerary.setChildren(booking.getChildren());
              Itenerary.setStatus(booking.getStatus());
              Itenerarys.add(Itenerary);
            }
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(Itenerarys);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "inline; filename=userDashboard.pdf");
            JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());

        } catch (JRException | IOException e) {
            e.printStackTrace();
        }
    }
}
