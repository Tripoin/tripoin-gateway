package id.co.tripoin.core.integration.handler;

import id.co.tripoin.core.constant.enums.EResponseCode;
import id.co.tripoin.core.constant.statics.CommonConstant;
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
public class TripoinInvalidTokenHandler extends AbstractHandler implements AuthenticationEntryPoint {

	@Override
	public EResponseCode getResponseCode() {
		return EResponseCode.RC_INVALID_TOKEN;
	}

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authenticationException) throws IOException, ServletException {
		super.handle(response);
		response.setHeader(CommonConstant.WWW_AUTHANTICATE, CommonConstant.REALM_BEARER);
	}

}