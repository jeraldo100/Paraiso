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
    

    @GetMapping("/jasperpdf/export")
    public void createPDF(HttpServletResponse response) throws IOException, JRException {
        response.setContentType("application/pdf");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=bookings.pdf";
        response.setHeader(headerKey, headerValue);
        bookingService.exportJasperReportBooking(response);
    }
    
    @GetMapping("/jasperpdfrooms/export")
    public void createRoomsPDF(HttpServletResponse response) throws IOException, JRException {
        response.setContentType("application/pdf");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=rooms.pdf";
        response.setHeader(headerKey, headerValue);
        bookingService.exportJasperReportRooms(response);
    }
    

}
}


