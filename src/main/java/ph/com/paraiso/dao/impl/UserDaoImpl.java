package ph.com.paraiso.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import ph.com.paraiso.dao.UserDao;
import ph.com.paraiso.model.User;
import ph.com.paraiso.repository.UserRepository;

public class UserDaoImpl implements UserDao{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User addUser(User user) {

		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {

		return userRepository.save(user);
	}

	@Override
	public User getUserById(Integer user_id) {

		return userRepository.findById(user_id).get();
	}

}
