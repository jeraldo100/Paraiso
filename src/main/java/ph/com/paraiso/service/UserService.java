package ph.com.paraiso.service;

import java.util.List;
import ph.com.paraiso.dto.UserDto;
import ph.com.paraiso.model.User;

public interface UserService {
	User save(UserDto userDto);
	public String authenticate(User user);
	public List<User> getUsers();
	
	public User addUser(User user);
	

	public User getUserById(Integer userid);
	public User updateUser(User user);
	
	public void deleteById(Integer userid);
	
	public String getAccountTypeByEmail(String email);
	public String getUsernameByEmail(String email);
	public Integer getUserIdByEmail(String email);
	boolean isEmailTaken(String email);
	boolean isUsernameTaken(String username);
}
