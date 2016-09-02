package id.co.tripoin.core.integration.endpoint.impl;

import id.co.tripoin.constant.enums.EResponseCode;
import id.co.tripoin.constant.statics.BeanNameConstant;
import id.co.tripoin.constant.statics.InfoMarkerConstant;
import id.co.tripoin.core.dto.ResponseData;
import id.co.tripoin.core.dto.request.AuthenticationDataRequest;
import id.co.tripoin.core.integration.endpoint.AbstractEndpoint;
import id.co.tripoin.core.integration.endpoint.IAuthenticationEndpoint;
import id.co.tripoin.core.integration.endpoint.UserAuthentication;
import id.co.tripoin.core.integration.handler.ILogoutContext;
import id.co.tripoin.core.pojo.SecurityUserDetails;
import id.co.tripoin.core.service.util.IAuthenticationService;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tripoin.util.exception.UsernameFaultException;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Component(BeanNameConstant.AUTHENTICATION_ENDPOINT_BEAN)
public class AuthenticationEndpointImpl extends AbstractEndpoint implements IAuthenticationEndpoint {
	
	private static Logger LOGGER = LoggerFactory.getLogger(AuthenticationEndpointImpl.class);
	private EResponseCode responseCode;
	
	@Autowired
	private IAuthenticationService authenticationService;
	
	@Autowired
	private ILogoutContext logoutContext;

	@Override
	public Response postChange(AuthenticationDataRequest authenticationDataRequest) {
		try {			
			if(!authenticationDataRequest.getOldAccess().isEmpty() && !authenticationDataRequest.getNewAccess().isEmpty()){
				SecurityUserDetails securityUserDetails = authenticationService.login(UserAuthentication.getInstance().getCurrentUsername());
				if(!securityUserDetails.getPassword().equals(authenticationDataRequest.getOldAccess()) ||
						securityUserDetails.getPassword().isEmpty())
					throw new UsernameFaultException(InfoMarkerConstant.ERR_PASSWORD_NOT_VALID);
				int result = authenticationService.change(UserAuthentication.getInstance().getCurrentUsername(), authenticationDataRequest.getNewAccess());
				if(result != 1)
					throw new Exception();
				logoutContext.onLogoutSuccess();
			}else
				throw new UsernameFaultException(InfoMarkerConstant.ERR_PASSWORD_NOT_VALID);
		} catch (UsernameFaultException ufe) {
			LOGGER.error(InfoMarkerConstant.ERR_AUTHENTICATION_ENDPOINT, ufe);
			this.setResponseCode(EResponseCode.RC_ACCESS_NOT_VALID);
			return abort();
		} catch (Exception e) {
			LOGGER.error(InfoMarkerConstant.ERR_AUTHENTICATION_ENDPOINT, e);
			this.setResponseCode(EResponseCode.RC_BAD_REQUEST);
			return abort();
		}
		return Response.ok(new ResponseData(EResponseCode.RC_SUCCESS.getResponseCode(), EResponseCode.RC_SUCCESS.getResponseMsg())).build();
	}

	@Override
	public EResponseCode getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(EResponseCode responseCode) {
		this.responseCode = responseCode;
	}

}