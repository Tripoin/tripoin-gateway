package id.co.tripoin.core.dao;

import id.co.tripoin.core.pojo.security.SecurityOAuthClientDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISecurityOAuthClientDetailsDAO extends JpaRepository<SecurityOAuthClientDetails, String>{
	
	SecurityOAuthClientDetails findByClientId(String p_ClientId);
}
