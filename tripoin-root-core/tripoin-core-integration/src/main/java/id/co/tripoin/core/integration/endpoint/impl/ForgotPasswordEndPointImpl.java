package id.co.tripoin.core.integration.endpoint.impl;

import id.co.tripoin.core.constant.enums.EResponseCode;
import id.co.tripoin.core.constant.statics.BeanNameConstant;
import id.co.tripoin.core.dto.ResponseData;
import id.co.tripoin.core.dto.request.RequestForgotPasswordDTO;
import id.co.tripoin.core.dto.request.RequestResetPasswordDTO;
import id.co.tripoin.core.dto.response.RequestForgotPasswordResponseDTO;
import id.co.tripoin.core.integration.endpoint.IForgotPasswordEndPoint;
import id.co.tripoin.core.service.ISecurityUserProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;

/**
 * created on 2017-03-08
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component(BeanNameConstant.Security.SECURITY_FORGOT_PASSWORD_ENDPOINT_BEAN)
public class ForgotPasswordEndPointImpl implements IForgotPasswordEndPoint {

	@Autowired
	ISecurityUserProfileService securityUserProfileService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ForgotPasswordEndPointImpl.class);
	
	@Override
	public Response forgotPasword(RequestForgotPasswordDTO p_RequestForgotPasswordDTO) {
		RequestForgotPasswordResponseDTO rfPasswordResponseDTO = new RequestForgotPasswordResponseDTO();
		try{
			rfPasswordResponseDTO = securityUserProfileService.requestForgotPassword(p_RequestForgotPasswordDTO);
        }catch (Exception e){
            LOGGER.error("Cannot execute forgot pasword "+e.toString());
            rfPasswordResponseDTO.setResponseData(new ResponseData(EResponseCode.RC_REQUEST_FORGOT_PASSWORD_FAILED.getResponseCode(), EResponseCode.RC_REQUEST_FORGOT_PASSWORD_FAILED.getResponseMsg()));
        }
		return Response.ok(rfPasswordResponseDTO).build();
	}

	@Override
	public Response resetPasword(RequestResetPasswordDTO p_RequestResetPasswordDTO) {
		ResponseData responseData;
        try{        	
            responseData = securityUserProfileService.resetPassword(p_RequestResetPasswordDTO);
        }catch (Exception e){
            LOGGER.error("Cannot reset pasword "+e.toString());
            responseData = new ResponseData(EResponseCode.RC_UPDATE_PASSWORD_FAILED.getResponseCode(), EResponseCode.RC_UPDATE_PASSWORD_FAILED.getResponseMsg());
        }
		return Response.ok(responseData).build();
	}

}
