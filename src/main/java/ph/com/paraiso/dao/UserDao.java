package ph.com.paraiso.dao;

import ph.com.paraiso.model.User;
import java.util.List;


import ph.com.paraiso.model.User;

public interface UserDao {
	public User authenticate(User user);
	public List<User> getUsers();
	

	public User addUser(User user);
	
	public User getUserById(Integer userid);
	public User updateUser(User user);
	
	public void deleteById(Integer userid);
}
