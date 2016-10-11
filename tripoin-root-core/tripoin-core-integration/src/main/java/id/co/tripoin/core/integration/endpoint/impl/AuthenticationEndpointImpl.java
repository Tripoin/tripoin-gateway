package id.co.tripoin.core.integration.endpoint.impl;

import id.co.tripoin.core.constant.enums.EResponseCode;
import id.co.tripoin.core.constant.statics.BeanNameConstant;
import id.co.tripoin.core.constant.statics.InfoMarkerConstant;
import id.co.tripoin.core.dto.ResponseData;
import id.co.tripoin.core.dto.request.AuthenticationDataRequest;
import id.co.tripoin.core.integration.endpoint.IAuthenticationEndpoint;
import id.co.tripoin.core.integration.exception.UsernameFaultException;
import id.co.tripoin.core.integration.handler.base.ABaseResponseHandler;
import id.co.tripoin.core.integration.handler.base.ILogoutContext;
import id.co.tripoin.core.integration.servlet.UserAuthenticationContext;
import id.co.tripoin.core.pojo.SecurityUserDetails;
import id.co.tripoin.core.service.util.IAuthenticationService;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Component(BeanNameConstant.AUTHENTICATION_ENDPOINT_BEAN)
public class AuthenticationEndpointImpl extends ABaseResponseHandler implements IAuthenticationEndpoint {
	
	private static Logger LOGGER = LoggerFactory.getLogger(AuthenticationEndpointImpl.class);
	
	@Autowired
	private IAuthenticationService authenticationService;
	
	/*@Autowired
	private ILogoutContext logoutContext;*/

	@Override
	public Response putChange(AuthenticationDataRequest authenticationDataRequest) {
		try {
			if(!authenticationDataRequest.getOldAccess().isEmpty() && !authenticationDataRequest.getNewAccess().isEmpty()){
				SecurityUserDetails securityUserDetails = authenticationService.login(UserAuthenticationContext.getInstance().getCurrentUsername());
				if(!securityUserDetails.getPassword().equals(authenticationDataRequest.getOldAccess()) ||
						securityUserDetails.getPassword().isEmpty())
					throw new UsernameFaultException(InfoMarkerConstant.ERR_PASSWORD_NOT_VALID);
				int result = authenticationService.change(authenticationDataRequest.getNewAccess(), UserAuthenticationContext.getInstance().getCurrentUsername());
				if(result != 1)
					throw new Exception();
				/*logoutContext.onLogoutSuccess();*/
			}else
				throw new UsernameFaultException(InfoMarkerConstant.ERR_PASSWORD_NOT_VALID);
		} catch (UsernameFaultException ufe) {
			LOGGER.error(InfoMarkerConstant.ERR_AUTHENTICATION_ENDPOINT, ufe.getMessage());
			this.responseCode = EResponseCode.RC_ACCESS_NOT_VALID;
			return abort();
		} catch (Exception e) {
			LOGGER.error(InfoMarkerConstant.ERR_ENDPOINT, e);
			this.responseCode = EResponseCode.RC_BAD_REQUEST;
			return abort();
		}
		return Response.ok(new ResponseData(EResponseCode.RC_SUCCESS.getResponseCode(), EResponseCode.RC_SUCCESS.getResponseMsg())).build();
	}

	@Override
	public EResponseCode getResponseCode() {
		return responseCode;
	}

}