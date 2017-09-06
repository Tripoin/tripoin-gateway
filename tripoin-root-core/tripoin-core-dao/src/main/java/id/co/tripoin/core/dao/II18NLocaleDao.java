package id.co.tripoin.core.dao;

import id.co.tripoin.core.dao.scaffolding.IScaffoldingDAO;
import id.co.tripoin.core.pojo.security.I18NLocale;

import java.util.List;

/**
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public interface II18NLocaleDao extends IScaffoldingDAO<I18NLocale> {

	public List<I18NLocale> findAllByOrderByNameAsc();

	public List<I18NLocale> findByStatusOrderByNameAsc(Integer status);
	
	public I18NLocale findByCodeAndStatus(String code, Integer status);
	
}
