package id.co.tripoin.core.constant.statics.sql;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public final class QueryConstant {

	public static final String SYS_PARAM_LOAD_VALUE = "SELECT * FROM sys_system_parameter WHERE system_parameter_code = ?";
	public static final String SYS_PARAM_LIST_VALUE = "SELECT * FROM sys_system_parameter WHERE system_parameter_code = ? OR system_parameter_code = ?";
	public static final String SYS_PARAM_ALL = "SELECT * FROM sys_system_parameter";
	public static final String LOGIN = "SELECT "
			+ "ocd.client_id, ocd.client_secret, sud.user_enabled, "
			+ "sud.user_expired_date, sud.user_credentials_expired_date, sud.user_non_locked, sr.role_code "
			+ "FROM sec_user_details sud "
			+ "JOIN oauth_client_details ocd ON sud.client_id = ocd.client_id "
			+ "JOIN sec_role sr ON sud.role_id = sr.role_id "
			+ "JOIN mst_profile mp ON mp.user_id = sud.user_id "
			+ "WHERE ocd.client_id = ? OR mp.profile_email = ? OR mp.profile_phone = ?";
	public static final String AUTHENTICATION_CHANGE = "UPDATE oauth_client_details "
			+ "SET client_secret = ? WHERE client_id = ?";
	public static final String SELECT_PROFILE_USERNAME = "SELECT p FROM Profile p WHERE p.user.username = :username";
	public static final String UPDATE_LOCALE_PROFILE = "UPDATE Profile SET i18NLocale = "
			+ ":"+FieldConstant.FIELD_I18NLOCALE+" WHERE user = "
			+ "(SELECT u FROM User u WHERE u.username = "
			+ ":"+FieldConstant.FIELD_USERNAME+")";

}
