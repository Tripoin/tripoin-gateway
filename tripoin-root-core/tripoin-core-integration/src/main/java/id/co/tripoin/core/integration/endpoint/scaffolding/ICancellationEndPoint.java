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
public interface ICancellationEndPoint {

    @PUT
    @Path(PathNameConstant.PathScaffolding.PATH_CANCEL_ALL)
    Response cancelAll() throws EndPointException;

    @PUT
    @Path(PathNameConstant.PathScaffolding.PATH_CANCEL_SINGLE_DATA)
    Response cancelSingleData(RequestID p_RequestID) throws EndPointException;
}
