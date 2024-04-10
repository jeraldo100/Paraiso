package ph.com.paraiso.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import ph.com.paraiso.service.JasperReportsService;

@Controller
public class JasperReportsController {
	
	@Autowired
	JasperReportsService reportsSvc;	


	@GetMapping("/jasperpdf/export/{id}")
    public void createPDF(HttpServletResponse response, @PathVariable Integer id, Model model) throws IOException, JRException {
        response.setContentType("application/pdf");
        Date date = new Date();
        SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String stringDate= DateFor.format(date);
  
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=hobbies_" + stringDate + ".pdf";
        response.setHeader(headerKey, headerValue);
  
        reportsSvc.exportJasperReport(response, id);
       
    }
}
