package id.co.tripoin.core.integration.handler;

import id.co.tripoin.constant.enums.EResponseCode;
import id.co.tripoin.core.integration.handler.base.AbstractHandler;
import id.co.tripoin.core.integration.handler.base.ILogoutContext;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class TripoinLogoutHandler extends AbstractHandler implements LogoutSuccessHandler {

	private ILogoutContext logoutContext;

	public void setLogoutContext(ILogoutContext logoutContext) {
		this.logoutContext = logoutContext;
	}

	@Override
	public EResponseCode getResponseCode() {
		return EResponseCode.RC_LOGOUT_SUCCESS;
	}

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		logoutContext.onLogoutSuccess(request);
		super.handle(response);
	}

}
