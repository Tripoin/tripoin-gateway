package id.co.tripoin.core.integration.endpoint;

import id.co.tripoin.core.constant.statics.PathNameConstant.PathScaffolding;
import id.co.tripoin.core.dto.request.RequestFindByCode;
import id.co.tripoin.core.dto.request.RequestFindById;
import id.co.tripoin.core.dto.request.RequestFindByName;
import id.co.tripoin.core.dto.request.RequestPagination;
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
 */
public interface IScaffoldingEndPoint {
	
	@GET
	@Path(PathScaffolding.PATH_SELECT_ALL)
	public Response findAll() throws EndPointException;

	@GET
	@Path(PathScaffolding.PATH_SELECT_ALL_PAGINATION)
	public Response findPaginationAll(RequestPagination p_RequestPagination) throws EndPointException;

	/*Property ID*/
	@POST
	@Path(PathScaffolding.PATH_FIND_BY_ID)
	@Consumes({MediaType.APPLICATION_JSON})
	public Response findById(RequestFindById p_RequestFindById) throws EndPointException;

	/*Property Code*/
	@POST
	@Path(PathScaffolding.PATH_FIND_BY_CODE)
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response findByCode(RequestFindByCode p_RequestFindByCode) throws EndPointException;
	
	@POST
	@Path(PathScaffolding.PATH_FIND_BY_CODE_ORDER_BY_ID_ASC)
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response findByCodeOrderByIdAsc(RequestFindByCode p_RequestFindByCode) throws EndPointException;
	
	@POST
	@Path(PathScaffolding.PATH_FIND_BY_CODE_ORDER_BY_CODE_ASC)
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response findByCodeOrderByCodeAsc(RequestFindByCode p_RequestFindByCode) throws EndPointException;
	
	@POST
	@Path(PathScaffolding.PATH_FIND_PAGINATION_BY_CODE)
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response findPaginationByCodeOrderByCodeAsc(RequestFindByCode p_RequestFindByCode) throws EndPointException;


	/*Property Name*/
	@POST
	@Path(PathScaffolding.PATH_FIND_BY_NAME)
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response findByName(RequestFindByName p_RequestFindByName) throws EndPointException;

	@POST
	@Path(PathScaffolding.PATH_FIND_BY_NAME_ORDER_BY_ID_ASC)
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response findByNameOrderByIdAsc(RequestFindByName p_RequestFindByName) throws EndPointException;

	@POST
	@Path(PathScaffolding.PATH_FIND_BY_CODE_ORDER_BY_NAME_ASC)
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response findByNameOrderByNameAsc(RequestFindByName p_RequestFindByName) throws EndPointException;

	@POST
	@Path(PathScaffolding.PATH_FIND_PAGINATION_BY_NAME)
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response findPaginationByNameOrderByNameAsc(RequestFindByName p_RequestFindByName) throws EndPointException;

}
