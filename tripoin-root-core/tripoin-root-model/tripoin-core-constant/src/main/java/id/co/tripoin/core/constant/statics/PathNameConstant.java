package id.co.tripoin.core.constant.statics;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public interface PathNameConstant {

	String PATH_OAUTH_TOKEN = "/oauth/token";
	String PATH_PROFILE = "/profile";
	String PATH_CHANGE = "/100005";
	String PATH_LOGOUT = "/100002";
	String PATH_LOCALE = "/locale";
	String PARAM_API_TYPE_CODE = "apiTypeCode";
	String PATH_API_TYPE_CODE = "{"+PARAM_API_TYPE_CODE+"}";
	String PATH_AUTH = "/100001";
	String PATH_REFRESH = "/100004";
	String PATH_ADMIN_MENU_GENERATOR = "/100003";

	interface PathScaffolding{
		String PATH_FIND_ALL = "/100004";
		String PATH_FIND_ALL_PAGINATION = "/100005";

		String PATH_FIND_BY_ID = "/100006";

		String PATH_FIND_BY_CODE = "/100007";
		String PATH_FIND_BY_CODE_ORDER_BY_ID_ASC = "/100008";
		String PATH_FIND_BY_CODE_ORDER_BY_CODE_ASC = "/100009";
		String PATH_FIND_BY_CODE_ORDER_BY_CODE_DESC = "/100010";
		String PATH_FIND_PAGINATION_BY_CODE = "/100011";

		String PATH_FIND_BY_NAME = "/100012";
		String PATH_FIND_BY_NAME_ORDER_BY_ID_ASC = "/100013";
		String PATH_FIND_BY_CODE_ORDER_BY_NAME_ASC = "/100014";
		String PATH_FIND_BY_CODE_ORDER_BY_NAME_DESC = "/100015";
		String PATH_FIND_PAGINATION_BY_NAME = "/100016";
		String PATH_SELECT_LOV = "/100017";

		String PATH_APPROVE_ALL = "/100018";
		String PATH_APPROVE_SINGLE_DATA = "/100019";
		String PATH_CANCEL_ALL = "/100020";
		String PATH_CANCEL_SINGLE_DATA = "/100021";
		String PATH_UPDATE = "100022";
		String PATH_INSERT = "100023";
		String PATH_INSERT_AND_FLUSH = "100024";
		String PATH_INSERT_COLLECTION = "100025";

		String PATH_DELETE = "100026";
		String PATH_DELETE_BY_ENTITY = "100027";
		String PATH_DELETE_COLLECTION = "100028";
		String PATH_DELETE_COLLECTION_BY_ID = "100029";

		String PATH_ADVANCED_PAGINATION = "100030";
	}

	interface Security{
		String PATH_COMPANY = "/190001";
		String PATH_BRANCH = "/190002";
		String PATH_ROLE = "/190003";
		String PATH_GROUP = "/190006";
		String PATH_FUNCTION = "/190004";
		String PATH_FUNCTION_ASSIGNMENT = "/190005";
		String PATH_PROFILE = "/190010";
		String PATH_GET_PROFILE = "/191001";
		String PATH_UPDATE_PROFILE = "/191002";
		String PATH_UPDATE_PASSWORD = "/191003";
		String PATH_FORGOT_PASSWORD = "/191004";
		String PATH_RESET_PASSWORD = "/191005";
	}

	interface MidTrans{
		String SANDBOX = "https://app.sandbox.midtrans.com/snap/v2/transactions";
		String PRODUCTION = "https://app.midtrans.com/snap/v1/transactions";
	}

	interface BaseMaster{
		String API_TYPE = "/130001";
	}

	interface ProductType {
		String PATH = "/130002";
	}

	interface ProductBrand {
		String PATH = "/130003";
	}
	
}
