package id.co.tripoin.core.service.util.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.tripoin.constant.statics.BeanNameConstant;
import id.co.tripoin.core.dao.util.IAuthenticationDao;
import id.co.tripoin.core.pojo.SecurityUserDetails;
import id.co.tripoin.core.service.util.IAuthenticationService;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Service(BeanNameConstant.AUTHENTICATION_SERVICE_BEAN)
public class AuthenticationServiceImpl implements IAuthenticationService {
	
	@Autowired
	private IAuthenticationDao authenticationDao;

	@Override
	public SecurityUserDetails login(String username) throws Exception {
		return authenticationDao.login(username);
	}

}
