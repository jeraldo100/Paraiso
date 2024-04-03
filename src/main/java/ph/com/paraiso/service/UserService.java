package ph.com.paraiso.service;

import java.util.List;
import ph.com.paraiso.model.User;

public interface UserService {

	public String authenticate(User user);
	public List<User> getUsers();
	
	//add
	public User addUser(User user);
	
	//update
	public User getUserById(Integer userid);
	public User updateUser(User user);
	
	public void deleteById(Integer userid);
}
