package id.co.tripoin.web.constant.statics;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public final class PathNameConstant {

	public static final String PATH_ROOT = "/";
	public static final String PATH_OAUTH = "/oauth";
	public static final String PATH_TOKEN = "/token";
	public static final String PATH_OAUTH_TOKEN = "/oauth/token";
	public static final String PATH_PROFILE = "/me";
	public static final String PATH_ROOT_API = "/api";
	public static final String PATH_CONNECTION = "/connection";
	public static final String PATH_CHANGE = "/change";
	public static final String PATH_AUTHENTICATION_CHANGE = "/authentication"+PATH_CHANGE;
	public static final String PATH_LOCALE = "/locale";
	public static final String PATH_LOCALE_CHANGE = PATH_PROFILE+PATH_LOCALE+"/change";
	public static final String PARAM_API_TYPE_CODE = "apiTypeCode";
	public static final String PATH_API_TYPE_CODE = PATH_ROOT_API+"/type{"+PARAM_API_TYPE_CODE+"}";
	public static final String PATH_HOME_PAGE = "redirect:/laris/";
	public static final String PATH_LOGIN_PAGE = "/login";
	
}
