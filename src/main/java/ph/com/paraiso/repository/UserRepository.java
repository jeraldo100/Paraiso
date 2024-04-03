package ph.com.paraiso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ph.com.paraiso.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	/* public User findByusername(String username); */
}
