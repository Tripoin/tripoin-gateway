package id.co.tripoin.core.service;

import id.co.tripoin.core.pojo.security.SecurityOAuthClientDetails;
import id.co.tripoin.core.service.transaction.ISingleTransaction;
import org.springframework.transaction.annotation.Transactional;

/**
 * created on 12/28/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ISecurityOAuthClientDetailsService extends ISingleTransaction<SecurityOAuthClientDetails> {
	
	/**
	 * 
	 * @return -1 Failed || 0 Success
	 */
	int insertNewClientDetails(SecurityOAuthClientDetails p_SecurityOAuthClientDetails);
	
	SecurityOAuthClientDetails generateNewAPIClient(String p_ClientId, String p_ClientSecret, String p_Authorities);
	
	boolean checkPassword(String p_UserName, String p_Password);

	@Transactional
	boolean updatePassword(String p_UserName, String p_NewPassword);
	
	SecurityOAuthClientDetails findByClientId(String p_ClientId);
	
	void update(SecurityOAuthClientDetails p_SecurityOAuthClientDetails);
}
