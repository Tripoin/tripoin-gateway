package id.co.tripoin.core.integration.endpoint.impl;

import id.co.tripoin.core.constant.enums.EResponseCode;
import id.co.tripoin.core.constant.statics.BeanNameConstant;
import id.co.tripoin.core.dto.ResponseData;
import id.co.tripoin.core.dto.request.RequestUpdatePasswordDTO;
import id.co.tripoin.core.dto.request.RequestUpdateProfileDTO;
import id.co.tripoin.core.dto.response.AddressResponseDTO;
import id.co.tripoin.core.dto.response.ContactResponseDTO;
import id.co.tripoin.core.dto.response.ProfileResponseDTO;
import id.co.tripoin.core.integration.endpoint.ISecurityUserProfileEndPoint;
import id.co.tripoin.core.integration.endpoint.scaffolding.impl.AScaffoldingEndPoint;
import id.co.tripoin.core.integration.servlet.UserAuthenticationContext;
import id.co.tripoin.core.pojo.security.SecurityUserProfile;
import id.co.tripoin.core.service.ISecurityUserProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ws.rs.core.Response;

/**
 * created on 12/28/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component(BeanNameConstant.Security.SECURITY_USER_PROFILE_ENDPOINT_BEAN)
public class SecurityUserProfileEndPointImpl extends AScaffoldingEndPoint<SecurityUserProfile> implements ISecurityUserProfileEndPoint {

    @Autowired
    ISecurityUserProfileService securityUserProfileService;

    private static Logger LOGGER = LoggerFactory.getLogger(SecurityUserProfileEndPointImpl.class);

    @PostConstruct
    @Override
    public void init() {
        scaffoldingService = securityUserProfileService;
    }

    @Override
    public Response getProfile() {
        ProfileResponseDTO<AddressResponseDTO, ContactResponseDTO> profileResponseDTO = new ProfileResponseDTO<>();
        try{
            profileResponseDTO = securityUserProfileService.getProfile(UserAuthenticationContext.getInstance().getCurrentUsername());
            profileResponseDTO.setResponseData(new ResponseData(EResponseCode.RC_GET_PROFILE_SUCCESS.getResponseCode(), EResponseCode.RC_GET_PROFILE_SUCCESS.getResponseMsg()));
        }catch (Exception e){
            LOGGER.error("Cannot get profile "+e.toString());
            profileResponseDTO.setResponseData(new ResponseData(EResponseCode.RC_GET_PROFILE_FAILED.getResponseCode(), EResponseCode.RC_GET_PROFILE_FAILED.getResponseMsg()));
        }
        return Response.ok(profileResponseDTO).build();
    }

	@Override
	public Response updateProfile(RequestUpdateProfileDTO p_RequestUpdateProfileDTO) {
        ResponseData responseData;
        try{
            responseData = securityUserProfileService.updateProfile(p_RequestUpdateProfileDTO);
        }catch (Exception e){
            LOGGER.error("Cannot update profile "+e.toString());
            responseData = new ResponseData(EResponseCode.RC_UPDATE_PROFILE_FAILED.getResponseCode(), EResponseCode.RC_UPDATE_PROFILE_FAILED.getResponseMsg());
        }
		return Response.ok(responseData).build();
	}

	@Override
	public Response updatePasword(RequestUpdatePasswordDTO p_RequestUpdatePasswordDTO) {
		ResponseData responseData;
        try{
            responseData = securityUserProfileService.updatePassword(p_RequestUpdatePasswordDTO);
        }catch (Exception e){
            LOGGER.error("Cannot update pasword "+e.toString());
            responseData = new ResponseData(EResponseCode.RC_UPDATE_PASSWORD_FAILED.getResponseCode(), EResponseCode.RC_UPDATE_PASSWORD_FAILED.getResponseMsg());
        }
		return Response.ok(responseData).build();
	}
	
}
