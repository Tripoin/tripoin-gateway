package id.co.tripoin.core.integration.handler;

import id.co.tripoin.constant.enums.EResponseCode;
import id.co.tripoin.constant.statics.CommonConstant;
import id.co.tripoin.core.integration.handler.base.AbstractHandler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class TripoinBadCredentialsHandler extends AbstractHandler implements AuthenticationEntryPoint {

	@Override
	public EResponseCode getResponseCode() {
		return EResponseCode.RC_BAD_CREDENTIALS;
	}

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authenticationException) throws IOException, ServletException {
		response.setHeader(CommonConstant.WWW_AUTHANTICATE, CommonConstant.REALM_BASIC);
		super.handle(response);
	}

}
