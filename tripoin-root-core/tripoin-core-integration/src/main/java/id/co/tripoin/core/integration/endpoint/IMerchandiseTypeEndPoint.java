package id.co.tripoin.core.integration.endpoint;

import id.co.tripoin.core.pojo.pos.MerchandiseType;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * 
 */
@Produces({ MediaType.APPLICATION_JSON })
public interface IMerchandiseTypeEndPoint extends IScaffoldingEndPoint<MerchandiseType>{
}
