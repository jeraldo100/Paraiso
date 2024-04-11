package ph.com.paraiso.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import ph.com.paraiso.service.BookingService;

@Controller
public class JasperController {
	

@RestController
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    
    @GetMapping("/jasperpdf/export/{typeId}")
    public void createRoomHistoryPDF(HttpServletResponse response, @PathVariable Integer typeId) throws IOException, JRException {
        response.setContentType("application/pdf");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=rooms_history.pdf";
        List<Object[]> roomsHistory = bookingService.findRoomsHistoryByTypeId(typeId);
        for (Object[] row : roomsHistory) {
            for (Object value : row) {
                System.out.print(value + "\t");
            }
            System.out.println(); 
        }
        response.setHeader(headerKey, headerValue);
        bookingService.exportJasperReportRoomHistory(response, typeId);
    }
    
    @GetMapping("/jasperpdfbookings/export")
    public void jasperAllBookingDetails(HttpServletResponse response) throws IOException, JRException {
        response.setContentType("application/pdf");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=bookings.pdf";
        response.setHeader(headerKey, headerValue);
        bookingService.exportJasperReportBooking(response);
    }

    @GetMapping("/jasperpdf/export")
    public void createPDF(HttpServletResponse response) throws IOException, JRException {
        response.setContentType("application/pdf");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=bookings.pdf";
        response.setHeader(headerKey, headerValue);
        
        List<Object[]> roomsHistory = bookingService.findRoomsHistoryByTypeId(30);
        for (Object[] row : roomsHistory) {
            for (Object value : row) {
                System.out.print(value + "\t");
            }
            System.out.println(); 
        }
        
        List<Object[]> bookingDetails = bookingService.findAllBookingsDetails();
        for (Object[] row : bookingDetails) {
            for (Object value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
        bookingService.exportJasperReportBooking(response);
    }

}
}


