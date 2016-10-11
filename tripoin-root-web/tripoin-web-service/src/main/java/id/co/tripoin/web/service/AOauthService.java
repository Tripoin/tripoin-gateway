package id.co.tripoin.web.service;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.apache.cxf.common.util.Base64Utility;
import org.apache.cxf.jaxrs.impl.MetadataMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import id.co.tripoin.web.constant.enums.EHTTPMethod;
import id.co.tripoin.web.constant.enums.EResponseCode;
import id.co.tripoin.web.constant.statics.CommonConstant;
import id.co.tripoin.web.constant.statics.PathNameConstant;
import id.co.tripoin.web.dto.TokenData;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public abstract class AOauthService {
	
	@Autowired
	private IWebClientService webClientService;
	
	private MultivaluedMap<String, String> headers;

	public <T> T execute(String path, EHTTPMethod httpMethod, Object body, Class<T> responseClass, MultivaluedMap<String, String> headers) throws Exception {
		TokenData tokenData = this.webClientService.loadAuthentication(SecurityContextHolder.getContext().getAuthentication());
		headers.putSingle(CommonConstant.AUTHORIZATION, CommonConstant.BEARER_PREFIX+tokenData.getAccessToken());
		Response response = this.webClientService.execute(path, httpMethod, body, Response.class, headers);
		if(response.getStatus() == EResponseCode.RC_ACCESS_DENIED.getHttpResponse()){
			tokenData = this.reLogin();
			headers = new MetadataMap<String, String>();
			headers.putSingle(CommonConstant.AUTHORIZATION, CommonConstant.BEARER_PREFIX+tokenData.getAccessToken());
			response = this.webClientService.execute(path, httpMethod, body, Response.class, headers);
		}
		return response.readEntity(responseClass);
	}
	
	public <T> T post(String path, Object body, Class<T> responseClass, MediaType accept, MediaType content) throws Exception {
		this.headers = new MetadataMap<String, String>();
		if(accept != null)
			this.headers.putSingle(HttpHeaders.ACCEPT, accept.getType());
		if(content != null)
			this.headers.putSingle(HttpHeaders.CONTENT_TYPE, content.getType());
		return execute(path, EHTTPMethod.POST, body, responseClass, this.headers);
	}
	
	public <T> T get(String path, Class<T> responseClass, MediaType accept, MediaType content) throws Exception {
		this.headers = new MetadataMap<String, String>();
		if(accept != null)
			this.headers.putSingle(HttpHeaders.ACCEPT, accept.getType());
		if(content != null)
			this.headers.putSingle(HttpHeaders.CONTENT_TYPE, content.getType());
		return execute(path, EHTTPMethod.GET, null, responseClass, this.headers);
	}
	
	public <T> T put(String path, Object body, Class<T> responseClass, MediaType accept, MediaType content) throws Exception {
		this.headers = new MetadataMap<String, String>();
		if(accept != null)
			this.headers.putSingle(HttpHeaders.ACCEPT, accept.getType());
		if(content != null)
			this.headers.putSingle(HttpHeaders.CONTENT_TYPE, content.getType());
		return execute(path, EHTTPMethod.PUT, body, responseClass, this.headers);
	}
	
	public <T> T delete(String path, Class<T> responseClass, MediaType accept, MediaType content) throws Exception {
		this.headers = new MetadataMap<String, String>();
		if(accept != null)
			this.headers.putSingle(HttpHeaders.ACCEPT, accept.getType());
		if(content != null)
			this.headers.putSingle(HttpHeaders.CONTENT_TYPE, content.getType());
		return execute(path, EHTTPMethod.DELETE, null, responseClass, this.headers);
	}
	
	public TokenData login(String username, String password) throws Exception {
		this.headers = new MetadataMap<String, String>();
		this.headers.putSingle(CommonConstant.AUTHORIZATION, CommonConstant.BASIC_PREFIX.concat(Base64Utility.encode((username+":"+password).getBytes())));
		this.headers.putSingle(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON);
		this.headers.putSingle(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED);
		Response response  = this.webClientService.execute(PathNameConstant.PATH_OAUTH_TOKEN, EHTTPMethod.POST, CommonConstant.GRANT_TYPE_CREDENTIALS, Response.class, this.headers);
		TokenData tokenData = response.readEntity(TokenData.class);
		if(response.getStatus() == 200)
			this.webClientService.updateAuthentication(username, tokenData);		
		return tokenData;
	}
	
	public TokenData reLogin() throws Exception {
		this.headers = new MetadataMap<String, String>();
		this.headers.putSingle(CommonConstant.COOKIE, this.webClientService.getCookies().get(CommonConstant.SET_COOKIE));
		this.headers.putSingle(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON);
		this.headers.putSingle(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED);
		Response response  = this.webClientService.execute(PathNameConstant.PATH_OAUTH_TOKEN, EHTTPMethod.POST, CommonConstant.GRANT_TYPE_CREDENTIALS, Response.class, this.headers);
		TokenData tokenData = response.readEntity(TokenData.class);
		if(response.getStatus() == 200)
			this.webClientService.updateAuthentication(SecurityContextHolder.getContext().getAuthentication(), tokenData);		
		return tokenData;
	}
	
	protected void clearSession() {
		this.webClientService.clearAll();
	}

}