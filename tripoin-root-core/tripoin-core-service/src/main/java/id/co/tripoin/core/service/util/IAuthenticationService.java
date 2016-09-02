package id.co.tripoin.core.service.util;

import id.co.tripoin.core.pojo.SecurityUserDetails;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public interface IAuthenticationService {

	public SecurityUserDetails login(String username) throws Exception;
	
	public int change(String username, String secret) throws Exception;
	
}
