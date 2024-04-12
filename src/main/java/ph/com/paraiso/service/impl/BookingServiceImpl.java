package ph.com.paraiso.service.impl;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
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
import ph.com.paraiso.dao.BookingDao;
import ph.com.paraiso.model.AddOns;
import ph.com.paraiso.model.Booked_room;
import ph.com.paraiso.model.Booking;
import ph.com.paraiso.model.Room;
import ph.com.paraiso.model.Room_joined;
import ph.com.paraiso.model.Room_typeBooking;
import ph.com.paraiso.repository.BookingRepository;
import ph.com.paraiso.repository.RoomRepository;
import ph.com.paraiso.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private BookingDao bookDao;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private RoomRepository roomRepository;
	
	
	@Override
	public List<Room_typeBooking> listAllRoom_type(String checkin_date, String checkout_date){
		return bookDao.listAllRoom_type(checkin_date, checkout_date);
	}
	
	@Override
	public Room_joined getRoom_joined_first(Integer room_type, String checkin_date, String checkout_date){
		return bookDao.getRoom_joined_first(room_type, checkin_date, checkout_date);
	}
	
	@Override
	public Room_joined getRoom_joined(Integer room_type, String checkin_date, String checkout_date, List<Integer> room_ids){
		return bookDao.getRoom_joined(room_type, checkin_date, checkout_date, room_ids);	
	}
	
	@Override
	public List<Room_joined> getRoom_joinedList(List<Integer> room_ids){
		return bookDao.getRoom_joinedList(room_ids);	
	}
	
	@Override
	public Double getTotalPriceRooms(List<Integer> room_ids){
		return bookDao.getTotalPriceRooms(room_ids);	
	}
	
	@Override
	public Booking addConfirmedBooking(Booking booking) {
		return bookDao.addConfirmedBooking(booking);
	}
	
	@Override
	public Double getPriceOfRoomByRoomId(Integer room_id) {
		return bookDao.getPriceOfRoomByRoomId(room_id);
	}
	
	@Override
	public void addBooked_room(Booked_room booked_room){
		bookDao.addBooked_room(booked_room);
	}
	
	@Override
	public List<AddOns> getAllAddOnsBooking(){
		return bookDao.getAllAddOnsBooking();
	}
	
	@Override
	public Double getAddOnAmountByIds(List<Integer> add_on_ids) {
		return bookDao.getAddOnAmountByIds(add_on_ids);
	}
	
	public void exportJasperReportRooms(HttpServletResponse response) throws JRException, IOException {
	    List<Room> bookings = roomRepository.findAll();
	    File file = ResourceUtils.getFile("src/main/webapp/WEB-INF/reports/historyrooms.jrxml");
	    JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
	    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(bookings);
	    Map<String, Object> parameters = new HashMap<>();
	    parameters.put("createdBy", "flocer");
	    try {
	        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
	        if (jasperPrint.getPages().isEmpty()) {
	            System.out.println("The report has no pages.");
	        }
	        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
	    } catch (JRException e) {
	        e.printStackTrace();
	        throw new RuntimeException("Error generating report", e);
	    }
	}
	
	
	
	public void exportJasperReportRevenue(HttpServletResponse response) throws JRException, IOException {
	    Double totalrevenue = bookingRepository.sumTotalPrice();

	    File file = ResourceUtils.getFile("src/main/webapp/WEB-INF/reports/revenues.jrxml");
	    JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

	    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(Collections.emptyList());

	    Map<String, Object> parameters = new HashMap<>();
	    parameters.put("totalrevenue", totalrevenue);
	    parameters.put("createdBy", "flocer");

	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

	    if (jasperPrint.getPages().isEmpty()) {
	        System.out.println("The report has no pages.");
	    }
	    JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
	}
	
	public void exportJasperReportBooking(HttpServletResponse response) throws JRException, IOException {
	    List<Booking> bookings = bookingRepository.findAll();
	    File file = ResourceUtils.getFile("src/main/webapp/WEB-INF/reports/historybookings.jrxml");
	    JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
	    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(bookings);
	    Map<String, Object> parameters = new HashMap<>();
	    parameters.put("createdBy", "flocer");

	    try {
	        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
	        if (jasperPrint.getPages().isEmpty()) {
	            System.out.println("The report has no pages.");
	        }
	        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
	    } catch (JRException e) {
	        e.printStackTrace();
	        throw new RuntimeException("Error generating report", e);
	    }
	}
}
