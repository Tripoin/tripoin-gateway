package id.co.tripoin.core.service;

import java.util.List;
import java.util.Map;

import id.co.tripoin.core.pojo.I18NLocale;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public interface II18NLocaleService {

	public List<I18NLocale> getAll();
	
	public List<I18NLocale> getAllListByStatus();
	
	public Map<String, I18NLocale> getAllMapByStatus();
	
	public I18NLocale getLocaleCode(String code);

}
