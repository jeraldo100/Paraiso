package ph.com.paraiso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ph.com.paraiso.model.User;

public interface AdminUserRepository extends JpaRepository<User, Integer>{

}
