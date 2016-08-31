package id.co.tripoin.core.integration.handler;

import id.co.tripoin.constant.enums.EResponseCode;
import id.co.tripoin.constant.statics.CommonConstant;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class TripoinLogoutHandler extends AbstractHandler implements LogoutSuccessHandler {
	
	private static Logger LOGGER = LoggerFactory.getLogger(TripoinLogoutHandler.class);	
	private JdbcTokenStore tokenStore;

	public void setTokenStore(JdbcTokenStore tokenStore) {
		this.tokenStore = tokenStore;
	}

	@Override
	public EResponseCode getResponseCode() {
		return EResponseCode.RC_LOGOUT_SUCCESS;
	}

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		String tokenValue = request.getHeader(CommonConstant.AUTHORIZATION).replace(CommonConstant.BEARER, "");
		tokenStore.removeAccessToken(tokenValue);
		try {
			authentication = null;
			SecurityContextHolder.clearContext();
		} catch (Exception e) {
			LOGGER.error("Error on logout", e);
		}
		super.handle(response);
	}

}
