package id.co.tripoin.core.integration.endpoint.scaffolding;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 */
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public interface IUpdateEndPoint<DATA> {

	@PUT
	@Path("/update")
	public void update(ArrayList<DATA> p_DATA);
}
