package id.co.tripoin.core.integration.endpoint;

import id.co.tripoin.core.constant.statics.PathNameConstant;
import id.co.tripoin.core.integration.endpoint.scaffolding.IScaffoldingEndPoint;
import id.co.tripoin.core.pojo.pos.ProductType;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 */
@Produces({ MediaType.APPLICATION_JSON })
@Path(value = PathNameConstant.ProductType.PATH)
public interface IProductTypeEndPoint extends IScaffoldingEndPoint<ProductType, Long> {
}
