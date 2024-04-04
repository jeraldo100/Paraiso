package ph.com.paraiso.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ph.com.paraiso.model.User;
import ph.com.paraiso.repository.UserRepository;
import ph.com.paraiso.dao.UserDao;

@Component
public class UserDaoImpl implements UserDao{
	
	@Autowired
	UserRepository userRepo;

	

}
