package id.co.tripoin.core.integration.endpoint;

import id.co.tripoin.core.constant.statics.PathNameConstant;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IScaffoldingEndPoint {
	
	@GET
	@Path(PathNameConstant.PATH_SELECT_ALL)
	public Response findAll();
	
	@POST
	@Path(PathNameConstant.PATH_FIND_BY_CODE)
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response findByCode(String p_Code);
	
	@POST
	@Path(PathNameConstant.PATH_FIND_BY_NAME)
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response findByName(String p_Name);
}
