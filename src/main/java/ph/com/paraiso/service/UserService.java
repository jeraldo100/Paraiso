package ph.com.paraiso.service;

import java.util.List;

import ph.com.paraiso.model.User;

public interface UserService {

	
	List<User> getAllUsers();
	
	public User addUser(User user);
	
	public User updateUser(User user);
	public User getUserById(Integer user_id);
	
	public void deleteUserById(Integer user_id);
	
	
}
