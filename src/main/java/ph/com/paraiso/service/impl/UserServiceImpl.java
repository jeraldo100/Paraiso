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


	@Override
	public User save(UserDto userDto) {
		User user = new User(userDto.getUsername(), userDto.getPassword(), userDto.getAccountType(), userDto.getFirstName(), userDto.getLastName(), userDto.getDateOfBirth(), userDto.getAddress(), userDto.getPhone(), userDto.getEmail());
		return userRepository.save(user);
	}
}
