package id.co.tripoin.core.service;

import id.co.tripoin.core.pojo.security.I18NLocale;
import id.co.tripoin.core.service.scaffolding.IScaffoldingService;

import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface II18NLocaleService extends IScaffoldingService<I18NLocale> {

	public List<I18NLocale> getAll();
	
	public List<I18NLocale> getAllListByStatus();
	
	public Map<String, I18NLocale> getAllMapByStatus();
	
	public I18NLocale getLocaleCode(String code);

	I18NLocale findById(Long p_ID);
}
