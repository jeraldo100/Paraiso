package ph.com.paraiso.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import ph.com.paraiso.model.User;
import ph.com.paraiso.repository.JasperReportsRepository;

@Service
public class JasperReportsServiceImpl {
	@Autowired
	JasperReportsRepository jasperRepo;
	
	public void exportJasperReport(HttpServletResponse response, Integer id) throws JRException {
		List<User> users = jasperRepo.findAllByUserId(id);
		
        //Get file and compile it
        File file = null;
		try {
			file = ResourceUtils.getFile("src/main/webapp/WEB-INF/views/reports/paraisousers.jrxml");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(users);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "flocer");

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        try {
			JasperExportManager.exportReportToPdfStream(jasperPrint,response.getOutputStream());
		} catch (JRException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void exportJasperReportUser(HttpServletResponse response) throws JRException {
		List<User> users = jasperRepo.findAll();
        //Get file and compile it
        File file = null;
		try {
			file = ResourceUtils.getFile("src/main/webapp/WEB-INF/views/reports/paraisousers.jrxml");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(users);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "flocer");

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        try {
			JasperExportManager.exportReportToPdfStream(jasperPrint,response.getOutputStream());
		} catch (JRException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
