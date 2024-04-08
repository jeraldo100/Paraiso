package ph.com.paraiso.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ph.com.paraiso.dao.UserDao;
import ph.com.paraiso.dto.UserDto;
import ph.com.paraiso.model.User;
import ph.com.paraiso.repository.UserRepository;
import ph.com.paraiso.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserRepository userRepository;
	
		@Autowired
		UserDao userDao;

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
		User user = new User(userDto.getFirstName(), userDto.getLastName(), userDto.getEmail(), userDto.getUsername(), userDto.getAddress(), userDto.getDateOfBirth(), userDto.getPhone(), userDto.getPassword(), userDto.getAccountType());
		user.setPassword(encrypedPwd);
		return userRepository.save(user);
}

}