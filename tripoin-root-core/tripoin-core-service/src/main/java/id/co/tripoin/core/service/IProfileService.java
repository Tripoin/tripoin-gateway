package id.co.tripoin.core.service;

import id.co.tripoin.core.pojo.Profile;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public interface IProfileService {

	public Profile findByEmail(String email);
	
	public Profile findByPhone(String phone);
	
	public Profile findByUsername(String username);
	
}
