package ph.com.paraiso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ph.com.paraiso.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User findByemail(String email);
}
