package id.co.tripoin.core.service.impl;

import id.co.tripoin.core.constant.statics.BeanNameConstant;
import id.co.tripoin.core.dao.IProfileDao;
import id.co.tripoin.core.pojo.I18NLocale;
import id.co.tripoin.core.pojo.Profile;
import id.co.tripoin.core.service.IProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public int setProfileLocale(I18NLocale i18NLocale, String username) {
		return profileDao.setProfileLocale(i18NLocale, username);
	}	

}
