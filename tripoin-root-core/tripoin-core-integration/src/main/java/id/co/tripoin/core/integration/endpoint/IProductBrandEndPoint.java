package id.co.tripoin.core.integration.endpoint;

import id.co.tripoin.core.integration.endpoint.scaffolding.IScaffoldingEndPoint;
import id.co.tripoin.core.pojo.pos.ProductBrand;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * created on 10/19/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Produces({ MediaType.APPLICATION_JSON })
public interface IProductBrandEndPoint extends IScaffoldingEndPoint<ProductBrand, Long>{
}
