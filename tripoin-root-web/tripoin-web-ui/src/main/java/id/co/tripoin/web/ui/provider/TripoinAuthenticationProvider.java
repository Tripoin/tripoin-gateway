package id.co.tripoin.web.ui.provider;

import java.util.ArrayList;
import java.util.List;

import id.co.tripoin.web.constant.statics.InfoMarkerConstant;
import id.co.tripoin.web.dto.response.ProfileDataResponse;
import id.co.tripoin.web.service.ILoginService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class TripoinAuthenticationProvider implements AuthenticationProvider {
	
	private static Logger LOGGER = LoggerFactory.getLogger(TripoinAuthenticationProvider.class);
	
	@Autowired
	private ILoginService loginService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		try {
			ProfileDataResponse profileDataResponse = loginService.loginMe(username, password);
			if(profileDataResponse == null)
				throw new Exception();
			List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
			grantedAuths.add(new SimpleGrantedAuthority(profileDataResponse.getAuthority().getCode()));
            Authentication auth = new UsernamePasswordAuthenticationToken(username, password, grantedAuths);
            LOGGER.debug(InfoMarkerConstant.DEB_AUTH_PROVIDER, username);
            return auth;
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
