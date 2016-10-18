package id.co.tripoin.core.integration.endpoint.scaffolding;

import id.co.tripoin.core.constant.statics.PathNameConstant;
import id.co.tripoin.core.dto.request.*;
import id.co.tripoin.core.integration.endpoint.exception.EndPointException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * created on 10/15/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IInquiryEndPoint {

    @GET
    @Path(PathNameConstant.PathScaffolding.PATH_FIND_ALL)
    public Response findAll() throws EndPointException;

    @POST
    @Path(PathNameConstant.PathScaffolding.PATH_FIND_ALL_PAGINATION)
    public Response findPaginationAll(RequestPaginationAll p_RequestPaginationAll) throws EndPointException;

    /*Property ID*/
    @POST
    @Path(PathNameConstant.PathScaffolding.PATH_FIND_BY_ID)
    @Consumes({MediaType.APPLICATION_JSON})
    public Response findById(RequestFindById p_RequestFindById) throws EndPointException;

    /*Property Code*/
    @POST
    @Path(PathNameConstant.PathScaffolding.PATH_FIND_BY_CODE)
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response findByCode(RequestFindByCode p_RequestFindByCode) throws EndPointException;

    @POST
    @Path(PathNameConstant.PathScaffolding.PATH_FIND_BY_CODE_ORDER_BY_ID_ASC)
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response findByCodeOrderByIdAsc(RequestFindByCode p_RequestFindByCode) throws EndPointException;

    @POST
    @Path(PathNameConstant.PathScaffolding.PATH_FIND_BY_CODE_ORDER_BY_CODE_ASC)
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response findByCodeOrderByCodeAsc(RequestFindByCode p_RequestFindByCode) throws EndPointException;

    @POST
    @Path(PathNameConstant.PathScaffolding.PATH_FIND_BY_CODE_ORDER_BY_CODE_DESC)
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response findByCodeOrderByCodeDesc(RequestFindByCode p_RequestFindByCode) throws EndPointException;

    @POST
    @Path(PathNameConstant.PathScaffolding.PATH_FIND_PAGINATION_BY_CODE)
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response findPaginationByCodeOrderByCodeAsc(RequestPaginationByCode p_RequestPaginationByCode) throws EndPointException;


    /*Property Name*/
    @POST
    @Path(PathNameConstant.PathScaffolding.PATH_FIND_BY_NAME)
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response findByName(RequestFindByName p_RequestFindByName) throws EndPointException;

    @POST
    @Path(PathNameConstant.PathScaffolding.PATH_FIND_BY_NAME_ORDER_BY_ID_ASC)
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response findByNameOrderByIdAsc(RequestFindByName p_RequestFindByName) throws EndPointException;

    @POST
    @Path(PathNameConstant.PathScaffolding.PATH_FIND_BY_CODE_ORDER_BY_NAME_ASC)
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response findByNameOrderByNameAsc(RequestFindByName p_RequestFindByName) throws EndPointException;

    @POST
    @Path(PathNameConstant.PathScaffolding.PATH_FIND_BY_CODE_ORDER_BY_NAME_DESC)
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response findByNameOrderByNameDesc(RequestFindByName p_RequestFindByName) throws EndPointException;

    @POST
    @Path(PathNameConstant.PathScaffolding.PATH_FIND_PAGINATION_BY_NAME)
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response findPaginationByNameOrderByNameAsc(RequestPaginationByName p_RequestPaginationByName) throws EndPointException;

    @GET
    @Path(PathNameConstant.PathScaffolding.PATH_SELECT_LOV)
    public Response selectLOV() throws EndPointException;
}
