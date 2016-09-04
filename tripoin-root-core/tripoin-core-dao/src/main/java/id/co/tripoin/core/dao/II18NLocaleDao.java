package id.co.tripoin.core.dao;

import java.util.List;

import id.co.tripoin.core.pojo.I18NLocale;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public interface II18NLocaleDao extends JpaRepository<I18NLocale, Long> {

	public List<I18NLocale> findAllByOrderByLanguageAsc();

	public List<I18NLocale> findByStatusOrderByLanguageAsc(Integer status);
	
	public I18NLocale findByCodeAndStatus(String code, Integer status);
	
}
