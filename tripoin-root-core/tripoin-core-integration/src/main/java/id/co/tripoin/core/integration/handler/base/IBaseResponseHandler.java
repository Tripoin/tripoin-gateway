package id.co.tripoin.core.integration.handler.base;

import id.co.tripoin.constant.enums.EResponseCode;

import javax.ws.rs.core.Response;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public interface IBaseResponseHandler {

	public Response abort();
	
	public EResponseCode getResponseCode();
	
}
