package id.co.tripoin.core.integration.handler.base;

import java.io.IOException;
import java.io.PrintWriter;

import id.co.tripoin.core.constant.enums.EResponseCode;
import id.co.tripoin.core.dto.ResponseData;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public abstract class AbstractHandler {
	
	public void handle(HttpServletResponse response) throws IOException{
		ResponseData responseData = new ResponseData();
		responseData.setResponseCode(getResponseCode().getResponseCode());
		responseData.setResponseMsg(getResponseCode().getResponseMsg());
		ObjectMapper mapperJson = new ObjectMapper();
		PrintWriter writer = response.getWriter();
		writer.println(mapperJson.writeValueAsString(responseData));
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.setStatus(getResponseCode().getHttpResponse());
	}
	
	public abstract EResponseCode getResponseCode();

}
