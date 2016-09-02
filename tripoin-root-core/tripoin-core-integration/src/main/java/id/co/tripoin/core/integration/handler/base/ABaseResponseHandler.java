package id.co.tripoin.core.integration.handler.base;

import id.co.tripoin.core.dto.ResponseData;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.springframework.http.MediaType;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public abstract class ABaseResponseHandler implements IBaseResponseHandler {

	@Override
	public Response abort() {
		ResponseData responseData = new ResponseData();
		responseData.setResponseCode(getResponseCode().getResponseCode());
		responseData.setResponseMsg(getResponseCode().getResponseMsg());
		ResponseBuilder responseBuilder = Response.status(getResponseCode().getHttpResponse());
		responseBuilder.entity(responseData);
		responseBuilder.type(MediaType.APPLICATION_JSON_VALUE);
		return responseBuilder.build();
	}
	
}
