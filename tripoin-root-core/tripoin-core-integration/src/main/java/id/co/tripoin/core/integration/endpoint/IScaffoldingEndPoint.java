package id.co.tripoin.core.integration.endpoint;

import java.util.List;

import id.co.tripoin.core.constant.statics.PathNameConstant;
import id.co.tripoin.core.dto.request.RequestFindByCode;
import id.co.tripoin.core.dto.request.RequestFindByName;
import id.co.tripoin.core.integration.endpoint.exception.EndPointException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 */
public interface IScaffoldingEndPoint<DATA> {
	
	@GET
	@Path(PathNameConstant.PATH_SELECT_ALL)
	public Response findAll() throws EndPointException;
	
	@POST
	@Path(PathNameConstant.PATH_FIND_BY_CODE)
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response findByCode(RequestFindByCode p_RequestFindByCode) throws EndPointException;
	
	@POST
	@Path(PathNameConstant.PATH_FIND_BY_NAME)
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response findByName(RequestFindByName p_RequestFindByName) throws EndPointException;
	
	public Response constructFindResponse(List<DATA> p_DATA) throws EndPointException;
}
