package id.co.tripoin.core.integration.endpoint;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class UserAuthentication {

	private static UserAuthentication instance = null;
	private UserAuthentication() {}

	public static UserAuthentication getInstance() {
		if (instance == null) {
			instance = new UserAuthentication();
		}
		return instance;
	}
	
	public String getCurrentUsername(){
		if(!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken))
			return SecurityContextHolder.getContext().getAuthentication().getName();
		return null;
	}
	
}
