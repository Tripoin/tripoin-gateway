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
public interface InfoMarkerConstant {

	String ERR_SIGNATURE = "Error Header";
	String ERR_USER_DETAILS_SERVICE = "Error User Details Service";
	String ERR_SYSTEM_PARAMETER_CONFIGURE = "System Parameter Initialized";
	String ERR_I18NLOCALE_CONFIGURE = "I18N Locale Initialized";
	String DEB_INITIALIZING_SERVLET = "Initializing context...";
	String ERR_INITIALIZING_SERVLET = "Error Initialized Web Service Integration";
	String DEB_LOCALE_RESOLVER = "Using LocaleResolver [{}]";
	String DEB_LOCALE_RESOLVER_BEAN = "Unable to locate LocaleResolver with name '{}' using default [{}]";
	String INF_BAD_CREDENTIAL_EXCEPTION = "No client credentials presented";
	String ERR_ENDPOINT = "Error Endpoint";
	String ERR_PROFILE_ENDPOINT = "Error Profile Endpoint : {}";
	String ERR_MERCHANDISE_TYPE_ENDPOINT = "Error Merchandise Type Endpoint : "; 
	String ERR_AUTHENTICATION_ENDPOINT = "Error Authentication Endpoint : {}";
	String ERR_PASSWORD_NOT_VALID = "Error Password Not Valid";
	String ERR_LOCALE_CODE_NULL = "Error Locale Code Not Null";
	String ERR_LOCALE_NOT_FOUND = "Error Locale Not Found";
	String ERR_LOGOUT = "Error on logout";

	String INFO_DATA_NOT_FOUND = "Info Data not Found";
}
