package id.co.tripoin.core.integration.endpoint.impl;

import id.co.tripoin.constant.enums.EResponseCode;
import id.co.tripoin.constant.statics.BeanNameConstant;
import id.co.tripoin.constant.statics.InfoMarkerConstant;
import id.co.tripoin.core.dto.ResponseData;
import id.co.tripoin.core.integration.endpoint.AbstractEndpoint;
import id.co.tripoin.core.integration.endpoint.IAuthenticationEndpoint;
import id.co.tripoin.core.integration.endpoint.UserAuthentication;
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

	@Override
	public Response postChange(String oldAccess, String newAccess) {
		try {			
			if(!oldAccess.isEmpty() && !newAccess.isEmpty()){
				SecurityUserDetails securityUserDetails = authenticationService.login(UserAuthentication.getInstance().getCurrentUsername());
				if(!securityUserDetails.getPassword().equals(oldAccess))
					throw new UsernameFaultException(InfoMarkerConstant.ERR_PASSWORD_NOT_EQUALS);
				int result = authenticationService.change(UserAuthentication.getInstance().getCurrentUsername(), newAccess);
				if(result != 1)
					throw new Exception();
			}else
				throw new Exception();
		} catch (UsernameFaultException ufe) {
			LOGGER.error(InfoMarkerConstant.ERR_AUTHENTICATION_ENDPOINT, ufe);
			this.setResponseCode(EResponseCode.RC_ACCESS_NOT_VALID);
			return abort();
		} catch (Exception e) {
			LOGGER.error(InfoMarkerConstant.ERR_AUTHENTICATION_ENDPOINT, e);
			return Response.serverError().build();
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