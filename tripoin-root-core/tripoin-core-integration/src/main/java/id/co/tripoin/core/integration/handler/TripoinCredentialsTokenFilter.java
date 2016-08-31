package id.co.tripoin.core.integration.handler;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.exceptions.BadClientCredentialsException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.HttpRequestMethodNotSupportedException;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class TripoinCredentialsTokenFilter extends AbstractAuthenticationProcessingFilter {
	private AuthenticationEntryPoint authenticationEntryPoint;
	private boolean allowOnlyPost;

	public TripoinCredentialsTokenFilter() {
		this("/oauth/token");
	}

	public TripoinCredentialsTokenFilter(String path) {
		super(path);
		this.allowOnlyPost = false;
		setRequiresAuthenticationRequestMatcher(new ClientCredentialsRequestMatcher(path));
	}

	public void setAllowOnlyPost(boolean allowOnlyPost) {
		this.allowOnlyPost = allowOnlyPost;
	}

	public void setAuthenticationEntryPoint(AuthenticationEntryPoint authenticationEntryPoint) {
		this.authenticationEntryPoint = authenticationEntryPoint;
	}

	public void afterPropertiesSet() {
		super.afterPropertiesSet();
		setAuthenticationFailureHandler(new AuthenticationFailureHandler() {
			public void onAuthenticationFailure(HttpServletRequest request,
					HttpServletResponse response,
					AuthenticationException exception) throws IOException,
					ServletException {
				if (exception instanceof BadCredentialsException) {
					exception = new BadCredentialsException(
							exception.getMessage(),
							new BadClientCredentialsException());
				}
				TripoinCredentialsTokenFilter.this.authenticationEntryPoint
						.commence(request, response, exception);
			}
		});
		setAuthenticationSuccessHandler(new AuthenticationSuccessHandler() {
			public void onAuthenticationSuccess(HttpServletRequest request,
					HttpServletResponse response, Authentication authentication)
					throws IOException, ServletException {
			}
		});
	}

	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException,
			IOException, ServletException {
		if ((this.allowOnlyPost)
				&& (!("POST".equalsIgnoreCase(request.getMethod())))) {
			throw new HttpRequestMethodNotSupportedException(
					request.getMethod(), new String[] { "POST" });
		}

		String clientId = request.getParameter("client_id");
		String clientSecret = request.getParameter("client_secret");

		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		if ((authentication != null) && (authentication.isAuthenticated())) {
			return authentication;
		}

		if (clientId == null) {
			throw new BadCredentialsException("No client credentials presented");
		}

		if (clientSecret == null) {
			clientSecret = "";
		}

		clientId = clientId.trim();
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
				clientId, clientSecret);

		return getAuthenticationManager().authenticate(authRequest);
	}

	protected void successfulAuthentication(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		super.successfulAuthentication(request, response, chain, authResult);
		chain.doFilter(request, response);
	}

	protected static class ClientCredentialsRequestMatcher implements
			RequestMatcher {
		private String path;

		public ClientCredentialsRequestMatcher(String path) {
			this.path = path;
		}

		public boolean matches(HttpServletRequest request) {
			String uri = request.getRequestURI();
			int pathParamIndex = uri.indexOf(59);

			if (pathParamIndex > 0) {
				uri = uri.substring(0, pathParamIndex);
			}

			String clientId = request.getParameter("client_id");

			if (clientId == null) {
				return false;
			}

			if ("".equals(request.getContextPath())) {
				return uri.endsWith(this.path);
			}

			return uri.endsWith(request.getContextPath() + this.path);
		}
	}
}