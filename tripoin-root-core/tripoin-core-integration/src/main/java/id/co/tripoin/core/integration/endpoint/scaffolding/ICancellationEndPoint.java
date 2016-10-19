package id.co.tripoin.core.integration.endpoint.scaffolding;

import id.co.tripoin.core.constant.statics.PathNameConstant;
import id.co.tripoin.core.integration.endpoint.exception.EndPointException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * created on 10/17/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ICancellationEndPoint {

    @POST
    @Path(PathNameConstant.PathScaffolding.PATH_DO_CANCELLATION)
    Response doCancellation() throws EndPointException;
}
