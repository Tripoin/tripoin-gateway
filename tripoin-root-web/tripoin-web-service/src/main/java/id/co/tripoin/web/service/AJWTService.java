package id.co.tripoin.web.service;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.impl.MetadataMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import id.co.tripoin.web.constant.enums.EHTTPMethod;
import id.co.tripoin.web.constant.statics.CommonConstant;
import id.co.tripoin.web.constant.statics.PathNameConstant;
import id.co.tripoin.web.dto.request.AuthTokenDataRequest;
import id.co.tripoin.web.dto.response.AuthTokenDataResponse;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public abstract class AJWTService {
	
	@Autowired
	private IWebClientService webClientService;
	
	private MultivaluedMap<String, String> headers;

	public <T> T execute(String path, EHTTPMethod httpMethod, Object body, Class<T> responseClass, MultivaluedMap<String, String> headers) throws Exception {
		AuthTokenDataResponse tokenData = (AuthTokenDataResponse)this.webClientService.loadAuthentication(SecurityContextHolder.getContext().getAuthentication());
		headers.putSingle(CommonConstant.X_AUTH_TOKEN, tokenData.getToken());
		Response response = this.webClientService.execute(path, httpMethod, body, Response.class, headers);
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
	
	public AuthTokenDataResponse login(String username, String password) throws Exception {
		AuthTokenDataRequest authTokenDataRequest = new AuthTokenDataRequest();
		authTokenDataRequest.setUsername(username);
		authTokenDataRequest.setPassword(password);
		this.headers = new MetadataMap<String, String>();
		this.headers.putSingle(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON);
		this.headers.putSingle(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
		AuthTokenDataResponse tokenData  = this.webClientService.execute(PathNameConstant.PATH_JWT_AUTH, EHTTPMethod.POST, authTokenDataRequest, AuthTokenDataResponse.class, this.headers);
		this.webClientService.updateAuthentication(username, tokenData);		
		return tokenData;
	}
	
	public AuthTokenDataResponse refresh() throws Exception {
		AuthTokenDataResponse tokenData = (AuthTokenDataResponse)this.webClientService.loadAuthentication(SecurityContextHolder.getContext().getAuthentication());
		this.headers = new MetadataMap<String, String>();
		this.headers.putSingle(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON);
		this.headers.putSingle(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
		headers.putSingle(CommonConstant.X_AUTH_TOKEN, tokenData.getToken());
		Response response  = this.webClientService.execute(PathNameConstant.PATH_JWT_REFRESH, EHTTPMethod.GET, null, Response.class, this.headers);
		AuthTokenDataResponse tokenDataResponse = response.readEntity(AuthTokenDataResponse.class);
		if(response.getStatus() == 200)
			this.webClientService.updateAuthentication(SecurityContextHolder.getContext().getAuthentication(), tokenData);		
		return tokenDataResponse;
	}
	
	protected void clearSession() {
		this.webClientService.clearAll();
	}
	
}
