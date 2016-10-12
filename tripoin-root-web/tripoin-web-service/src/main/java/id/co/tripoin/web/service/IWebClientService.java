package id.co.tripoin.web.service;

import id.co.tripoin.web.constant.enums.EHTTPMethod;
import id.co.tripoin.web.dto.TokenData;

import java.util.Map;

import javax.ws.rs.core.MultivaluedMap;

import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.security.core.Authentication;


/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public interface IWebClientService {

	public <T> T execute(String path, EHTTPMethod httpMethod, Object body, Class<T> responseClass, MultivaluedMap<String, String> headers) throws Exception;
	
	public WebClient getWebClient();
	
	public Map<String, String> getCookies();
	
	public void setCookies(Map<String, String> cookies);
	
	public void clearCookies();
	
	public void updateAuthentication(Authentication authentication, TokenData tokenData);
	
	public void updateAuthentication(String authentication, TokenData tokenData);
	
	public TokenData loadAuthentication(Authentication authentication);
	
	public void clearAuthentication();
	
	public void clearAll();
	
}
