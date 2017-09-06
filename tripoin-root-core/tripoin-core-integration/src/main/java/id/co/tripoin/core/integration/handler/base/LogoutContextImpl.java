package id.co.tripoin.core.integration.handler.base;

import id.co.tripoin.core.constant.statics.CommonConstant;
import id.co.tripoin.core.constant.statics.InfoMarkerConstant;
import id.co.tripoin.core.integration.security.TokenUtils;
import org.apache.cxf.phase.PhaseInterceptorChain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class LogoutContextImpl implements ILogoutContext {
	
	private static Logger LOGGER = LoggerFactory.getLogger(LogoutContextImpl.class);
	
	private JdbcTokenStore tokenStore;	
	private HttpServletRequest request;

	@Value("${eth.token.header}")
	private String tokenHeader;

	@Autowired
	private TokenUtils tokenUtils;

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
		String tokenValue = this.request.getHeader(CommonConstant.AUTHORIZATION);
		if(tokenValue == null)
			tokenValue = this.request.getParameter(CommonConstant.ACCESS_TOKEN);
		else
			tokenValue = tokenValue.replace(CommonConstant.BEARER_PREFIX, "");
		tokenStore.removeAccessToken(tokenValue);
		try {
			SecurityContextHolder.clearContext();
		} catch (Exception e) {
			LOGGER.error(InfoMarkerConstant.ERR_LOGOUT, e);
		}
	}

	@Override
	public void onLogoutSuccessJwt() throws IOException, ServletException {
		if(this.request == null)
			this.setRequest((HttpServletRequest)PhaseInterceptorChain.getCurrentMessage().get(CommonConstant.HTTP_REQUEST));
		String tokenValue = this.request.getHeader(tokenHeader);
		LOGGER.info("Token Value "+tokenValue);
		if(tokenValue != null){
			tokenUtils.setTokenToBeExpired(tokenValue);
			LOGGER.info("Token Set To Expired XX");
			try {
				SecurityContextHolder.clearContext();
				LOGGER.info("Context Security Cleared");
			} catch (Exception e) {
				LOGGER.error(InfoMarkerConstant.ERR_LOGOUT, e);
			}
		}else{
			LOGGER.error(InfoMarkerConstant.ERR_LOGOUT);
		}
	}


	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}	

}
