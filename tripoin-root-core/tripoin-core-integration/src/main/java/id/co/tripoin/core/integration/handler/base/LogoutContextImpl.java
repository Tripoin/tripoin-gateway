package id.co.tripoin.core.integration.handler.base;

import id.co.tripoin.constant.statics.CommonConstant;
import id.co.tripoin.constant.statics.InfoMarkerConstant;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.cxf.phase.PhaseInterceptorChain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class LogoutContextImpl implements ILogoutContext {
	
	private static Logger LOGGER = LoggerFactory.getLogger(LogoutContextImpl.class);
	
	private JdbcTokenStore tokenStore;	
	private HttpServletRequest request;

	public void setTokenStore(JdbcTokenStore tokenStore) {
		this.tokenStore = tokenStore;
	}
	
	@Override
	public void onLogoutSuccess(HttpServletRequest request) throws IOException, ServletException {
		this.setRequest(request);
		this.onLogoutSuccess();
	}
	
	@Override
	public void onLogoutSuccess() throws IOException, ServletException {
		if(this.request == null)
			this.setRequest((HttpServletRequest)PhaseInterceptorChain.getCurrentMessage().get(CommonConstant.HTTP_REQUEST));
		String tokenValue = this.request.getHeader(CommonConstant.AUTHORIZATION).replace(CommonConstant.BEARER, "");
		tokenStore.removeAccessToken(tokenValue);
		try {
			SecurityContextHolder.clearContext();
		} catch (Exception e) {
			LOGGER.error(InfoMarkerConstant.ERR_LOGOUT, e);
		}
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}	

}
