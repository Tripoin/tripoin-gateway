package id.co.tripoin.core.integration.handler;

import id.co.tripoin.core.constant.enums.EResponseCode;
import id.co.tripoin.core.integration.handler.base.AbstractHandler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class TripoinInvalidAccessHandler extends AbstractHandler implements AccessDeniedHandler {

	@Override
	public EResponseCode getResponseCode() {
		return EResponseCode.RC_ACCESS_DENIED;
	}

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
		super.handle(response);
	}

}