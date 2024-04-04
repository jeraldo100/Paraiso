package ph.com.paraiso.service;

import java.util.List;
import ph.com.paraiso.model.User;
import ph.come.paraiso.dto.UserDto;

public interface UserService {

	User save(UserDto userDto);
	
}
