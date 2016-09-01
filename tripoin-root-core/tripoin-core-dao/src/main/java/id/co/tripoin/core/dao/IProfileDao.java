package id.co.tripoin.core.dao;

import id.co.tripoin.core.pojo.Profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public interface IProfileDao extends JpaRepository<Profile, Long> {

	public Profile findByEmail(String email);
	
	public Profile findByPhone(String phone);
	
	@Query("SELECT p FROM Profile p WHERE p.user.username = :username")
	public Profile findByUsername(@Param("username")String username);

}
