package id.co.tripoin.core.integration.handler.base;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public interface ILogoutContext {

	public void onLogoutSuccess(HttpServletRequest request) throws IOException, ServletException;
	
	public void onLogoutSuccess() throws IOException, ServletException;
	
}
