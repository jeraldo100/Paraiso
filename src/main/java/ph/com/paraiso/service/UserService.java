package ph.com.paraiso.service;

import java.util.List;
import ph.com.paraiso.model.User;
import ph.come.paraiso.dto.UserDto;

public interface UserService {

	User save(UserDto userDto);
	public String authenticate(User user);
	public List<User> getUsers();
	
	//add
	public User addUser(User user);
	
	//update
	public User getUserById(Long userid);
	public User updateUser(User user);
	
	public void deleteById(Long userid);
}
