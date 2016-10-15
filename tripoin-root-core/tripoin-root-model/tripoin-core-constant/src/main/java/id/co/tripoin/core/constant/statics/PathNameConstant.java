package id.co.tripoin.core.constant.statics;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public interface PathNameConstant {

	String PATH_OAUTH_TOKEN = "/oauth/token";
	String PATH_PROFILE = "/profile";
	String PATH_CHANGE = "/change";
	String PATH_LOCALE = "/locale";
	String PARAM_API_TYPE_CODE = "apiTypeCode";
	String PATH_API_TYPE_CODE = "{"+PARAM_API_TYPE_CODE+"}";
	String PATH_AUTH = "/auth";
	String PATH_REFRESH = "/refresh";

	interface PathScaffolding{
		String PATH_SELECT_ALL = "/100003";
		String PATH_SELECT_ALL_PAGINATION = "/100004";

		String PATH_FIND_BY_ID = "/100007";

		String PATH_FIND_BY_CODE = "/100008";
		String PATH_FIND_BY_CODE_ORDER_BY_ID_ASC = "/100009";
		String PATH_FIND_BY_CODE_ORDER_BY_CODE_ASC = "/100010";
		String PATH_FIND_BY_CODE_ORDER_BY_CODE_DESC = "/100010";
		String PATH_FIND_PAGINATION_BY_CODE = "/100011";

		String PATH_FIND_BY_NAME = "/100012";
		String PATH_FIND_BY_NAME_ORDER_BY_ID_ASC = "/100013";
		String PATH_FIND_BY_CODE_ORDER_BY_NAME_ASC = "/100014";
		String PATH_FIND_PAGINATION_BY_NAME = "/100015";
	}
	
}
