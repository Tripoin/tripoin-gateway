package id.co.tripoin.core.integration.endpoint;

import id.co.tripoin.core.constant.statics.PathNameConstant;
import id.co.tripoin.core.dto.request.producttype.InsertDataProductTypeDTO;
import id.co.tripoin.core.integration.endpoint.exception.EndPointException;
import id.co.tripoin.core.integration.endpoint.scaffolding.IScaffoldingEndPoint;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * 
 */
@Produces({ MediaType.APPLICATION_JSON })
public interface IProductTypeEndPoint extends IScaffoldingEndPoint {

    @POST
    @Path(PathNameConstant.ProductType.INSERT_DATA)
    void insertData(InsertDataProductTypeDTO p_InsertDataProductTypeDTO) throws EndPointException;
}
