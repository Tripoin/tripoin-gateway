package id.co.tripoin.core.integration.endpoint;

import id.co.tripoin.core.constant.statics.PathNameConstant;
import id.co.tripoin.core.integration.endpoint.scaffolding.IScaffoldingEndPoint;
import id.co.tripoin.core.pojo.master.APIType;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author <a href="mailto:rudy.fridian91@gmail.com">Rudy Fridian</a>
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
@Path(PathNameConstant.BaseMaster.API_TYPE)
public interface IAPITypeEndpoint extends IScaffoldingEndPoint<APIType> {

	@GET
	@Path(PathNameConstant.PATH_API_TYPE_CODE)
	public Response getMedia(@PathParam(value = PathNameConstant.PARAM_API_TYPE_CODE) String apiTypeCode);
	
}
