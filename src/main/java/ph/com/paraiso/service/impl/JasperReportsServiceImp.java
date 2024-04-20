package ph.com.paraiso.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
import ph.com.paraiso.model.Booking;
import ph.com.paraiso.model.BookingHistory;
import ph.com.paraiso.model.Itinerary;
import ph.com.paraiso.model.User;
import ph.com.paraiso.repository.BookingRepository;
import ph.com.paraiso.repository.RoomRepository;
import ph.com.paraiso.repository.UserRepository;
import ph.com.paraiso.service.BookingService;
import ph.com.paraiso.service.JasperReportsService;
import ph.com.paraiso.service.UserService;
import ph.com.paraiso.session.SessionManager;

@Service
public class JasperReportsServiceImp implements JasperReportsService{

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
    
    
    

    public void exportReportItinerary(HttpSession session, HttpServletRequest request, HttpServletResponse response,
    		@PathVariable Integer booking_id,Model model) throws JRException, IOException {

        File logo = null;
        try {
            ServletContext servletContext = request.getServletContext();
            String userEmail = SessionManager.getEmailFromSession(request);
            Integer user_id = userSvc.getUserIdByEmail(userEmail);
            logo = ResourceUtils.getFile("/WEB-INF/reports/logo.png");
            ServletContextResource resource = new ServletContextResource(servletContext,
                    "/WEB-INF/reports/Itinerary.jrxml");
            InputStream inputStream = resource.getInputStream();
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("P_USER_ID", user_id);
            parameters.put("P_LOGO", logo.getAbsolutePath());
            List<Booking> bookingList = (List<Booking>) session.getAttribute("userBookings");
            List<Itinerary> Itinerarys = new ArrayList<>();
            User user = userRepository.findByuserid(user_id);
            Itinerary Itinerary = new Itinerary();
            Itinerary.setFirstName(user.getFirstName());
            Itinerary.setLastName(user.getLastName());

            for (Booking booking : bookingList) {
                Integer bookingId = booking_id;
                List<String> roomTypeNames = bookingRepository.findRoomTypeNamesByBookingId(bookingId);
                String roomTypeName = String.join(", ", roomTypeNames);
                Itinerary.setRoomTypeName(roomTypeName);
                Itinerary.setBooking_id(booking.getBooking_id());
                Itinerary.setCheckin_date(booking.getCheckin_date());
                Itinerary.setCheckout_date(booking.getCheckout_date());
                Itinerary.setTotal_price(booking.getTotal_price());
                Itinerary.setArrival_time(booking.getArrival_time());
                Itinerary.setAdults(booking.getAdults());
                Itinerary.setChildren(booking.getChildren());
                Itinerary.setStatus(booking.getStatus());
                Itinerarys.add(Itinerary);
                
            }
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(Itinerarys);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

            JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());

        } catch (JRException | IOException e) {
            e.printStackTrace();
        }
    }
    
	
	public void exportReportBooking(HttpSession session, HttpServletRequest request, HttpServletResponse response,
    		Model model) throws JRException, IOException {
      File logo = null;
      try {
          ServletContext servletContext = request.getServletContext();
          String userEmail = SessionManager.getEmailFromSession(request);
          Integer user_id = userSvc.getUserIdByEmail(userEmail);
          logo = ResourceUtils.getFile("/WEB-INF/reports/logo.png");
          ServletContextResource resource = new ServletContextResource(servletContext,
                  "/WEB-INF/reports/bookings.jrxml");
          InputStream inputStream = resource.getInputStream();
          JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
          Map<String, Object> parameters = new HashMap<>();
          parameters.put("P_USER_ID", user_id);
          parameters.put("P_LOGO", logo.getAbsolutePath());

          List<Booking> bookingList = bookingRepository.findAll();
          List<BookingHistory> bookingHistorys = new ArrayList<>();
     
          for (Booking booking : bookingList) {
              BookingHistory bookingHistory = new BookingHistory(); 
             
              List<String> roomTypeNames = bookingRepository.findRoomTypeNamesByBookingId(booking.getBooking_id());

              String roomTypeName = String.join(", ", roomTypeNames);
              bookingHistory.setRoomTypeName(roomTypeName);
              bookingHistory.setUser_id(booking.getUser_id());
              bookingHistory.setBooking_id(booking.getBooking_id());
              bookingHistory.setCheckin_date(booking.getCheckin_date());
              bookingHistory.setCheckout_date(booking.getCheckout_date());
              bookingHistory.setTotal_price(booking.getTotal_price());
              bookingHistory.setAdults(booking.getAdults());
              bookingHistory.setChildren(booking.getChildren());
              bookingHistory.setStatus(booking.getStatus());
              List<User> userList = userRepository.findByUserid(booking.getUser_id());
              for (User user : userList) {
              	
                  bookingHistory.setFirstName(user.getFirstName());
                  bookingHistory.setLastName(user.getLastName());
              }

              bookingHistorys.add(bookingHistory);
          }

          JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(bookingHistorys);

          JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

          JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());

      } catch (JRException | IOException e) {
          e.printStackTrace();
      }
	}
}
