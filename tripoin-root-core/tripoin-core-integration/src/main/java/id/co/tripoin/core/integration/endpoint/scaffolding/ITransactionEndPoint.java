package id.co.tripoin.core.integration.endpoint.scaffolding;

import id.co.tripoin.core.constant.statics.PathNameConstant;
import id.co.tripoin.core.dto.request.BaseRequestDTO;
import id.co.tripoin.core.integration.endpoint.exception.EndPointException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.util.List;

/**
 * created on 10/15/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 * @param <ID>
 */
public interface ITransactionEndPoint<DATA, ID extends Serializable> extends IApprovalEndPoint, ICancellationEndPoint {

    @POST
    @Path(PathNameConstant.PathScaffolding.PATH_UPDATE)
    Response updateData(BaseRequestDTO p_BaseRequestDTO) throws EndPointException;

    @POST
    @Path(PathNameConstant.PathScaffolding.PATH_INSERT)
    Response insertData(DATA p_DATA) throws EndPointException;

    @POST
    @Path(PathNameConstant.PathScaffolding.PATH_INSERT_AND_FLUSH)
    Response insertAndFlushData(DATA p_DATA) throws EndPointException;

    @POST
    @Path(PathNameConstant.PathScaffolding.PATH_INSERT_COLLECTION)
    Response insertCollection(List<DATA> p_DATAs) throws EndPointException;

    @POST
    @Path(PathNameConstant.PathScaffolding.PATH_DELETE)
    Response delete(ID p_ID) throws EndPointException;

    @POST
    @Path(PathNameConstant.PathScaffolding.PATH_DELETE_BY_ENTITY)
    Response deleteByEntity(DATA p_DATA) throws EndPointException;

    @POST
    @Path(PathNameConstant.PathScaffolding.PATH_DELETE_COLLECTION)
    Response deleteCollection(List<DATA> p_DATAs) throws EndPointException;
}
