package id.co.tripoin.core.integration.security;

import id.co.tripoin.core.pojo.SecurityUserDetails;
import id.co.tripoin.core.service.util.IAuthenticationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class TripoinUserDetailsService implements UserDetailsService {

	private static Logger LOGGER = LoggerFactory.getLogger(TripoinUserDetailsService.class);	
	private String emptyPassword = "";
	
	@Autowired
	private IAuthenticationService authenticationService;

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.emptyPassword = passwordEncoder.encode("");
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SecurityUserDetails securityUserDetails = null;
		try {
			securityUserDetails = authenticationService.login(username);
		} catch (Exception e) {
			LOGGER.error("Error User Details Service",e);
			throw new UsernameNotFoundException(username);
		}		
		if(securityUserDetails != null){
			String clientSecret = securityUserDetails.getPassword();
			if ((clientSecret == null) || (clientSecret.trim().length() == 0)) {
				clientSecret = this.emptyPassword;
			}
			return new User(username, clientSecret,
					securityUserDetails.isEnabled(),
					securityUserDetails.isAccountNonExpired(),
					securityUserDetails.isCredentialsNonExpired(),
					securityUserDetails.isAccountNonLocked(),
					securityUserDetails.getAuthorities());
		}
		return null;
	}

}
