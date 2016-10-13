package id.co.tripoin.core.integration.servlet;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/**
 * <b>User Authentication Context:</b></br>
 * &emsp;&emsp;&emsp;For load current <i>Username</i></br>
 * 
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class UserAuthenticationContext {

	private static UserAuthenticationContext instance = null;
	private UserAuthenticationContext() {}

	public static UserAuthenticationContext getInstance() {
		if (instance == null) {
			instance = new UserAuthenticationContext();
		}
		return instance;
	}
	
	public String getCurrentUsername(){
		if(!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken))
			return SecurityContextHolder.getContext().getAuthentication().getName();
		return null;
	}
	
	public Authentication getAuthentication(){
		if(!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken))
			return SecurityContextHolder.getContext().getAuthentication();
		return null;
	}
	
	public static boolean hasRole(String role){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getAuthorities().contains(new SimpleGrantedAuthority(role));
    }
	
}
