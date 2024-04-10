package ph.com.paraiso.service;
import org.springframework.stereotype.Service;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;

@Service
public interface JasperReportsService {

	public void exportJasperReportUser(HttpServletResponse response) throws JRException;
	public void exportJasperReport(HttpServletResponse response, Integer id) throws JRException;
	
	
	
}
