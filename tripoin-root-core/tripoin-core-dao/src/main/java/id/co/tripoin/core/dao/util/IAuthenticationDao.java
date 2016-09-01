package id.co.tripoin.core.dao.util;

import id.co.tripoin.core.pojo.SecurityUserDetails;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public interface IAuthenticationDao {

	public SecurityUserDetails login(String username) throws Exception;
	
}
