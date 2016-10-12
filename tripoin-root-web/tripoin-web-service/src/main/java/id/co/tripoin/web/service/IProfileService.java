package id.co.tripoin.web.service;

import id.co.tripoin.web.dto.response.ProfileDataResponse;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public interface IProfileService {
	
	public ProfileDataResponse me() throws Exception;

}
