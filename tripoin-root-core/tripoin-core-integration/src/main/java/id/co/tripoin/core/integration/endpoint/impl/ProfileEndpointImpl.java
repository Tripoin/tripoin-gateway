package id.co.tripoin.core.integration.endpoint.impl;

import id.co.tripoin.constant.statics.BeanNameConstant;
import id.co.tripoin.constant.statics.InfoMarkerConstant;
import id.co.tripoin.core.dto.response.ProfileDataResponse;
import id.co.tripoin.core.integration.endpoint.AuthenticationEndpoint;
import id.co.tripoin.core.integration.endpoint.IProfileEndpoint;
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
public class ProfileEndpointImpl implements IProfileEndpoint {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ProfileEndpointImpl.class);	
	
	@Autowired
	IProfileService profileService;

	@Override
	public Response getProfile() {
		ProfileDataResponse profileDataResponse = new ProfileDataResponse();
		try {
			Profile profile = profileService.findByUsername(AuthenticationEndpoint.getInstance().getCurrentUsername());
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
			LOGGER.error(InfoMarkerConstant.ERR_PROFILE_ENDPOINT, e);
			return Response.serverError().build();
		}
		return Response.ok(profileDataResponse).build();
	}

}
