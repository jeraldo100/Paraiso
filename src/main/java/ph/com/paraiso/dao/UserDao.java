package ph.com.paraiso.dao;

import ph.com.paraiso.model.User;

public interface UserDao {

	public User addUser(User user);
	
	public User updateUser(User user);
	public User getUserById(Integer user_id);
	
}
