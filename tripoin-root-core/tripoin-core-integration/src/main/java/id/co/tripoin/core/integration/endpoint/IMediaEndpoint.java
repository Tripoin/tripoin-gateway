package id.co.tripoin.core.integration.endpoint;

import id.co.tripoin.core.dto.request.MediaDataRequest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author <a href="mailto:rudy.fridian91@gmail.com">Rudy Fridian</a>
 */
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public interface IMediaEndpoint {

	@POST
	public Response getMedia(MediaDataRequest mediaDataRequest);
}
