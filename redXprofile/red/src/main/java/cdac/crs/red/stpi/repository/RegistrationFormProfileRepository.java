package cdac.crs.red.stpi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cdac.crs.red.stpi.entity.UserRegisterEntity;

@Repository
public interface RegistrationFormProfileRepository extends JpaRepository<UserRegisterEntity, Long>{

	@Query("SELECT u FROM UserRegisterEntity u WHERE u.username = :username")
	UserRegisterEntity findByUserName(String username);

}
