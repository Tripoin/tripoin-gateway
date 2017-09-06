package id.co.tripoin.core.dao.security;

import id.co.tripoin.core.constant.statics.sql.FieldConstant;
import id.co.tripoin.core.constant.statics.sql.QueryConstant;
import id.co.tripoin.core.dao.scaffolding.IScaffoldingDAO;
import id.co.tripoin.core.pojo.security.I18NLocale;
import id.co.tripoin.core.pojo.security.SecurityUserContact;
import id.co.tripoin.core.pojo.security.SecurityUserProfile;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ISecurityUserProfileDao extends IScaffoldingDAO<SecurityUserProfile> {

	/*Query("SELECT a FROM SecurityUserProfile a WHERE a.id = ?1")*/
	SecurityUserProfile findById(Long p_ID);

	@Query("SELECT a FROM SecurityUserProfile a JOIN a.contact b where b.email = ?1")
	SecurityUserProfile findByEmail(String p_Email);

	@Query("SELECT a FROM SecurityUserProfile a JOIN a.contact b where b.phoneNumber1 = ?1 or b.phoneNumber2 = ?2")
	SecurityUserProfile findByPhone(String p_Phone);

	@Query(value = QueryConstant.SELECT_PROFILE_USERNAME_OR_EMAIL)
	public SecurityUserProfile findByUsernameOrEmail(@Param(value = FieldConstant.FIELD_USERNAME) String username, @Param(value = FieldConstant.FIELD_EMAIL) String p_Email);
	
	@Modifying
	@Transactional
	@Query(value = QueryConstant.UPDATE_LOCALE_PROFILE)
	public int setProfileLocale(@Param(value = FieldConstant.FIELD_I18NLOCALE) I18NLocale i18NLocale,
								@Param(value = FieldConstant.FIELD_USERNAME) String username);

	SecurityUserProfile findByContact(SecurityUserContact p_SecurityUserContact);
		
}
