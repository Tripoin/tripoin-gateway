package id.co.tripoin.core.integration.endpoint.impl;

import id.co.tripoin.core.constant.enums.EResponseCode;
import id.co.tripoin.core.constant.statics.BeanNameConstant;
import id.co.tripoin.core.dto.ResponseData;
import id.co.tripoin.core.integration.endpoint.IConnectionEndpoint;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;

/**
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Component(BeanNameConstant.CONNECTION_ENDPOINT_BEAN)
public class ConnectionEndpointImpl implements IConnectionEndpoint {

	@Override
	public Response getTest() {
		return Response.ok(new ResponseData(EResponseCode.RC_SUCCESS.getResponseCode(), EResponseCode.RC_SUCCESS.getResponseMsg())).build();
	}

}
