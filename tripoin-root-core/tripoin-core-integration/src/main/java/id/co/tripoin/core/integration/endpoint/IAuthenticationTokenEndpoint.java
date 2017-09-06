package id.co.tripoin.core.integration.endpoint;

import id.co.tripoin.core.dto.request.AuthTokenDataRequest;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

/**
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public interface IAuthenticationTokenEndpoint {

	public ResponseEntity<?> auth(AuthTokenDataRequest authTokenDataRequest);
	
	public ResponseEntity<?> refresh(HttpServletRequest request);
	
}
