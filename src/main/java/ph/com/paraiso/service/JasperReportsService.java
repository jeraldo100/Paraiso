package ph.com.paraiso.service;

import java.io.IOException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JRException;

public interface JasperReportsService {
 
	public void exportReportBooking(HttpSession session, HttpServletRequest request, HttpServletResponse response,
    		Model model) throws JRException, IOException;
	
	  public void exportReportItinerary(HttpSession session, HttpServletRequest request, HttpServletResponse response,
	    		@PathVariable Integer booking_id,Model model) throws JRException, IOException;
	  
	  public void exportReportRoom(HttpSession session, HttpServletRequest request, HttpServletResponse response,
	    		@PathVariable Integer type_id, Model model) throws JRException, IOException;
}
