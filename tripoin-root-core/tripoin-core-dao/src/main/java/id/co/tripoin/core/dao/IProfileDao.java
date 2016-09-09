package id.co.tripoin.core.dao;

import id.co.tripoin.core.constant.statics.sql.FieldConstant;
import id.co.tripoin.core.constant.statics.sql.QueryConstant;
import id.co.tripoin.core.pojo.I18NLocale;
import id.co.tripoin.core.pojo.Profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public interface IProfileDao extends JpaRepository<Profile, Long> {

	public Profile findByEmail(String email);
	
	public Profile findByPhone(String phone);
	
	@Query(value = QueryConstant.SELECT_PROFILE_USERNAME)
	public Profile findByUsername(@Param(value = FieldConstant.FIELD_USERNAME)String username);
	
	@Modifying
	@Transactional
	@Query(value = QueryConstant.UPDATE_LOCALE_PROFILE)
	public int setProfileLocale(@Param(value = FieldConstant.FIELD_I18NLOCALE)I18NLocale i18NLocale, 
			@Param(value = FieldConstant.FIELD_USERNAME)String username);

}
