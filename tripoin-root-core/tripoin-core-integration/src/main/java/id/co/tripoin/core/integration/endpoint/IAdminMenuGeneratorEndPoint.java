package id.co.tripoin.core.integration.endpoint;

import id.co.tripoin.core.constant.statics.PathNameConstant;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * created on 1/3/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IAdminMenuGeneratorEndPoint{

    @Produces({ MediaType.APPLICATION_JSON })
    @GET
    @Path(PathNameConstant.PATH_ADMIN_MENU_GENERATOR)
    public Response generateMenu();
}
