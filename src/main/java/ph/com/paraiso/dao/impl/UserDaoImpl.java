package ph.com.paraiso.dao.impl;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ph.com.paraiso.model.User;
import ph.com.paraiso.repository.UserRepository;
import ph.com.paraiso.dao.UserDao;
import ph.com.paraiso.model.User;
import ph.com.paraiso.repository.UserRepository;

@Component
public class UserDaoImpl implements UserDao{
		
	@Autowired
	UserRepository userRepo;
	
	@Override
	public User authenticate(User user) {

		return userRepo.findByemail(user.getEmail());
	}
	
	@Override
	public List<User> getUsers() {
		return userRepo.findAll();
	}

	@Override
	public User addUser(User user) {
		
		return userRepo.save(user);
	}

	@Override
	public User getUserById(Integer userid) {
		return userRepo.findById(userid).get();
	}

	@Override
	public User updateUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public void deleteById(Integer userid) {
		userRepo.deleteById(userid);
		
	}
}

