package id.co.tripoin.constant.statics;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public final class CommonConstant {

	public static final String AUTHORIZATION = "Authorization";
	public static final String BEARER = "Bearer ";
	public static final String BASIC = "Basic ";
	public static final String REALM = "realm=";
	public static final String REALM_BASIC = BASIC.concat(REALM).concat("\"Authorization/client\"");
	public static final String REALM_BEARER = BEARER.concat(REALM).concat("\"oauth\"");
	public static final String WWW_AUTHANTICATE = "WWW-Authenticate";
	public static final String CONTENT_TYPE = "Content-Type";
	public static final String METHOD_POST = "POST";
	public static final String CLIENT_IDENTIFIER = "client_id";
	public static final String CLIENT_SECRET = "client_secret";
	
}
