package id.co.tripoin.core.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.tripoin.constant.statics.BeanNameConstant;
import id.co.tripoin.core.dao.II18NLocaleDao;
import id.co.tripoin.core.pojo.I18NLocale;
import id.co.tripoin.core.service.II18NLocaleService;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Service(BeanNameConstant.I18NLOCALE_SERVICE_BEAN)
public class I18NLocaleServiceImpl implements II18NLocaleService {

	@Autowired
	private II18NLocaleDao i18NLocaleDao;
	
	@Override
	public List<I18NLocale> getAll() {
		return i18NLocaleDao.findAllByOrderByLanguageAsc();
	}

	@Override
	public List<I18NLocale> getAllListByStatus() {
		return i18NLocaleDao.findByStatusOrderByLanguageAsc(1);
	}

	@Override
	public Map<String, I18NLocale> getAllMapByStatus() {
		Map<String, I18NLocale> mapI18NLocale = new HashMap<String, I18NLocale>();
		for(I18NLocale i18nLocale : i18NLocaleDao.findByStatusOrderByLanguageAsc(1))
			mapI18NLocale.put(i18nLocale.getCode(), i18nLocale);
		return mapI18NLocale;
	}

	@Override
	public I18NLocale getLocaleCode(String code) {
		return i18NLocaleDao.findByCodeAndStatus(code, 1);
	}

}