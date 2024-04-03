package ph.com.paraiso.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import ph.com.paraiso.model.User;
import ph.com.paraiso.repository.UserRepository;
import ph.com.paraiso.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	@Override
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
}
