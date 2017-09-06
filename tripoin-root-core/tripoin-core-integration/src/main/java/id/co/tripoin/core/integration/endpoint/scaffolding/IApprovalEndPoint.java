package id.co.tripoin.core.integration.endpoint.scaffolding;

import id.co.tripoin.core.constant.statics.PathNameConstant;
import id.co.tripoin.core.dto.request.RequestID;
import id.co.tripoin.core.integration.endpoint.exception.EndPointException;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * created on 10/17/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IApprovalEndPoint {

    @PUT
    @Path(PathNameConstant.PathScaffolding.PATH_APPROVE_ALL)
    Response approveAll() throws EndPointException;

    @PUT
    @Path(PathNameConstant.PathScaffolding.PATH_APPROVE_SINGLE_DATA)
    Response approveSingleData(RequestID p_RequestID) throws EndPointException;
}
