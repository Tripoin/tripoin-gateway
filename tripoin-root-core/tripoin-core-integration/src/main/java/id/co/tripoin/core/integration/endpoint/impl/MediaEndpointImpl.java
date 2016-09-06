package id.co.tripoin.core.integration.endpoint.impl;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import id.co.tripoin.constant.statics.BeanNameConstant;
import id.co.tripoin.constant.statics.InfoMarkerConstant;
import id.co.tripoin.core.dto.response.MediaDataResponse;
import id.co.tripoin.core.integration.endpoint.IMediaEndpoint;
import id.co.tripoin.core.pojo.APIType;
import id.co.tripoin.core.service.IMediaService;

/**
 * @author <a href="mailto:rudy.fridian91@gmail.com">Rudy Fridian</a>
 */
@Component(BeanNameConstant.MEDIA_ENDPOINT_BEAN)
public class MediaEndpointImpl implements IMediaEndpoint {

	private static Logger LOGGER = LoggerFactory
			.getLogger(MediaEndpointImpl.class);

	@Autowired
	IMediaService mediaService;

	@Override
	public Response getMedia(String apiTypeCode) {
		MediaDataResponse mediaDataResponse = new MediaDataResponse();
		try {
			APIType aPIType = mediaService.findByApiTypeCode(apiTypeCode);
			mediaDataResponse.setApiTypeCode(aPIType.getApiTypeCode());
			mediaDataResponse.setApiTypeName(aPIType.getApiTypeName());
			mediaDataResponse.setApiTypeIdentifier(aPIType.getApiTypeIdentifier());
			mediaDataResponse.setApiTypeSecret(aPIType.getApiTypeSecret());
			mediaDataResponse.setApiTypeHost(aPIType.getApiTypeHost());
			mediaDataResponse.setApiTypePort(aPIType.getApiTypePort());
			mediaDataResponse.setApiTypeProtocol(aPIType.getApiTypeProtocol());
			mediaDataResponse.setApiTypeRedirect(aPIType.getApiTypeRedirect());
			mediaDataResponse.setApiTypeExpired(aPIType.getApiTypeExpired());
		} catch (Exception e) {
			LOGGER.error(InfoMarkerConstant.ERR_PROFILE_ENDPOINT, e);
			return Response.serverError().build();
		}
		return Response.ok(mediaDataResponse).build();
	}

}
