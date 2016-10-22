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
		String PATH_FIND_ALL = "/100003";
		String PATH_FIND_ALL_PAGINATION = "/100031";

		String PATH_FIND_BY_ID = "/100007";

		String PATH_FIND_BY_CODE = "/100008";
		String PATH_FIND_BY_CODE_ORDER_BY_ID_ASC = "/100081";
		String PATH_FIND_BY_CODE_ORDER_BY_CODE_ASC = "/100082";
		String PATH_FIND_BY_CODE_ORDER_BY_CODE_DESC = "/100083";
		String PATH_FIND_PAGINATION_BY_CODE = "/100084";

		String PATH_FIND_BY_NAME = "/100009";
		String PATH_FIND_BY_NAME_ORDER_BY_ID_ASC = "/100091";
		String PATH_FIND_BY_CODE_ORDER_BY_NAME_ASC = "/100092";
		String PATH_FIND_BY_CODE_ORDER_BY_NAME_DESC = "/100093";
		String PATH_FIND_PAGINATION_BY_NAME = "/100094";
		String PATH_SELECT_LOV = "/100095";

		String PATH_DO_APPROVAL = "/100096";
		String PATH_DO_CANCELLATION = "/100097";
		String PATH_UPDATE = "100098";
		String PATH_INSERT = "100099";
		String PATH_INSERT_AND_FLUSH = "100010";
		String PATH_INSERT_COLLECTION = "100011";

		String PATH_DELETE = "100012";
		String PATH_DELETE_BY_ENTITY = "100013";
		String PATH_DELETE_COLLECTION = "100014";
	}

	interface ProductType {
		String PATH = "/130002";
	}

	interface ProductBrand {
		String PATH = "/130003";
	}
	
}
