package ph.com.paraiso.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ph.com.paraiso.dao.UserDao;
import ph.com.paraiso.model.User;
import ph.com.paraiso.repository.UserRepository;
import ph.com.paraiso.service.UserService;
import ph.come.paraiso.dto.UserDto;

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
			
			if(vUser != null) {
				if(vUser.getPassword().equals(user.getPassword())) {
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
		public User getUserById(Long userid) {
			return userDao.getUserById(userid);
		}

		@Override
		public User updateUser(User user) {
			return userDao.updateUser(user);
		}
		
		@Override
		public void deleteById(Long userid) {
			userDao.deleteById(userid);
			
		}

	@Override
	public User save(UserDto userDto) {
		User user = new User(userDto.getUsername(), userDto.getPassword(), userDto.getAccountType(), userDto.getFirstName(), userDto.getLastName(), userDto.getDateOfBirth(), userDto.getAddress(), userDto.getPhone(), userDto.getEmail());
		return userRepository.save(user);
	}
}
