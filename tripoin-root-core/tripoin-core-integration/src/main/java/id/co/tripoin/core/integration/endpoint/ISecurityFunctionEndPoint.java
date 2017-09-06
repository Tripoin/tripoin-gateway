package id.co.tripoin.core.integration.endpoint;

import id.co.tripoin.core.constant.statics.PathNameConstant;
import id.co.tripoin.core.integration.endpoint.scaffolding.IScaffoldingEndPoint;
import id.co.tripoin.core.pojo.security.SecurityFunction;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * created on 1/3/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Produces({ MediaType.APPLICATION_JSON })
@Path(PathNameConstant.Security.PATH_FUNCTION)
public interface ISecurityFunctionEndPoint extends IScaffoldingEndPoint<SecurityFunction> {
}
