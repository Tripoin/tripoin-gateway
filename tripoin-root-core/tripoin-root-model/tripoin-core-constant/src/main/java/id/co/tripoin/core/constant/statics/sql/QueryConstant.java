package id.co.tripoin.core.constant.statics.sql;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public interface QueryConstant {
	String SYS_PARAM_LOAD_VALUE = "SELECT * FROM sys_parameter WHERE code = ?";
	String SYS_PARAM_LIST_VALUE = "SELECT * FROM sys_parameter WHERE code = ? OR code = ?";
	String SYS_PARAM_ALL = "SELECT * FROM sys_parameter";
	String LOGIN = "SELECT "
			+ "ocd.client_id, ocd.client_secret, sud.user_enabled, "
			+ "sud.user_expired_date, sud.user_credentials_expired_date, sud.user_non_locked, sr.code "
			+ "FROM sec_user_details sud "
			+ "JOIN sec_oauth_client_details ocd ON sud.client_id = ocd.client_id "
			+ "JOIN sec_role sr ON sud.role_id = sr.id "
			+ "JOIN sec_user_profile mp ON mp.user_id = sud.user_id "
			+ "JOIN sec_contact sc ON sc.id = mp.contact_id "
			+ "WHERE ocd.client_id = ? OR sc.email = ? OR sc.phone_number_1 = ?";
	String AUTHENTICATION_CHANGE = "UPDATE oauth_client_details "
			+ "SET client_secret = ? WHERE client_id = ?";
	String SELECT_PROFILE_USERNAME_OR_EMAIL = "SELECT p FROM SecurityUserProfile p WHERE p.user.username = :username or p.contact.email = :email";
	String UPDATE_LOCALE_PROFILE = "UPDATE SecurityUserProfile SET i18NLocale = "
			+ ":"+FieldConstant.FIELD_I18NLOCALE+" WHERE user = "
			+ "(SELECT u FROM User u WHERE u.username = "
			+ ":"+FieldConstant.FIELD_USERNAME+")";

	String SELECT_LOV = "SELECT id, name FROM #{#entityName}";
	String COUNT_ENTITY_SIZE = "SELECT COUNT(a) FROM #{#entityName} a";
	String COUNT_ENTITY_SIZE_BY_STATUS = "SELECT COUNT(a) FROM #{#entityName} a where a.status = ?1";
	String COUNT_ENTITY_SIZE_BY_CODE = "SELECT COUNT(a) FROM #{#entityName} a where a.code LIKE %?1%";
	String COUNT_ENTITY_SIZE_BY_CODE_AND_STATUS = "SELECT COUNT(a) FROM #{#entityName} a where a.code LIKE %?1% and a.status = ?2";
	String COUNT_ENTITY_SIZE_BY_NAME = "SELECT COUNT(a) FROM #{#entityName} a where a.name LIKE %?1%";
	String COUNT_ENTITY_SIZE_BY_NAME_AND_STATUS = "SELECT COUNT(a) FROM #{#entityName} a where a.name LIKE %?1% and a.status = ?2";
	String ADVANCED_PAGINATION = "SELECT a FROM #{#entityName} a WHERE a.?1 = ?2";
	int STATUS_APPROVED = 1;
	int STATUS_CANCELLED = 0;
	String ASCENDING = "asc";
	String DESCENDING = "desc";
}
