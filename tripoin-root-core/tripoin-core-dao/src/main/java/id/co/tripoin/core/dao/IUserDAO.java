package id.co.tripoin.core.dao;

import id.co.tripoin.core.pojo.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


/**
 * created on 1/20/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IUserDAO extends JpaRepository<User, Long>{
	
	@Query("SELECT a from User a JOIN a.securityUserProfile b JOIN b.contact c where c.email = ?1")
	User findByEmail(String p_Email);
	
	User findByUsername(String p_UserName);
}
