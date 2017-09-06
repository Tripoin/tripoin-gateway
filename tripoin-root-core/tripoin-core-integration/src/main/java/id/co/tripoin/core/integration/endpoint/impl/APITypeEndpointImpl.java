package id.co.tripoin.core.integration.endpoint.impl;

import id.co.tripoin.core.constant.statics.BeanNameConstant;
import id.co.tripoin.core.constant.statics.InfoMarkerConstant;
import id.co.tripoin.core.dto.request.MediaResponseDTO;
import id.co.tripoin.core.integration.endpoint.IAPITypeEndpoint;
import id.co.tripoin.core.integration.endpoint.scaffolding.impl.AScaffoldingEndPoint;
import id.co.tripoin.core.pojo.master.APIType;
import id.co.tripoin.core.service.IAPITypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ws.rs.core.Response;

/**
 * @author <a href="mailto:rudy.fridian91@gmail.com">Rudy Fridian</a>
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component(BeanNameConstant.API_TYPE_ENDPOINT_BEAN)
public class APITypeEndpointImpl extends AScaffoldingEndPoint<APIType> implements IAPITypeEndpoint {

	private static Logger LOGGER = LoggerFactory
			.getLogger(APITypeEndpointImpl.class);

	@Autowired
	IAPITypeService apiTypeService;

	@Override
	public Response getMedia(String apiTypeCode) {
		MediaResponseDTO mediaResponseDTO = new MediaResponseDTO();
		try {
			LOGGER.info("API TYPE CODE : {}".concat(apiTypeCode));
			APIType aPIType = apiTypeService.findByApiTypeCode(apiTypeCode);
			mediaResponseDTO.setApiTypeCode(aPIType.getCode());
			mediaResponseDTO.setApiTypeName(aPIType.getName());
			mediaResponseDTO.setApiTypeIdentifier(aPIType.getApiTypeIdentifier());
			mediaResponseDTO.setApiTypeSecret(aPIType.getApiTypeSecret());
			mediaResponseDTO.setApiTypeHost(aPIType.getApiTypeHost());
			mediaResponseDTO.setApiTypePort(aPIType.getApiTypePort());
			mediaResponseDTO.setApiTypeProtocol(aPIType.getApiTypeProtocol());
			mediaResponseDTO.setApiTypeRedirect(aPIType.getApiTypeRedirect());
			mediaResponseDTO.setApiTypeExpired(aPIType.getApiTypeExpired());
		} catch (Exception e) {
			LOGGER.error(InfoMarkerConstant.ERR_PROFILE_ENDPOINT, e);
			return Response.serverError().build();
		}
		return Response.ok(mediaResponseDTO).build();
	}

	@PostConstruct
	@Override
	public void init() {
		scaffoldingService = apiTypeService;
	}

}
