package ph.com.paraiso.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ph.com.paraiso.dao.BookingDao;
import ph.com.paraiso.dao.UserDao;
import ph.com.paraiso.dto.UserDto;
import ph.com.paraiso.model.Booking;
import ph.com.paraiso.model.User;
import ph.com.paraiso.repository.BookingRepository;
import ph.com.paraiso.repository.UserRepository;
import ph.com.paraiso.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BookingRepository bookingRepository;
	
		@Autowired
		UserDao userDao;
		BookingDao bookingDao;


		@Override
		public String authenticate(User user) {
			String result = "failed";
			User vUser = userDao.authenticate(user);
			BCryptPasswordEncoder bcrypt= new BCryptPasswordEncoder();
			
			if(vUser != null) {
				if(bcrypt.matches(user.getPassword(), vUser.getPassword())) {
					result = "success";
				}
			}
			return result;
		}

		@Override
		public List<User> getUsers() {
			return userDao.getUsers();
		}

		@Override
		public User addUser(User user) {
			return userDao.addUser(user);
		}

		@Override
		public User getUserById(Integer userid) {
			return userDao.getUserById(userid);
		}

		@Override
		public User updateUser(User user) {
			return userDao.updateUser(user);
		}
		
		@Override
		public void deleteById(Integer userid) {
			userDao.deleteById(userid);
			
		}
		
		 @Override
		    public String getAccountTypeByEmail(String email) {
		        User user = userRepository.findByemail(email);
		        if (user != null) {
		            return user.getAccountType();
		        } else {
		            return null; 
		        }
		    }
		 
			@Override
			public String getUsernameByEmail(String email) {
		        User user = userRepository.findByemail(email);
		        if (user != null) {
		            return user.getUsername();
		        } else {
		            return null; 
		        }
			}
			

			@Override
			public Integer getUserIdByEmail(String email) {
		        User user = userRepository.findByemail(email);
		        if (user != null) {
		            return user.getUserid();
		        } else {
		            return null; 
		        }
			}

	@Override
	public User save(UserDto userDto) {
		BCryptPasswordEncoder bcrypt= new BCryptPasswordEncoder();
		String encrypedPwd = bcrypt.encode(userDto.getPassword());
		User user = new User(userDto.getFirstName(), userDto.getLastName(), userDto.getEmail(), 
	    userDto.getUsername(), userDto.getAddress(), userDto.getDateOfBirth(), userDto.getPhone(), 
	    userDto.getPassword(), userDto.getAccountType());
		user.setPassword(encrypedPwd);
		return userRepository.save(user);
	}
	
	
	
	

	@Override
	public boolean isEmailTaken(String email) {
        User user = userRepository.findByemail(email);
        return user != null;
	}
	@Override
	public boolean isUsernameTaken(String username) {
        User user = userRepository.findByusername(username);
        return user != null;
	}

	public void exportJasperReportRoom(HttpServletResponse response) throws JRException {
		 List<Booking> bookings = bookingRepository.findAll();
		
        //Get file and compile it
        File file = null;
		try {
			file = ResourceUtils.getFile("src/main/webapp/WEB-INF/reports/bookings.jrxml");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(bookings);
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