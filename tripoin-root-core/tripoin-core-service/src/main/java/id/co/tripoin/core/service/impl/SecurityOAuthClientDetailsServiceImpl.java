package id.co.tripoin.core.service.impl;

import id.co.tripoin.core.dao.ISecurityOAuthClientDetailsDAO;
import id.co.tripoin.core.pojo.security.SecurityOAuthClientDetails;
import id.co.tripoin.core.service.ISecurityOAuthClientDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * created on 2/9/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class SecurityOAuthClientDetailsServiceImpl implements ISecurityOAuthClientDetailsService {

	@Autowired
	ISecurityOAuthClientDetailsDAO secOAuthClientDetailsDAO;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityOAuthClientDetailsServiceImpl.class);
	
	@Override
	public int insertNewClientDetails(SecurityOAuthClientDetails p_SecurityOAuthClientDetails) {
		if (checkMandatoryFields(p_SecurityOAuthClientDetails)){
			try{
				secOAuthClientDetailsDAO.save(p_SecurityOAuthClientDetails);			
				return 0;
			}catch (Exception e) {
				LOGGER.error("Error insert new Sec Oauth Client Details");
				return -1;
			}		
		}else{
			return -1;
		}
	}

	@Override
	public SecurityOAuthClientDetails generateNewAPIClient(String p_ClientId , String p_ClientSecret, String p_Authorities) {
		SecurityOAuthClientDetails authClientDetails = new SecurityOAuthClientDetails();
		authClientDetails.setClientId(p_ClientId);
		authClientDetails.setClientSecret(passwordEncoder.encode(p_ClientSecret));
		authClientDetails.setResourceId("ws_api");
		authClientDetails.setScope("trust,read,write");
		authClientDetails.setAuthorizedGrantTypes("client_credentials,authorization_code,implicit,password,refresh_token");
		authClientDetails.setAuthorities(p_Authorities);
		authClientDetails.setAccessTokenValidity(4500);
		authClientDetails.setRefreshTokenValidity(45000);
		return authClientDetails;
	}
	
	@Override
	public boolean checkMandatoryFields(SecurityOAuthClientDetails p_DATA) {
		if (p_DATA.getClientId() != null){
			if (p_DATA.getResourceId() != null){
				if (p_DATA.getClientSecret() != null){
					if (p_DATA.getScope() != null){
						if (p_DATA.getAuthorizedGrantTypes() != null){
							if (p_DATA.getAuthorities() != null){
								if (p_DATA.getAccessTokenValidity() != null){
									if (p_DATA.getRefreshTokenValidity() != null){
										return true;
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
	}

	@Override
	public boolean checkPassword(String p_UserName, String p_Password) {
		SecurityOAuthClientDetails securityOAuthClientDetails = secOAuthClientDetailsDAO.findByClientId(p_UserName);
		if (securityOAuthClientDetails != null){			
			if (passwordEncoder.matches(p_Password, securityOAuthClientDetails.getClientSecret())){				
				return true;
			}else{
				return false;
			}
		}
		return false;
	}

	@Transactional
	@Override
	public boolean updatePassword(String p_UserName, String p_NewPassword) {
		try{
			SecurityOAuthClientDetails securityOAuthClientDetails = secOAuthClientDetailsDAO.findByClientId(p_UserName);
			if (securityOAuthClientDetails != null){
				securityOAuthClientDetails.setClientSecret(passwordEncoder.encode(p_NewPassword));
				secOAuthClientDetailsDAO.save(securityOAuthClientDetails);
				return true;	
			}else{
				LOGGER.error("Error update password - User not found");
				return false;	
			}			
		}catch (Exception e) {
			LOGGER.error("Error update password" + e.toString());
			return false;
		}		
	}
	
	@Override
	public SecurityOAuthClientDetails findByClientId(String p_ClientId) {
		return secOAuthClientDetailsDAO.findByClientId(p_ClientId);
	}
	
	@Override
	public void update(SecurityOAuthClientDetails p_SecurityOAuthClientDetails) {
		secOAuthClientDetailsDAO.save(p_SecurityOAuthClientDetails);
	}
}
