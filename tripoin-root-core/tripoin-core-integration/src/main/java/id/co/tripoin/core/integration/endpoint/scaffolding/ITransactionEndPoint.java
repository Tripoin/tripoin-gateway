package id.co.tripoin.core.integration.endpoint.scaffolding;

import id.co.tripoin.core.constant.statics.PathNameConstant;
import id.co.tripoin.core.dto.request.BaseUpdateDTO;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * created on 10/15/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ITransactionEndPoint extends IApprovalEndPoint, ICancellationEndPoint {

    @POST
    @Path(PathNameConstant.PathScaffolding.PATH_UPDATE)
    Response setBaseDataById(BaseUpdateDTO p_BaseUpdateDTO);

}
