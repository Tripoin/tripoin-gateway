package id.co.tripoin.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.tripoin.constant.statics.BeanNameConstant;
import id.co.tripoin.core.dao.IProfileDao;
import id.co.tripoin.core.pojo.Profile;
import id.co.tripoin.core.service.IProfileService;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Service(BeanNameConstant.PROFILE_SERVICE_BEAN)
public class ProfileServiceImpl implements IProfileService {
	
	@Autowired
	private IProfileDao profileDao;

	@Override
	public Profile findByEmail(String email) {
		return profileDao.findByEmail(email);
	}

	@Override
	public Profile findByPhone(String phone) {
		return profileDao.findByPhone(phone);
	}

	@Override
	public Profile findByUsername(String username) {
		return profileDao.findByUsername(username);
	}	

}
