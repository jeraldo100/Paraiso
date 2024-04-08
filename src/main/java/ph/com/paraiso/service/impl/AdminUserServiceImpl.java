package ph.com.paraiso.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import ph.com.paraiso.model.User;
import ph.com.paraiso.repository.AdminUserRepository;
import ph.com.paraiso.repository.UserRepository;
import ph.com.paraiso.service.AdminUserService;

@Service
public class AdminUserServiceImpl implements AdminUserService {
	
	private AdminUserRepository adminUserRepository;
	
	public AdminUserServiceImpl(AdminUserRepository adminUserRepository) {
		super();
		this.adminUserRepository = adminUserRepository;
	}
	
	@Override
	public List<User> getAllUsers(){
		return adminUserRepository.findAll();
	}

	@Override
	public User addUser(User user) {

		return adminUserRepository.save(user);
	}

	@Override
	public User updateUser(User user) {

		return adminUserRepository.save(user);
	}

	@Override
	public User getUserById(Integer user_id) {

		return adminUserRepository.findById(user_id).get();
	}

	@Override
	public void deleteUserById(Integer user_id) {
		adminUserRepository.deleteById(user_id);
		
	}
}
