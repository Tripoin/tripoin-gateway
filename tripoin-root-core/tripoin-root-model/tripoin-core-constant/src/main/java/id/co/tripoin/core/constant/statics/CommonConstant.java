package id.co.tripoin.core.constant.statics;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public final class CommonConstant {

	public static final String AUTHORIZATION = "Authorization";
	public static final String BEARER_PREFIX = "Bearer ";
	public static final String BASIC_PREFIX = "Basic ";
	public static final String REALM_PREFIX = "realm=";
	public static final String REALM_BASIC = BASIC_PREFIX.concat(REALM_PREFIX).concat("\"Authorization/client\"");
	public static final String REALM_BEARER = BEARER_PREFIX.concat(REALM_PREFIX).concat("\"oauth\"");
	public static final String WWW_AUTHANTICATE = "WWW-Authenticate";
	public static final String METHOD_POST = "POST";
	public static final String CLIENT_IDENTIFIER = "client_id";
	public static final String CLIENT_SECRET = "client_secret";
	public static final String HTTP_REQUEST = "HTTP.REQUEST";
	public static final String ACCESS_TOKEN = "access_token";
	
}
