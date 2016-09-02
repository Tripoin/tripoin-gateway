package id.co.tripoin.core.integration.endpoint;

import id.co.tripoin.constant.enums.EResponseCode;
import id.co.tripoin.constant.statics.CommonConstant;
import id.co.tripoin.core.dto.ResponseData;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.springframework.http.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public abstract class AbstractEndpoint {
	
	public Response abort() {
		ResponseData responseData = new ResponseData();
		responseData.setResponseCode(getResponseCode().getResponseCode());
		responseData.setResponseMsg(getResponseCode().getResponseMsg());
		ObjectMapper mapperJson = new ObjectMapper();
		ResponseBuilder responseBuilder = Response.status(getResponseCode().getHttpResponse());
		try {
			responseBuilder.entity(mapperJson.writeValueAsString(responseData));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		responseBuilder.header(CommonConstant.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		return responseBuilder.build();
	}

	public abstract EResponseCode getResponseCode();
	
}