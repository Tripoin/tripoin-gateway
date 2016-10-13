package id.co.tripoin.core.integration.endpoint;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import id.co.tripoin.core.dto.request.AuthTokenDataRequest;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public interface IAuthenticationTokenEndpoint {

	public ResponseEntity<?> auth( AuthTokenDataRequest authTokenDataRequest);
	
	public ResponseEntity<?> refresh(HttpServletRequest request);
	
}
