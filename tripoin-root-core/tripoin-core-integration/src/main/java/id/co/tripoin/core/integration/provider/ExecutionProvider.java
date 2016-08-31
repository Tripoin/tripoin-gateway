package id.co.tripoin.core.integration.provider;

import id.co.tripoin.constant.enums.EResponseCode;
import id.co.tripoin.constant.statics.CommonConstant;
import id.co.tripoin.core.dto.ResponseData;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.springframework.http.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class ExecutionProvider {

	private static ExecutionProvider instance = null;
	private ExecutionProvider() {}

	public static ExecutionProvider getInstance() {
		if (instance == null) {
			instance = new ExecutionProvider();
		}
		return instance;
	}
	
	public void abort(ContainerRequestContext context, EResponseCode responseCode) throws JsonProcessingException{
		ResponseData responseData = new ResponseData();
		responseData.setResponseCode(responseCode.getResponseCode());
		responseData.setResponseMsg(responseCode.getResponseMsg());
		ObjectMapper mapperJson = new ObjectMapper();
		ResponseBuilder responseBuilder = Response.status(responseCode.getHttpResponse());
		responseBuilder.entity(mapperJson.writeValueAsString(responseData));
		responseBuilder.header(CommonConstant.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		context.abortWith(responseBuilder.build());
	}
	
}