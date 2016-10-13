package id.co.tripoin.core.constant.statics;

/**
 * <b>Format:</b></br>
 * &emsp;&emsp;&emsp;ERR_* : Error</br>
 * &emsp;&emsp;&emsp;DEB_* : Debug</br>
 * &emsp;&emsp;&emsp;INF_* : Info</br>
 * &emsp;&emsp;&emsp;TRA_* : Trace</br></br> 
 * &emsp;&emsp;&emsp;{} &emsp;&emsp;: Object parameter</br> 
 * 
 * 
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public final class InfoMarkerConstant {

	public static final String ERR_SIGNATURE_UNDEFINED = "Error Header";
	public static final String ERR_SIGNATURE = "Error Header : {}";
	public static final String ERR_SIGNATURE_PARAM = "X-Tripoin Header not null";
	public static final String ERR_USER_DETAILS_SERVICE = "Error User Details Service";
	public static final String ERR_SYSTEM_PARAMETER_CONFIGURE = "System Parameter Initialized";
	public static final String ERR_I18NLOCALE_CONFIGURE = "I18N Locale Initialized";
	public static final String DEB_INITIALIZING_SERVLET = "Initializing context...";
	public static final String ERR_INITIALIZING_SERVLET = "Error Initialized Web Service Integration";
	public static final String DEB_LOCALE_RESOLVER = "Using LocaleResolver [{}]";
	public static final String DEB_LOCALE_RESOLVER_BEAN = "Unable to locate LocaleResolver with name '{}' using default [{}]";
	public static final String INF_BAD_CREDENTIAL_EXCEPTION = "No client credentials presented";
	public static final String ERR_ENDPOINT = "Error Endpoint";
	public static final String ERR_PROFILE_ENDPOINT = "Error Profile Endpoint : {}";
	public static final String ERR_MERCHANDISE_TYPE_ENDPOINT = "Error Merchandise Type Endpoint : {}"; 
	public static final String ERR_AUTHENTICATION_ENDPOINT = "Error Authentication Endpoint : {}";
	public static final String ERR_PASSWORD_NOT_VALID = "Error Password Not Valid";
	public static final String ERR_LOCALE_CODE_NULL = "Error Locale Code Not Null";
	public static final String ERR_LOCALE_NOT_FOUND = "Error Locale Not Found";
	public static final String ERR_LOGOUT = "Error on logout";

}
