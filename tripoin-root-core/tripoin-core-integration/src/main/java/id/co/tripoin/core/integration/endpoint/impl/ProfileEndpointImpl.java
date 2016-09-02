package id.co.tripoin.core.integration.endpoint.impl;

import id.co.tripoin.constant.enums.EResponseCode;
import id.co.tripoin.constant.statics.BeanNameConstant;
import id.co.tripoin.constant.statics.InfoMarkerConstant;
import id.co.tripoin.core.dto.response.ProfileDataResponse;
import id.co.tripoin.core.integration.endpoint.IProfileEndpoint;
import id.co.tripoin.core.integration.endpoint.UserAuthentication;
import id.co.tripoin.core.integration.handler.ABaseResponseHandler;
import id.co.tripoin.core.pojo.Profile;
import id.co.tripoin.core.service.IProfileService;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Component(BeanNameConstant.PROFILE_ENDPOINT_BEAN)
public class ProfileEndpointImpl extends ABaseResponseHandler implements IProfileEndpoint {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ProfileEndpointImpl.class);	
	
	@Autowired
	IProfileService profileService;

	@Override
	public Response getProfile() {
		ProfileDataResponse profileDataResponse = new ProfileDataResponse();
		try {
			Profile profile = profileService.findByUsername(UserAuthentication.getInstance().getCurrentUsername());
			profileDataResponse.setAddress(profile.getAddress());
			profileDataResponse.setBio(profile.getBio());
			profileDataResponse.setBirthdate(profile.getBirthdate());
			profileDataResponse.setEmail(profile.getEmail());
			profileDataResponse.setGender(profile.getGender());
			profileDataResponse.setName(profile.getName());
			profileDataResponse.setPhone(profile.getPhone());
			profileDataResponse.setPhoto(profile.getPhoto());
			profileDataResponse.setUsername(profile.getUser().getUsername());
		} catch (Exception e) {
			LOGGER.error(InfoMarkerConstant.ERR_ENDPOINT, e);
			return abort();
		}
		return Response.ok(profileDataResponse).build();
	}

	@Override
	public EResponseCode getResponseCode() {
		return EResponseCode.RC_BAD_REQUEST;
	}

}