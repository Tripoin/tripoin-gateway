package id.co.tripoin.core.integration.endpoint.impl;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import id.co.tripoin.core.constant.statics.BeanNameConstant;
import id.co.tripoin.core.constant.statics.InfoMarkerConstant;
import id.co.tripoin.core.dto.response.MediaDataResponse;
import id.co.tripoin.core.integration.endpoint.IAPITypeEndpoint;
import id.co.tripoin.core.pojo.APIType;
import id.co.tripoin.core.service.IAPITypeService;

/**
 * @author <a href="mailto:rudy.fridian91@gmail.com">Rudy Fridian</a>
 */
@Component(BeanNameConstant.API_TYPE_ENDPOINT_BEAN)
public class APITypeEndpointImpl implements IAPITypeEndpoint {

	private static Logger LOGGER = LoggerFactory
			.getLogger(APITypeEndpointImpl.class);

	@Autowired
	IAPITypeService apiTypeService;

	@Override
	public Response getMedia(String apiTypeCode) {
		MediaDataResponse mediaDataResponse = new MediaDataResponse();
		try {
			LOGGER.info("API TYPE CODE : {}".concat(apiTypeCode));
			APIType aPIType = apiTypeService.findByApiTypeCode(apiTypeCode);
			mediaDataResponse.setApiTypeCode(aPIType.getCode());
			mediaDataResponse.setApiTypeName(aPIType.getName());
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
