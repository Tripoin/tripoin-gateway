package id.co.tripoin.web.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.springframework.security.core.Authentication;

import id.co.tripoin.web.constant.enums.EHTTPMethod;
import id.co.tripoin.web.constant.statics.CommonConstant;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public abstract class AWebClientService implements IWebClientService {
	
	private Map<String, String> cookies = new ConcurrentHashMap<String, String>();	
	private Map<String, Object> authentication = new ConcurrentHashMap<String, Object>();

	@Override
	public Map<String, String> getCookies() {
		return this.cookies;
	}

	@Override
	public void setCookies(Map<String, String> cookies) {
		this.cookies = cookies;
	}

	@Override
	public void clearCookies() {
		this.cookies.clear();
	}
	
	@Override
	public void updateAuthentication(Authentication authentication, Object data) {
		this.authentication.put(authentication.getName(), data);
	}
	
	@Override
	public void updateAuthentication(String authentication, Object data) {
		this.authentication.put(authentication, data);
	}
	
	@Override
	public Object loadAuthentication(Authentication authentication) {
		return this.authentication.get(authentication.getName());
	}

	@Override
	public void clearAuthentication() {
		this.authentication.clear();
	}
	
	@Override
	public void clearAll() {
		this.clearCookies();
		this.clearAuthentication();
	}
	
	@Override
	public <T> T execute(String path, EHTTPMethod httpMethod, Object body, Class<T> responseClass, MultivaluedMap<String, String> headers) throws Exception {
		getWebClient().path(path);
		if(headers != null)
			getWebClient().headers(headers);
		Response response = getWebClient().invoke(httpMethod.toString(), body);
		if(response.getStatus() == 200 && response.getHeaderString(CommonConstant.SET_COOKIE) != null)
			extractCookies(response.getHeaderString(CommonConstant.SET_COOKIE));
		return response.readEntity(responseClass);
	}
	
	protected void extractCookies(String headers) {
		if (headers != null && !headers.isEmpty()) {
			String[] cookiesSplit = headers.split(";");
			for (String cookieStr : cookiesSplit) {
				String[] keyValueSplit = cookieStr.split("=");
				if(CommonConstant.JSESSIONID.equalsIgnoreCase(keyValueSplit[0]))
					cookies.put(keyValueSplit[0], keyValueSplit[1]);
			}
		}
	}
		
}
