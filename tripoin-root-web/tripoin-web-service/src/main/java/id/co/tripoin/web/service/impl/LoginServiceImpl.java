package id.co.tripoin.web.service.impl;

import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

import id.co.tripoin.web.constant.statics.BeanNameConstant;
import id.co.tripoin.web.constant.statics.PathNameConstant;
import id.co.tripoin.web.dto.response.ProfileDataResponse;
import id.co.tripoin.web.service.AOauthService;
import id.co.tripoin.web.service.ILoginService;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Service(BeanNameConstant.LOGIN_SERVICE_BEAN)
public class LoginServiceImpl extends AOauthService implements ILoginService {

	@Override
	public ProfileDataResponse loginMe(String username, String password) throws Exception {
		this.login(username, password);
		return this.get(PathNameConstant.PATH_PROFILE, ProfileDataResponse.class, MediaType.APPLICATION_JSON_TYPE, MediaType.APPLICATION_JSON_TYPE);
	}

}
