package id.co.tripoin.core.integration.endpoint.impl;

import id.co.tripoin.core.constant.enums.EResponseCode;
import id.co.tripoin.core.constant.statics.InfoMarkerConstant;
import id.co.tripoin.core.constant.statics.PathNameConstant;
import id.co.tripoin.core.dto.ResponseData;
import id.co.tripoin.core.dto.request.AuthTokenDataRequest;
import id.co.tripoin.core.dto.response.AuthTokenDataResponse;
import id.co.tripoin.core.integration.endpoint.IAuthenticationTokenEndpoint;
import id.co.tripoin.core.integration.security.TokenUtils;
import id.co.tripoin.core.integration.security.TripoinUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@RestController
@RequestMapping(path = PathNameConstant.PATH_AUTH, produces = { MediaType.APPLICATION_JSON_VALUE })
public class AuthenticationTokenEndpointImpl implements IAuthenticationTokenEndpoint {
	
	private static Logger LOGGER = LoggerFactory.getLogger(AuthenticationTokenEndpointImpl.class);

	@Value("${eth.token.header}")
	private String tokenHeader;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenUtils tokenUtils;

	@Autowired
	private TripoinUserDetailsService tripoinUserDetailsService;
	
	private EResponseCode responseCode;

	@Override
	@RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> auth(@RequestBody(required = false) AuthTokenDataRequest authTokenDataRequest) {
		if(authTokenDataRequest == null){
			setResponseCode(EResponseCode.RC_BAD_REQUEST);
			return abort();
		}
		try {
			Authentication authentication = this.authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							authTokenDataRequest.getUsername(),
							authTokenDataRequest.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
		} catch (BadCredentialsException bce) {
			setResponseCode(EResponseCode.RC_BAD_CREDENTIALS);
			return abort();
		} catch (AuthenticationException ae) {
			setResponseCode(EResponseCode.RC_BAD_CREDENTIALS);
			return abort();
		} catch (Exception e) {
			setResponseCode(EResponseCode.RC_FAILURE);
			return abort();
		}

		AuthTokenDataResponse authTokenDataResponse = new AuthTokenDataResponse();
		try {
			UserDetails userDetails = this.tripoinUserDetailsService.loadUserByUsername(authTokenDataRequest.getUsername());
			String token = this.tokenUtils.generateToken(userDetails, new Device() {
				@Override
				public boolean isTablet() {
					return false;
				}

				@Override
				public boolean isNormal() {
					return true;
				}

				@Override
				public boolean isMobile() {
					return false;
				}
			});
			authTokenDataResponse.setToken(token);
		} catch (Exception e) {
			setResponseCode(EResponseCode.RC_FAILURE);
			return abort();
		}
		return ResponseEntity.ok(authTokenDataResponse);
	}

	@Override
	@RequestMapping(path = PathNameConstant.PATH_REFRESH, method = RequestMethod.GET)
	public ResponseEntity<?> refresh(HttpServletRequest request) {
		try {
			String token = request.getHeader(this.tokenHeader);
			if (this.tokenUtils.canTokenBeRefreshed(token)) {
				String refreshedToken = this.tokenUtils.refreshToken(token);
				AuthTokenDataResponse authTokenDataResponse = new AuthTokenDataResponse();
				authTokenDataResponse.setToken(refreshedToken);
				return ResponseEntity.ok(authTokenDataResponse);
			} else {
				SecurityContextHolder.clearContext();
				setResponseCode(EResponseCode.RC_BAD_CREDENTIALS);
				return abort();
			}
		} catch (Exception e) {
			SecurityContextHolder.clearContext();
			LOGGER.error(InfoMarkerConstant.ERR_ENDPOINT, e);
			setResponseCode(EResponseCode.RC_ACCESS_DENIED);
			return abort();
		}
	}	

	public ResponseEntity<?> abort() {
		ResponseData responseData = new ResponseData();
		responseData.setResponseCode(getResponseCode().getResponseCode());
		responseData.setResponseMsg(getResponseCode().getResponseMsg());
		return ResponseEntity.status(getResponseCode().getHttpResponse()).contentType(MediaType.APPLICATION_JSON).body(responseData);		
	}

	public EResponseCode getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(EResponseCode responseCode) {
		this.responseCode = responseCode;
	}

}