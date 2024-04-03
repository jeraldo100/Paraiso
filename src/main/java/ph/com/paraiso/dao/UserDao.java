package ph.com.paraiso.dao;

import java.util.List;


import ph.com.paraiso.model.User;

public interface UserDao {
	public User authenticate(User user);
	public List<User> getUsers();
	
	//add user
	public User addUser(User user);
	
	//update
	public User getUserById(Integer userid);
	public User updateUser(User user);
	
	public void deleteById(Integer userid);
}
