package ph.com.paraiso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import ph.com.paraiso.model.User;

@Repository
public interface JasperReportsRepository extends JpaRepository<User, Integer>{
	public @NonNull List<User> findAll();

	public List<User> findAllByUserId(Integer id);
	
	
}
